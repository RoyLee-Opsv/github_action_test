package com.roylee.githubactions

import android.util.Log
import org.junit.Test
import java.lang.Exception
import java.util.regex.Pattern

class VersionTest {

    fun convertVersionCodeFromVersion(version: String): Int {
        return try {
            val versions = version.split(regex = Pattern.compile("\\."))
            val major = versions[0].toInt()
            val minor = versions[1].toInt()
            val patch: Int = try {
                versions[2].toInt()
            } catch (e: NumberFormatException) {
                versions[2].replace("[^\\d.]".toRegex(), "").toInt()
            }
            major * 1000000 + minor * 1000 + patch
        } catch (e: Exception){
//            Firebase.crashlytics.recordException(e)
            0
        }
    }

    @Test
    fun test(){
        val convertVersion = convertVersionCodeFromVersion("0.6.3 (QA)")
        Log.d("version", convertVersion.toString())
        assert(convertVersion == 0)

    }
}
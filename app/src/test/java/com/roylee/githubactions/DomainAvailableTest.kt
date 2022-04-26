package com.roylee.githubactions

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import java.net.InetAddress
import java.net.UnknownHostException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DomainAvailableTest {
    @Test
    fun testDoamianAvailableTest() {
        val MAJOR_EMAIL_DOMAIN = listOf("gmail.com", "naver.com", "daum.net", "hanmail.net")
        for (domain in MAJOR_EMAIL_DOMAIN) {
            assertNotNull(checkDomainAvailable(domain))
        }
    }

    @Test
    fun testWrongDoamianAvailableTest() {
        val WRONG_EMAIL_DOMAIN = listOf("gmail.con", "naver.con", "daum.com", "hanmail.com")
        for (domain in WRONG_EMAIL_DOMAIN) {
            println(domain)
            assertNull(checkDomainAvailable(domain))
        }
    }

    private fun checkDomainAvailable(domain: String): String? {
        val addr: InetAddress = try {
            InetAddress.getByName(domain)
        } catch (e: UnknownHostException) {
            return null
        }
        return addr.hostAddress
    }
}
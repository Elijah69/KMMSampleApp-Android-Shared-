package orgcom.example.myapplication

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greeting().contains("WatchOS"), "Check WatchOS is mentioned")
    }
}
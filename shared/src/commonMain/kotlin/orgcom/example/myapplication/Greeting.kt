package orgcom.example.myapplication

class Greeting {
    fun greeting(): String {
        return "Hello test, ${Platform().platform}!"
    }
}
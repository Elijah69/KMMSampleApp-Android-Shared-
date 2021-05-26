package orgcom.example.wearosapp

import android.app.Activity
import android.os.Bundle
import orgcom.example.wearosapp.databinding.ActivityMainBinding
import orgcom.example.myapplication.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = greet()

    }
}
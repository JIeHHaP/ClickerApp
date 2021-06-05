package com.example.clickerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.clickerapp.databinding.ActivityLoginScreenBinding
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import java.net.URL

class LoginScreen : AppCompatActivity() {

    lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogReg.setOnClickListener {
            val intent = Intent(this, MainCount::class.java)
            startActivity(intent)
            Fuel.post("http://109.237.111.101/clicker/api.php")
                .jsonBody("{ \"action\":\"auth\", \"user\":{\"name\":\"test1\", \"pass\":\"test\"}}")
                .response {  request, response, result ->
                    Log.d("MyLog", response.data.decodeToString())
                }

        }







    }
}
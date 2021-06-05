package com.example.clickerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.clickerapp.databinding.ActivityLoginScreenBinding
import com.example.clickerapp.model.Request
import com.example.clickerapp.model.Response
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogReg.setOnClickListener {
            val etLogin = binding.edLogin.text.toString()
            val etPass = binding.edPassword.text.toString()
            if (etLogin.isEmpty() && etPass.isEmpty()){
                Toast.makeText(this, "Введидте логин и пароль!", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, MainCount::class.java)
                startActivity(intent)

                Fuel.post("http://109.237.111.101/clicker/api.php")
                    .jsonBody(Json.encodeToString(
                        Request(
                        "auth",
                                user = mapOf("name" to etLogin, "pass" to etPass)
                            )
                        )
                    )
                    .response { request, response, result ->
                        val a = Json.decodeFromString(
                            Response.serializer(),
                            response.data.decodeToString()
                        )
                        Log.d("MyLog", "Code: " + a.code)
                        Log.d("MyLog", "Msg: " + a.msg)
                        Log.d("MyLog", "Id: " + a.data["id"])
                    }
            }
        }







    }
}
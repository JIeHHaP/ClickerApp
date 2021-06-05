package com.example.clickerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clickerapp.databinding.ActivityMainCountBinding

class MainCount : AppCompatActivity() {
    private lateinit var binding: ActivityMainCountBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainCountBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            counterPlus()
        }

        binding.bntMinus.setOnClickListener {
            counterMinus()
        }
    }





    fun counterPlus(){
        counter++
        binding.tvCount.text = counter.toString()

    }
    fun counterMinus(){
        if (counter > 0) {
            counter--
            binding.tvCount.text = counter.toString()
        }
    }
}
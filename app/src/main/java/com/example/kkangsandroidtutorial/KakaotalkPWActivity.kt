package com.example.kkangsandroidtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.kkangsandroidtutorial.databinding.ActivityKakaotalkPwactivityBinding
//AppCompatActivity() -> binding할 때는 안됨
class KakaotalkPWActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityKakaotalkPwactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }
}
package com.example.kkangsandroidtutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kkangsandroidtutorial.databinding.ActivityMainBinding
import com.example.kkangsandroidtutorial.ui.theme.KkangsAndroidTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 기존
        // setContentView(R.layout.activity_main)


        // 바인딩 객체 획득하기
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // 액티비티 화면 출력
        setContentView(binding.root)

        binding.testTextView.setText("뷰 바인딩 성공!")

        binding.button1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, KakaotalkPWActivity::class.java)
            startActivity(intent)
        })


    }
}
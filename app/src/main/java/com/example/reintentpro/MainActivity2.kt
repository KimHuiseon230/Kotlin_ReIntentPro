package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.reintentpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 안드로이드 시스템의 인텐트를 받겠다 -> this , 다른 곳에서 받겠다 -> intent 객체 생성
        val name = this.intent.getStringExtra("name")
        val age = this.intent.getIntExtra("age", 10)
        binding.ivPicture.setOnClickListener {
            Toast.makeText(applicationContext, "${name} ${age}", Toast.LENGTH_SHORT).show()
        }
    }
}
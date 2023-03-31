package com.example.reintentpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reintentpro.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {

    val binding: ActivityMain4Binding by lazy { ActivityMain4Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = intent.getIntExtra("x", -1)
        val y = intent.getIntExtra("y", -1)
        val operator = intent.getStringExtra("operator")
        var sum = 0
        when (operator) {
            "+" -> sum = x + y
            "-" -> sum = x - y
            "*" -> sum = x * y
            "%" -> sum = x % y
        }
        binding.btnReturnActivity.setOnClickListener {
            intent.putExtra("sum", sum)
            // 갔다아 왔다 온거기에.. set -> 창을 죽게 해야함
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
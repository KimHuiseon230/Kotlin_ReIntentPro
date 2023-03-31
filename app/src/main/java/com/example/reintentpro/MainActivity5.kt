package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reintentpro.databinding.ActivityMain4Binding
import com.example.reintentpro.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    val binding: ActivityMain5Binding by lazy { ActivityMain5Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = intent.getIntExtra("x", -1)
        val y = intent.getIntExtra("y", -1)
        val operator = intent.getStringExtra("operator")
        var sub = 0
        when (operator) {
            "+" -> sub = x + y
            "-" -> sub = x - y
            "*" -> sub = x * y
            "%" -> sub = x % y
        }
        binding.btnReturnActivity.setOnClickListener {
            intent.putExtra("sub", sub)
            // 갔다아 왔다 온거기에.. set -> 창을 죽게 해야함
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
package com.example.reintentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reintentpro.databinding.ActivityMain6Binding
import com.example.reintentpro.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    val binding: ActivityMain7Binding by lazy { ActivityMain7Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val x = intent.getIntExtra("x", -1)
        val y = intent.getIntExtra("y", -1)
        val operator = intent.getStringExtra("operator")
        var multiply = 0
        when (operator) {
            "+" -> multiply = x + y
            "-" -> multiply = x - y
            "*" -> multiply = x * y
            "%" -> multiply = x % y
        }

        binding.tvX.text =x.toString()
        binding.tvY.text =y.toString()
        binding.tvG.text = multiply.toString()

        binding.btnReturnMain.setOnClickListener {
            intent.putExtra("multiply", multiply)
            // 갔다아 왔다 온거기에.. set -> 창을 죽게 해야함
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
package com.example.reintentpro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.reintentpro.databinding.ActivityMain2Binding
import com.example.reintentpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCallActivity2.setOnClickListener {
            // 누가 불렀어? this , 누구를 부를 거야? MainActivity2를
            // 명시적 인텐트
            val intent: Intent = Intent(this, MainActivity2::class.java)
            // 알아서 안드로이드 시스템(manifest)에서 액티비티가 명시적 이텐트라는 것을 확인 -> 불러줌.
            // 플래그먼트 -> 아규먼트 , 인텐트 -> putExtra
            intent.putExtra("name", "홍길동")
            intent.putExtra("age", 27)
            startActivity(intent)
        }

        binding.btnCallActivity3.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("name", "저길동")
            intent.putExtra("age", 37)
            startActivity(intent)
        }

        binding.btnCallActivity4.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            startActivityForResult(intent, 100)
        }

        binding.btnCallActivity5.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "-")
            startActivityForResult(intent, 101)
        }

        // +++ ActivityResultLauncher Start
        val activityResultLauncher : ActivityResultLauncher<Intent>
        = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            if (it.data?.getIntExtra("requestCode",0) == 103 ) {
                Toast.makeText(applicationContext, "== ${it.data?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show()
            }
            else if (it.data?.getIntExtra("requestCode",0) == 104 ) {
                Toast.makeText(applicationContext, "== ${it.data?.getIntExtra("multiply", 0)}", android.widget.Toast.LENGTH_SHORT).show()
            }
        }// +++ ActivityResultLauncher End

        // +++ btnCallActivity6 Start
        binding.btnCallActivity6.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            intent.putExtra("requestCode", 103)
            activityResultLauncher.launch(intent)
        } // +++ btnCallActivity6 End

        //btnCallActivity7 Start
        binding.btnCallActivity7.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity7::class.java)
            intent.putExtra("x", 45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "*")
            intent.putExtra("requestCode", 104)
            activityResultLauncher.launch(intent)
        }// +++ btnCallActivity7 end

    }//onCreate End

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == 100 && resultCode == RESULT_OK)
        { Toast.makeText(applicationContext, "${intent?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show() }
        /*
            else if (requestCode == 101 && resultCode == RESULT_OK)
            { Toast.makeText(applicationContext, "${intent?.getIntExtra("sub", 0)}", Toast.LENGTH_SHORT).show() }
            else
            { Toast.makeText(applicationContext, "계산 결과 오류", Toast.LENGTH_SHORT).show() }
        */
        super.onActivityResult(requestCode, resultCode, intent)
    }

}//class MainActivity End
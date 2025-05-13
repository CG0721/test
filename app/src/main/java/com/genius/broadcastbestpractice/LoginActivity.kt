package com.genius.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //写点击login按钮的代码
        findViewById<Button>(R.id.login).setOnClickListener {
            val userName = findViewById<EditText>(R.id.accountEdit)
            val password = findViewById<EditText>(R.id.passwordEdit)
            if (userName.text.toString() == "admin" && password.text.toString() == "123456") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                //提示用户输入错误
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
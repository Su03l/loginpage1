package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val logoutButton = findViewById<Button>(R.id.logoutbtn)
        findViewById<TextView>(R.id.tvuserid).text = userId
        findViewById<TextView>(R.id.tvemailid).text = emailId

        logoutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@secondActivity, MainActivity::class.java))
        }

    }
}
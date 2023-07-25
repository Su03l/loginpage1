package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<Button>(R.id.signupbtn)
        val loginLink = findViewById<TextView>(R.id.logintext)

        registerButton.setOnClickListener{
            registerUser()
        }
    }
    private fun registerUser(){
        val email = findViewById<EditText>(R.id.Eamilre).text.toString()
        val password = findViewById<EditText>(R.id.passwordre).text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val firebaseUser : FirebaseUser = task.result!!.user!!
                        Toast.makeText(this@MainActivity, "Logged in ", Toast.LENGTH_LONG).show()
                        val Intent =Intent(this@MainActivity, secondActivity::class.java)
                        Intent.putExtra("user_id",firebaseUser.uid)
                        Intent.putExtra("email_id", email)
                        startActivity(Intent)
                        finish()
                    }else{
                        Toast.makeText(this@MainActivity, "Eroor ", Toast.LENGTH_LONG).show()
                    }

                }
        }
    }

}
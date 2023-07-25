package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class loginpage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage1)

        val loginButton = findViewById<Button>(R.id.loginbtn)
        loginButton.setOnClickListener{
            loginUser()
        }
    }
    private fun loginUser(){
        val email = findViewById<EditText>(R.id.Eamillogin).text.toString()
        val password = findViewById<EditText>(R.id.passwordlogin).text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val firebaseUser : FirebaseUser = task.result!!.user!!
                        Toast.makeText(this@loginpage1, "Logged in ", Toast.LENGTH_LONG).show()
                        val Intent = Intent(this@loginpage1, secondActivity::class.java)
                        Intent.putExtra("user_id",firebaseUser.uid)
                        Intent.putExtra("email_id", email)
                        startActivity(Intent)
                        finish()
                    }else{
                        Toast.makeText(this@loginpage1, "Eroor ", Toast.LENGTH_LONG).show()
                    }

                }
        }
    }

}
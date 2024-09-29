package com.android.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars  = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        changePasswordVisibility()

        val sendButton      = findViewById<Button>(R.id.btnEntrar)
        sendButton.setOnClickListener {
            onSendMessage()
        }
    }

     private fun changePasswordVisibility() {
         val passwordView        = findViewById<EditText>(R.id.inputSenha)
         val showPasswordButton  = findViewById<ImageView>(R.id.showPasswordButton)
         showPasswordButton.setOnClickListener {
             if (passwordView.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                 passwordView.inputType = InputType.TYPE_CLASS_TEXT
             } else {
                 passwordView.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
             }
             passwordView.setSelection(passwordView.text.length)
         }
     }

     private fun onSendMessage() {
        val userNameView    = findViewById<EditText>(R.id.inputNome)
        val userName        = userNameView.text.toString()

        val passwordView    = findViewById<EditText>(R.id.inputSenha)
        val password        = passwordView.text.toString()

        val warningView     = findViewById<TextView>(R.id.warningStr)

         if (isARegisteredUser(this, userName, password)) {
             val intent     = Intent(this, AccessActivity::class.java)
             intent.putExtra("usuario", userName)
             startActivity(intent)
         } else
             warningView.visibility = View.VISIBLE
    }

    private fun isARegisteredUser (context: Context, userName: String, password: String): Boolean {
        var userNamesArray = context.resources.getStringArray(R.array.usuarios)
        var passwordsArray = context.resources.getStringArray(R.array.senhas)

        if (userNamesArray.contains(userName) and passwordsArray.contains(password))
            return true
        else
            return false
    }

}
package com.example.project_bp3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper = DatabaseHelper(this)

        // Add a sample user for demonstration if it doesn't exist
        if (dbHelper.getUser("user") == null) {
            dbHelper.addUser(User(username = "user", password = "password123"))
        }
        if (dbHelper.getUser("admin") == null) {
            dbHelper.addUser(User(username = "admin", password = "admin"))
        }

        val loginButton = findViewById<Button>(R.id.login_button)
        val usernameField = findViewById<EditText>(R.id.username_field)
        val passwordField = findViewById<EditText>(R.id.password_field)
        val passwordToggle = findViewById<ImageView>(R.id.password_toggle)

        passwordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                passwordToggle.setImageResource(R.drawable.ic_eye)
            } else {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                passwordToggle.setImageResource(R.drawable.ic_eye_off)
            }
            // Move cursor to the end of the text
            passwordField.setSelection(passwordField.text.length)
        }

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Username dan password harus diisi")
            } else {
                val user = dbHelper.getUser(username)
                if (user != null && user.password == password) {
                    val intent = Intent(this, MenuActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    startActivity(intent)
                    finish()
                } else {
                    showAlert("Username atau password salah")
                }
            }
        }

        val rootLayout = findViewById<RelativeLayout>(R.id.login_root_layout)
        rootLayout.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                currentFocus?.let {
                    imm.hideSoftInputFromWindow(it.windowToken, 0)
                    it.clearFocus()
                }
            }
            false
        }
    }

    private fun showAlert(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Peringatan")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
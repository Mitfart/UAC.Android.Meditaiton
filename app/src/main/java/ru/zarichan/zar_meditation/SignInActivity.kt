package ru.zarichan.zar_meditation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.zarichan.zar_meditation.net.Api
import ru.zarichan.zar_meditation.net.MRetrofit
import ru.zarichan.zar_meditation.net.login

class SignInActivity : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        emailInput = findViewById(R.id.sign_in__input_email)
        passwordInput = findViewById(R.id.sign_in__input_password)
    }


    fun signin(view: View) {
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
//            val i = Intent(this@SignInActivity, MenuActivity::class.java)
//            startActivity(i)

            val log = MRetrofit().get()
            val getApi = log.create(Api::class.java)
            val hashMap: HashMap<String, String> = HashMap()

            hashMap["email"] = email
            hashMap["password"] = password

            getApi.getAuth(hashMap).enqueue(object : Callback<login> {
                override fun onResponse(call: Call<login>, response: Response<login>) {
                    if (response.isSuccessful) {
                        val i = Intent(this@SignInActivity, MenuActivity::class.java)
                        startActivity(i)
                    } else {
                        AlertDialog.Builder(this@SignInActivity)
                            .setTitle("Ошибка")
                            .setMessage("Ошибка логина или пароля")
                            .setPositiveButton("Ok", null)
                            .create()
                            .show()
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@SignInActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })

        } else {
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Некоторые поля не заполнены")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
}
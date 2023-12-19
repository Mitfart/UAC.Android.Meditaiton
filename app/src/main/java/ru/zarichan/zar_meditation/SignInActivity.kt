package ru.zarichan.zar_meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.zarichan.zar_meditation.net.Api
import ru.zarichan.zar_meditation.net.Login
import ru.zarichan.zar_meditation.net.MRetrofit

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
        val password = emailInput.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            val log = MRetrofit().get()
            val getApi = log.create(Api::class.java)
            var hashMap: HashMap<String, String> = HashMap()

            hashMap.put("email", email)
            hashMap.put("password", password)

            val logCall: Call<Login> = getApi.getAuth(hashMap)

            logCall.enqueue(object : Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful) {
                        val i = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(i)
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
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
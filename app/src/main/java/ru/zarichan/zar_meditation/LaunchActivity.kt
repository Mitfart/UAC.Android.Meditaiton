package ru.zarichan.zar_meditation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)


        object : CountDownTimer(300, 1000) {
            override fun onTick(p0: Long) {
                // TODO("Not yet implemented")
            }

            override fun onFinish() {
                val i = Intent(this@LaunchActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }.start()
    }
}
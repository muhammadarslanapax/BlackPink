package com.example.blackpink

import android.annotation.SuppressLint
import com.example.blackpink.Models.MainModel
import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import com.example.blackpink.Adapters.MainAdapter.ViewHolderClass
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.blackpink.R
import android.content.Intent
import com.example.blackpink.RingingActivity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.VideoView
import android.os.Bundle
import com.example.blackpink.MainActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackpink.Adapters.MainAdapter
import android.media.RingtoneManager
import android.media.Ringtone
import android.media.AudioManager
import android.os.Handler
import android.view.View
import com.example.blackpink.CallActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        Handler().postDelayed({
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)

            finish()

        }, 3000)


    }
}
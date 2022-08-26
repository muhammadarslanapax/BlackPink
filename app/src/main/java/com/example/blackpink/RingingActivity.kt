package com.example.blackpink
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import android.media.RingtoneManager
import android.media.Ringtone
import android.media.AudioManager
import android.view.View
import android.widget.ImageView
class RingingActivity : AppCompatActivity() {
    var img: ImageView? = null
    var name: TextView? = null
    var answerBnt: CardView? = null
    var cancelBtn: CardView? = null
    lateinit var ringtone: Ringtone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringing)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val txt1 = intent.getStringExtra("name1")
        val image = intent.getIntExtra("image", 0)
        val video = intent.getIntExtra("video", 0)
        //Ringtone
        val alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
         ringtone = RingtoneManager.getRingtone(applicationContext, alert)
        ringtone.streamType = AudioManager.STREAM_RING
        ringtone.play()
        cancelBtn = findViewById(R.id.CancelBnt)
        answerBnt = findViewById(R.id.AnswerBnt)
        img = findViewById(R.id.img)
        img!!.setImageResource(image)
        name = findViewById(R.id.name)
        name!!.setText(txt1)
        cancelBtn!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@RingingActivity, MainActivity::class.java)
            startActivity(i)
            ringtone.stop()
        })
        answerBnt!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@RingingActivity, CallActivity::class.java)
            i.putExtra("video", video)
            startActivity(i)
            ringtone.stop()
            finish()
        })

    }

    override fun onBackPressed() {
        ringtone.stop()
        super.onBackPressed();


    }
}
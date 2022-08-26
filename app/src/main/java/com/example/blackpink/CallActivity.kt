package com.example.blackpink
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_call.*
class CallActivity : AppCompatActivity() {
    var cardView: CardView? = null
    lateinit var front:PreviewView
    var video:Boolean =false
    var preview: Preview?=null
    var imagecap:ImageCapture ?=null
    var camera: Camera?=null
    var voiceBtn: CardView? = null
    var CamBtn: CardView? = null
    var videoView: VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        CamBtn = findViewById(R.id.CamBtn)
        front = preview_tv as PreviewView
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        voiceBtn = findViewById(R.id.voiceBtn)
        cardView = findViewById(R.id.redBnt)
        val video = intent.getIntExtra("video", 0)
        videoView = findViewById(R.id.videoView)
        val path = "android.resource://$packageName/$video"
        val uri = Uri.parse(path)
        videoView!!.setVideoURI(uri)
        videoView!!.start()
       check()
        cardView!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@CallActivity, MainActivity::class.java)
            startActivity(i)
            finish()
            videoView!!.stopPlayback()
        })

   }
    private fun check() {
                        val cameraProviderFuture=ProcessCameraProvider.getInstance(this )
                         cameraProviderFuture.addListener(Runnable {
                          val cameraProvider=cameraProviderFuture.get()
                             preview=Preview.Builder().build()
                             imagecap = ImageCapture.Builder().build()
                             preview?.setSurfaceProvider(preview_tv.createSurfaceProvider(camera?.cameraInfo))
                              cameraProvider.unbindAll()
                             val cameraselecter1 = CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_FRONT).build()
                              camera=cameraProvider.bindToLifecycle(this, cameraselecter1,preview,imagecap)
                         },ContextCompat.getMainExecutor(this))
      video11()
    }
    fun video11(){
        preview_tv.setOnClickListener {
            if (video==false) {
                preview_tv.setLayoutParams(
                    ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.MATCH_PARENT
                    )
                )
                videoView?.setLayoutParams(
                    ConstraintLayout.LayoutParams(
                        300, 430
                    )
                )
                videoView?.bringToFront()
                video=true
            }
        }
        videoView?.setOnClickListener {
            if (video==true) {
                videoView?.setLayoutParams(
                    ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.MATCH_PARENT
                    )
                )
                preview_tv.setLayoutParams(
                    ConstraintLayout.LayoutParams(
                        290, 420
                    )
                )
               preview_tv.bringToFront()
                video=false
            }
        }
    }
}
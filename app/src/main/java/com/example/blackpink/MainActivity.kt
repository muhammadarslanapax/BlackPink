package com.example.blackpink
import com.example.blackpink.Models.MainModel
import android.app.Dialog
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackpink.Adapters.MainAdapter
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import kotlinx.android.synthetic.main.custom_dialog.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.mainRv)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        recyclerView!!.setLayoutManager(StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL))
        val list: MutableList<MainModel> = ArrayList()
        list.add(MainModel(R.drawable.jennie111, "Jennie", R.raw.jenie))
        list.add(MainModel(R.drawable.jissolissa111, "Jisoo&Lisa", R.raw.jisoo))
        list.add(MainModel(R.drawable.lisaa111, "Lisa", R.raw.jisoolisaa))
        list.add(MainModel(R.drawable.jisoo111, "Jiso", R.raw.lisa))
        list.add(MainModel(R.drawable.rose111, "Rose", R.raw.rose))
        list.add(MainModel(R.drawable.imga, "Blackpink", R.raw.blackpink))
        recyclerView!!.setAdapter(MainAdapter(list, this))
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!=PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),0)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!=PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),0)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBackPressed() {


        val dialgo=Dialog(this)
        dialgo.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialgo.setCancelable(false)
        dialgo.setContentView(R.layout.custom_dialog)

        val mDisplayMetrics = windowManager.currentWindowMetrics
        val mDisplayWidth = mDisplayMetrics.bounds.width()
        val mDisplayHeight = mDisplayMetrics.bounds.height()


        val mLayoutParams = WindowManager.LayoutParams()
        mLayoutParams.width = (mDisplayWidth * 0.75f).toInt()
        mLayoutParams.height = (mDisplayHeight * 0.25f).toInt()
        dialgo.window?.attributes = mLayoutParams



        val window = dialgo.window
        window!!.setLayout(mDisplayWidth, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        dialgo.btn_no.setOnClickListener {
            dialgo.dismiss()


        }

        dialgo.btn_yes.setOnClickListener {

            dialgo.dismiss()

            finishAffinity()
           System.exit(0)
        }
        dialgo.show()

    }




}
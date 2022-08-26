package com.example.blackpink.Adapters
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
import android.view.View
import android.widget.ImageView
class MainAdapter(var list: List<MainModel>, var activity: Activity) :
    RecyclerView.Adapter<ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val m = list[position]
        holder.name.text = m.txt
        holder.img.setImageResource(m.img)

        holder.itemView.setOnClickListener {
            val i = Intent(activity, RingingActivity::class.java)
            i.putExtra("image", m.img)
            i.putExtra("video", m.video)
            i.putExtra("name1",m.txt.toString())
            activity.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var name: TextView


        init {
            img = itemView.findViewById(R.id.img)
            name = itemView.findViewById(R.id.txt)
        }
    }
}
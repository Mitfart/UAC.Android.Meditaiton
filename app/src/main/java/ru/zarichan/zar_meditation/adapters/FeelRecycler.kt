package ru.zarichan.zar_meditation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.zarichan.zar_meditation.R
import ru.zarichan.zar_meditation.net.NetFeels

class FeelRecycler(private val context: Context, private val netFeels: NetFeels) :
    RecyclerView.Adapter<FeelRecycler.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.feel_img)
        val titleView: TextView = itemView.findViewById(R.id.feel_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.feel_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
//        holder.imageView.setImageResource(list[position].image)
//        holder.titleView.text = list[position].nameFeel
        holder.titleView.text = netFeels.data[position].title
        Glide.with(context).load(netFeels.data[position].image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
//        return list.size
        return netFeels.data.size
    }
}
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
import ru.zarichan.zar_meditation.net.quotes

class PostRecycler(
    private val context: Context,
//    private val list: ArrayList<Post>
    private val quotes: quotes
) :
    RecyclerView.Adapter<PostRecycler.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.post_title)
        val subtitleView: TextView = itemView.findViewById(R.id.post_subtitle)
        val imageView: ImageView = itemView.findViewById(R.id.post_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.post_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
//        holder.titleView.text = list[position].title
//        holder.subtitleView.text = list[position].description
//        holder.imageView.setImageResource(list[position].image)
        holder.titleView.text = quotes.data[position].title
        holder.subtitleView.text = quotes.data[position].description
        Glide.with(context).load(quotes.data[position].image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
//        return list.size
        return quotes.data.size
    }
}
package com.stac.welfaretree

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.R

class ViewPagerAdapter(private var title: List<String>, private var details : List<String>,private var images : List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {


    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle : TextView = itemView.findViewById(R.id.pager_item_text_title)
        val itemDetail : TextView = itemView.findViewById(R.id.pager_item_text_detail)
        val itemImage : ImageView = itemView.findViewById(R.id.pager_item_image)

        init {
            itemImage.setOnClickListener{
                val position = adapterPosition
                Toast.makeText(itemView.context,"image clicked! @${position + 1}",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_intro_pager_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        // data + view
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

}
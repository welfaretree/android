package com.example.welfaretree

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    private val itemImage:ImageView = itemView.findViewById(R.id.pager_item_image)
    private val itemTitle:TextView = itemView.findViewById(R.id.pager_item_text_title)
    private val itemExplain:TextView = itemView.findViewById(R.id.pager_item_text_explain)


    fun bindWithView(pageItem: PageItem){
        itemImage.setImageResource(pageItem.imageSrc)
        itemTitle.text = pageItem.title
        itemExplain.text = pageItem.explain
    }
}
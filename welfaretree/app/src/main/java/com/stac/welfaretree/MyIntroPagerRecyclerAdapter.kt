package com.stac.welfaretree

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.R

class MyIntroPagerRecyclerAdapter(private var pageList: ArrayList<PageItem>) :
    RecyclerView.Adapter<MyIntroPagerRecyclerAdapter.MyPagerViewHolder>() {


    inner class MyPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemImage = itemView.findViewById<ImageView>(R.id.pager_item_image)
        private val itemTitle = itemView.findViewById<TextView>(R.id.pager_item_text_title)
        private val itemExplain = itemView.findViewById<TextView>(R.id.pager_item_text_explain)


        fun bindWithView(pageItem: PageItem) {
            itemImage.setImageResource(pageItem.imageSrc)
            itemTitle.text = pageItem.title
            itemExplain.text = pageItem.explain
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
        return MyPagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_intro_pager_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
        // data + view
        holder.bindWithView(pageList[position])
    }

}
package com.stac.welfaretree.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.R
import com.stac.welfaretree.Welfare

class WelfareGridRecyclerView : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var welfareList = ArrayList<Welfare>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return WelfareItemViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
//        )
        TODO()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return this.welfareList.size
    }
}
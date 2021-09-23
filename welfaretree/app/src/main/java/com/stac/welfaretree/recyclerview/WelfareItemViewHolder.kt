package com.stac.welfaretree.recyclerview

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.databinding.SearchItemBinding
import com.stac.welfaretree.Welfare
import com.stac.welfaretree.utils.Constants.TAG

class WelfareItemViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root) {

   private val welfareName = binding.welfareName
   private val welfareStar = binding.welfareStar
   private val welfareNotiToggle = binding.welfareNotiToggle

    fun bindWithView(welfareItem: Welfare){
        Log.d(TAG,"WelfareItemViewHolder - bindWithView")
        welfareName.text = welfareItem.welfareName
    }
}
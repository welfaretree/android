package com.stac.welfaretree.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ProfileItemBinding

class ProfileAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val etcList = ArrayList<String>()

    fun setList(list: List<String>) {
        etcList.clear()
        etcList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ProfileItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.profile_item,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(etcList[position])
    }

    override fun getItemCount(): Int = etcList.size

}
class MyViewHolder(private val binding: ProfileItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.name = name
    }
}
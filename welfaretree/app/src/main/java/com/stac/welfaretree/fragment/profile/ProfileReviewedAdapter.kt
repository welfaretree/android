package com.stac.welfaretree.fragment.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ProfileReviewedItemBinding

class ProfileReviewedAdapter : RecyclerView.Adapter<ProfileReviewedViewHolder>() {
    private val reviewedList = ArrayList<ProfileReviewedItem>()

    fun setList(list: List<ProfileReviewedItem>) {
        reviewedList.clear()
        reviewedList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileReviewedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ProfileReviewedItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.profile_reviewed_item,
            parent,
            false
        )

        return ProfileReviewedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileReviewedViewHolder, position: Int) {
        holder.bind(reviewedList[position])
    }

    override fun getItemCount(): Int = reviewedList.size

}

class ProfileReviewedViewHolder(private val binding: ProfileReviewedItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(profileReviewedItem: ProfileReviewedItem) {
        binding.reviewedItem = profileReviewedItem
    }
}


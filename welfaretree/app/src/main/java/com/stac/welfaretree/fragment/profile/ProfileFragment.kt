package com.stac.welfaretree.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.welfaretree.databinding.FragmentProfileBinding
import com.stac.welfaretree.adapter.ProfileAdapter

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.fragment = this

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        val profileAdapter = ProfileAdapter()
        profileAdapter.setList(
            listOf(
                "기타사항",
                "기타사항",
                "기타사항"
            )
        )
        binding.etcList.adapter = profileAdapter

        val profileReviewedAdapter = ProfileReviewedAdapter()
        profileReviewedAdapter.setList(
            listOf(
                ProfileReviewedItem("복지명", 4.0F),
                ProfileReviewedItem("복지명", 4.0F),
                ProfileReviewedItem("복지명", 4.0F),
            )
        )
        binding.reviewedList.adapter = profileReviewedAdapter
    }

    fun editUserInfo() {
        Toast.makeText(activity, "인적사항 편집", Toast.LENGTH_SHORT).show()
    }
}
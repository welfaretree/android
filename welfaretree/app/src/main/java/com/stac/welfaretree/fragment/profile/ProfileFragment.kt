package com.stac.welfaretree.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.welfaretree.databinding.FragmentProfileBinding
import com.stac.welfaretree.adapter.ProfileAdapter

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var profileAdapter: ProfileAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        profileAdapter = ProfileAdapter()
        profileAdapter.setList(listOf("기타사항", "기타사항", "기타사항"))

        binding.etcList.adapter = profileAdapter
    }
}
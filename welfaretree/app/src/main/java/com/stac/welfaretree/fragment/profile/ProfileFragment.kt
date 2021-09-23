package com.stac.welfaretree.fragment.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentProfileBinding
import com.stac.welfaretree.activity.userinfo.UserInfoActivity
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
        startActivity(Intent(activity, UserInfoActivity::class.java))
    }
    fun deleteUserInfo() {
        AlertDialog.Builder(activity)
            .setTitle("정말 인적사항을 삭제하시겠습니까?")
            .setMessage("삭제시 등록된 모든 복지가 사라집니다.")
            .setPositiveButton(R.string.alert_positive_message) { _, _ ->
                _deleteUserInfo()
            }
            .show()
    }
    private fun _deleteUserInfo() {
        Toast.makeText(activity, "인적사항이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
    }
}
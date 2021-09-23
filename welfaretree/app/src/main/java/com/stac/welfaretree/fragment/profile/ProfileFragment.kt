package com.stac.welfaretree.fragment.profile

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentProfileBinding
import com.stac.welfaretree.activity.userinfo.UserInfoActivity
import com.stac.welfaretree.adapter.ProfileAdapter
import kotlinx.coroutines.*

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.fragment = this

        CoroutineScope(Dispatchers.IO).launch {
            val user = UserManager(requireContext().applicationContext).getUser()

            binding.user = user
        }

        initEtcRecyclerView(listOf())
        initReviewedRecyclerView(listOf())

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.IO).launch {
            val user = UserManager(requireContext().applicationContext).getUser()

            binding.user = user
        }
    }

    private fun initEtcRecyclerView(list: List<String>) {
        val profileAdapter = ProfileAdapter()
        profileAdapter.setList(list)
        binding.etcList.adapter = profileAdapter
    }

    private fun initReviewedRecyclerView(list: List<ProfileReviewedItem>) {
        val profileReviewedAdapter = ProfileReviewedAdapter()
        profileReviewedAdapter.setList(list)
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
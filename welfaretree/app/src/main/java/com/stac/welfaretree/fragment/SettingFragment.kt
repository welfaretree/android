package com.stac.welfaretree.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentSettingBinding
import java.util.prefs.Preferences

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    val Context.dataStore by preferencesDataStore(name = "settings")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.switchDark.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(activity, "다크모드 활성화", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "다크모드 비활성화", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}
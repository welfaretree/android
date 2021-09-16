package com.stac.welfaretree.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        val fragmentTransaction = fragmentManager?.beginTransaction()

        binding.bellImg.setOnClickListener{
            fragmentTransaction!!.replace(R.id.pager, NotificationFragment()).commit()
            transaction.addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
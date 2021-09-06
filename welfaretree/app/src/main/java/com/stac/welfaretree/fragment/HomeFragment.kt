package com.stac.welfaretree.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        binding.bellImg.setOnClickListener{

        }
        binding.searchImg.setOnClickListener{
            transaction.replace(R.id.pager, NotificationFragment())
            transaction.addToBackStack(null)
            transaction.commit()

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
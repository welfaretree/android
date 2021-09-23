package com.stac.welfaretree.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentHomeBinding
import com.stac.welfaretree.activity.MainActivity
import com.stac.welfaretree.activity.SearchWelfareActivity

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
        binding.searchImg.setOnClickListener{
            val intent = Intent(activity, SearchWelfareActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
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
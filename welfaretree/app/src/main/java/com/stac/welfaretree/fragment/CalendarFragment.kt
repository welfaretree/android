package com.stac.welfaretree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.welfaretree.R
import com.example.welfaretree.databinding.FragmentCalendarBinding
import java.util.*


class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCalendarBinding.inflate(inflater, container, false)
//        val calendar: CalendarView = view.findViewById(R.id.calendar)
//        val calendarListTitle: TextView = view.findViewById(R.id.calendar_list_title)
//        val calendarListContent: TextView = view.findViewById(R.id.calendar_list_content)

        val today = Calendar.getInstance()
        val todayYear = today.get(Calendar.YEAR)
        val todayMonth = today.get(Calendar.MONTH)
        val todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH)

        binding.calendarListTitle.text =
            "${padDate(todayYear)}.${padDate(todayMonth)}.${padDate(todayDayOfMonth)}"
        binding.calendarListContent.text = getWelfare(todayYear, todayMonth, todayDayOfMonth)

        binding.calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            binding.calendarListTitle.text = "${padDate(year)}.${padDate(month)}.${padDate(dayOfMonth)}"
            binding.calendarListContent.text = getWelfare(year, month, dayOfMonth)
        }
        return view
    }

    private fun padDate(i: Int): String {
        return i.toString().padStart(2, '0')
    }

    private fun getWelfare(year: Int, month: Int, dayOfMonth: Int): String {
        // TODO: 일자 별 복지 목록 API 접근 코드 구현 필요
        return "- 복지 목록"
    }
}
package com.example.welfaretree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.welfaretree.R
import java.util.*


class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        val calendar: CalendarView = view.findViewById(R.id.calendar)
        val calendarListTitle: TextView = view.findViewById(R.id.calendar_list_title)
        val calendarListContent: TextView = view.findViewById(R.id.calendar_list_content)

        val today = Calendar.getInstance()
        val todayYear = today.get(Calendar.YEAR)
        val todayMonth = today.get(Calendar.MONTH)
        val todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH)

        calendarListTitle.text =
            "${padDate(todayYear)}.${padDate(todayMonth)}.${padDate(todayDayOfMonth)}"
        calendarListContent.text = getWelfare(todayYear, todayMonth, todayDayOfMonth)

        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            calendarListTitle.text = "${padDate(year)}.${padDate(month)}.${padDate(dayOfMonth)}"
            calendarListContent.text = getWelfare(year, month, dayOfMonth)
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
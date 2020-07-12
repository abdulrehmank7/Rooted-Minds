package com.arkapp.rootedminds.ui.reflection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.ReflectionParsed
import com.arkapp.rootedminds.data.room.AppDatabase
import com.arkapp.rootedminds.utility.CURRENT_OPENED_REFLECTION_HISTORY
import com.arkapp.rootedminds.utility.getMonthTextFromYearMonth
import com.arkapp.rootedminds.utility.show
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_month_view.calendarViewFragment
import kotlinx.android.synthetic.main.fragment_month_view.tvMonth
import kotlinx.android.synthetic.main.fragment_reflection.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import java.util.*


class ReflectionFragment : Fragment(R.layout.fragment_reflection) {

    private lateinit var calenderUI: CalendarUI

    private val allParsedReflection: ArrayList<ReflectionParsed> = ArrayList()
    private val gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allParsedReflection.clear()
        CURRENT_OPENED_REFLECTION_HISTORY = null

        ivMenu.show()
        ivMenu.setOnClickListener { requireActivity().drawerLayout.open() }

        initCalendarUI()

        btAddReflection.setOnClickListener {
            findNavController().navigate(R.id.action_reflectionFragment_to_addReflectionFragment)
        }

        lifecycleScope.launch {
            val database: AppDatabase = AppDatabase.getDatabase(requireContext())
            val reflectionDoa = database.reflectionDoa()

            for (x in reflectionDoa.getAllReflection()) {
                allParsedReflection.add(
                    ReflectionParsed(x.uid,
                        x.title,
                        x.location,
                        x.note1,
                        x.note2,
                        x.note3,
                        x.note4,
                        x.note5,
                        x.note6,
                        gson.fromJson(x.date, Date::class.java)))
            }

            calenderUI.setDatesOnCalender(allParsedReflection)
            calenderUI.setReflectionHistory(LocalDate.now(), allParsedReflection)

        }
    }

    private fun initCalendarUI() {
        calenderUI = CalendarUI(calendarViewFragment, tvDate, requireContext(), rvReflection, findNavController())
        calenderUI.initialize()

        btRightArrow.setOnClickListener {
            calendarViewFragment.smoothScrollToMonth(calenderUI.currentYearMonth.plusMonths(1))
        }

        btLeftArrow.setOnClickListener {
            calendarViewFragment.smoothScrollToMonth(calenderUI.currentYearMonth.minusMonths(1))
        }

        calendarViewFragment.monthScrollListener = { date ->
            println("month scrolled ${date.yearMonth}")
            calenderUI.currentYearMonth = date.yearMonth
            tvMonth.text = getMonthTextFromYearMonth(calenderUI.currentYearMonth.toString())
        }
    }


}
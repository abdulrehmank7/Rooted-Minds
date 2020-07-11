package com.arkapp.rootedminds.ui.monthView

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.TrackedActivityParsed
import com.arkapp.rootedminds.data.room.AppDatabase
import com.arkapp.rootedminds.utility.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_month_view.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.coroutines.launch
import org.threeten.bp.YearMonth
import java.util.*
import kotlin.collections.ArrayList


class MonthViewFragment : Fragment(R.layout.fragment_month_view) {

    private lateinit var calenderUI: CalendarUI

    private val allParsedActivities: ArrayList<TrackedActivityParsed> = ArrayList()
    private val currentDayActivity: ArrayList<TrackedActivityParsed> = ArrayList()
    private val gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivMenu.show()
        ivMenu.setOnClickListener { requireActivity().drawerLayout.open() }

        initCalendarUI()
        initTitleButtons()

        lifecycleScope.launch {
            val database: AppDatabase = AppDatabase.getDatabase(requireContext())
            val activityDoa = database.trackedActivityDao()
            val activities = activityDoa.getAllTrackedActivities()
            for (x in activities) {
                allParsedActivities.add(TrackedActivityParsed(x.uid, x.title, gson.fromJson(x.date, Date::class.java)))
            }

            onActivitiesFetched(allParsedActivities)
        }
    }

    private fun initTitleButtons() {
        btAchievementSelection.setOnClickListener {
            groupAchievement.show()
            groupMonth.hide()

            btAchievementSelection.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
            btAchievementSelection.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.orange))

            btMonthSelection.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey4))
            btMonthSelection.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.grey4))

            tvMonth.text = getString(R.string.awards_progression)
            tvMonth.setBackgroundResource(R.color.green9)
            bgView.setBackgroundResource(R.color.green9)
        }

        btMonthSelection.setOnClickListener {
            groupMonth.show()
            groupAchievement.hide()

            btMonthSelection.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
            btMonthSelection.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.orange))

            btAchievementSelection.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey4))
            btAchievementSelection.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.grey4))

            tvMonth.text = getMonthTextFromYearMonth(calenderUI.currentYearMonth.toString())

            tvMonth.setBackgroundResource(R.color.green4)
            bgView.setBackgroundResource(R.color.green4)
        }

    }

    private fun initCalendarUI() {
        calenderUI = CalendarUI(calendarViewFragment, requireContext())
        calenderUI.initialize()

        setMostTrackedData(calenderUI.currentYearMonth)

        calendarViewFragment.monthScrollListener = { date ->
            println("month scrolled ${date.yearMonth}")
            calenderUI.currentYearMonth = date.yearMonth
            tvMonth.text = getMonthTextFromYearMonth(calenderUI.currentYearMonth.toString())
            setMostTrackedData(date.yearMonth)
        }
    }

    private fun onActivitiesFetched(trackedActivities: ArrayList<TrackedActivityParsed>) {
        try {
            calenderUI.setDatesOnCalender(trackedActivities)

            val currentDayOfYear = getCurrentDayOfYear()
            val currentYear = getCurrentYear()

            for (activity in trackedActivities) {
                val activityCal = activity.date!!.getCalender()
                if (activityCal.get(Calendar.DAY_OF_YEAR) == currentDayOfYear && activityCal.get(Calendar.YEAR) == currentYear) {
                    currentDayActivity.add(activity)
                }
            }

            setTotalTracked()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setTotalTracked() {
        val differentTypeActivity = getTotalActivityType(currentDayActivity)
        val totalCount = differentTypeActivity.size
        tvTotalTracked.text = "$totalCount/6"

        circularProgressBarShadow.progressMax = 6f
        circularProgressBarShadow.progress = totalCount.toFloat()

        circularProgressBar.progressMax = 6f
        circularProgressBar.progress = totalCount.toFloat()

        setTrackedIcon()
    }

    private fun setTrackedIcon() {
        currentDayActivity.distinctBy { it.title }.forEachIndexed { index, trackedActivityParsed ->

            val activityDetail = getActivityDetail(trackedActivityParsed.title!!)
            when (index) {
                0 -> {
                    ivLogo1.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo1.setPadding(24, 24, 24, 24)
                    ivLogo1.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo1.text = getMultipleLineTitle(activityDetail.title!!)
                }
                1 -> {
                    ivLogo2.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo2.setPadding(24, 24, 24, 24)
                    ivLogo2.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo2.text = getMultipleLineTitle(activityDetail.title!!)
                }
                2 -> {
                    ivLogo3.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo3.setPadding(24, 24, 24, 24)
                    ivLogo3.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo3.text = getMultipleLineTitle(activityDetail.title!!)
                }
                3 -> {
                    ivLogo4.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo4.setPadding(24, 24, 24, 24)
                    ivLogo4.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo4.text = getMultipleLineTitle(activityDetail.title!!)
                }
                4 -> {
                    ivLogo5.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo5.setPadding(24, 24, 24, 24)
                    ivLogo5.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo5.text = getMultipleLineTitle(activityDetail.title!!)
                }
                5 -> {
                    ivLogo6.setImageResource(activityDetail.imgResLogo!!)
                    ivLogo6.setPadding(24, 24, 24, 24)
                    ivLogo6.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green6), android.graphics.PorterDuff.Mode.SRC_ATOP)
                    tvLogo6.text = getMultipleLineTitle(activityDetail.title!!)
                }
            }
        }
    }

    private fun setMostTrackedData(date: YearMonth) {
        val mostTrackedActivity = findMostTrackedActivity(allParsedActivities, date)

        if (mostTrackedActivity != null) {
            cvLogo.show()
            ivLogo.setImageResource(mostTrackedActivity.imgResLogo!!)
            tvActivityTitle.text = getTwoLineTitle(mostTrackedActivity.title!!)
        } else {
            cvLogo.invisible()
            tvActivityTitle.text = "No data!"
        }
    }
}
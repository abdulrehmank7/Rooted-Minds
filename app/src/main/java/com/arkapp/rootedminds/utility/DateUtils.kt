package com.arkapp.rootedminds.utility

import com.arkapp.rootedminds.data.models.TrackedActivityParsed
import com.kizitonwose.calendarview.model.CalendarDay
import java.util.*

/**
 * Created by Abdul Rehman on 11-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
val MONTH_NAME = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

fun getCalendarForCurrentTime(): Calendar = Calendar.getInstance()

fun getCurrentDayOfYear() = getCalendarForCurrentTime().get(Calendar.DAY_OF_YEAR)

fun getCurrentYear() = getCalendarForCurrentTime().get(Calendar.YEAR)

fun fetchActivity(day: CalendarDay, trackedActivity: ArrayList<TrackedActivityParsed>): TrackedActivityParsed? {

    for (activity in trackedActivity) {
        if (day.date.dayOfYear == activity.date!!.getCalender().get(Calendar.DAY_OF_YEAR) && day.date.year == activity.date.getCalender().get(Calendar.YEAR))
            return activity
    }

    return null
}

fun getMonthTextFromYearMonth(yearMonth: String): String {
    val month = MONTH_NAME[yearMonth.substring(5).toInt() - 1]
    return "$month ${yearMonth.substring(0, 4)}"
}

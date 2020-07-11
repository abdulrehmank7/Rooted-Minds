package com.arkapp.rootedminds.utility

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.TrackedActivityParsed
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import org.threeten.bp.DayOfWeek
import org.threeten.bp.YearMonth

class CalendarUI(private val calendarView: CalendarView, val context: Context) {

    private val currentDayOfYear = getCurrentDayOfYear()
    private val currentYear = getCurrentYear()
    lateinit var currentYearMonth: YearMonth

    fun initialize() {

        currentYearMonth = YearMonth.now()

        println("init year month $currentYearMonth")
        val firstMonth = currentYearMonth.minusMonths(50)
        val lastMonth = currentYearMonth.plusMonths(50)
        setDatesOnCalender(ArrayList())

        calendarView.setup(firstMonth, lastMonth, DayOfWeek.SUNDAY)
        calendarView.scrollToMonth(currentYearMonth)
    }

    fun setDateText(container: DayViewContainer, day: CalendarDay) {
        container.dateTv.text = day.date.dayOfMonth.toString()
    }

    fun dimOtherMonth(container: DayViewContainer, day: CalendarDay) {
        if (day.owner != DayOwner.THIS_MONTH) {
            container.parent.hide()
        } else {
            container.parent.show()
        }
    }

    fun highlightCurrentDate(container: DayViewContainer, day: CalendarDay) {
        if (day.date.dayOfYear == currentDayOfYear && day.date.year == currentYear) {
            container.ivBorder.show()
            container.ivBorder.setImageResource(R.drawable.bg_square_highlighted)
            container.dateTv.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            container.ivBorder.hide()
        }
    }

    fun setOneDayEvent(container: DayViewContainer) {
        container.ivBorder.show()
    }

    fun setDatesOnCalender(trackedActivity: ArrayList<TrackedActivityParsed>) {
        try {
            calendarView.dayBinder = object : DayBinder<DayViewContainer> {

                override fun create(view: View) = DayViewContainer(view)

                override fun bind(container: DayViewContainer, day: CalendarDay) {

                    setDateText(container, day)
                    dimOtherMonth(container, day)
                    highlightCurrentDate(container, day)

                    val event = fetchActivity(day, trackedActivity)

                    if (event != null) setOneDayEvent(container)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
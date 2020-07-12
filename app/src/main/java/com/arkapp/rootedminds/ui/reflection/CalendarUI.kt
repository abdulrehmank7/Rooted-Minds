package com.arkapp.rootedminds.ui.reflection

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.ReflectionParsed
import com.arkapp.rootedminds.utility.*
import com.kizitonwose.calendarview.CalendarView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth

class CalendarUI(private val calendarView: CalendarView,
    private val tvDate: TextView,
    private val context: Context,
    private val rvReflection: RecyclerView,
    private val findNavController: NavController) {

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

    fun setDatesOnCalender(reflections: ArrayList<ReflectionParsed>) {
        try {
            calendarView.dayBinder = object : DayBinder<DayViewContainer> {

                override fun create(view: View) = DayViewContainer(view)

                override fun bind(container: DayViewContainer, day: CalendarDay) {

                    setDateText(container, day)
                    dimOtherMonth(container, day)
                    highlightCurrentDate(container, day)

                    val event = fetchReflection(day, reflections)

                    if (event != null) setOneDayEvent(container)

                    container.dateTv.setOnClickListener {
                        setReflectionHistory(day.date, reflections)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SetTextI18n")
    fun setReflectionHistory(day: LocalDate, reflections: ArrayList<ReflectionParsed>) {
        val dayReflections = fetchDayReflections(day, reflections)
        val adapter = ReflectionHistoryAdapter(dayReflections, findNavController)
        rvReflection.initVerticalAdapter(adapter, true)
        tvDate.text = "${day.dayOfMonth} ${MONTH_NAME[day.monthValue - 1]}\n${day.year}"
    }
}
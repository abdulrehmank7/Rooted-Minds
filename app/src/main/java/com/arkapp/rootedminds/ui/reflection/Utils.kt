package com.arkapp.rootedminds.ui.reflection

import com.arkapp.rootedminds.data.models.ReflectionParsed
import com.arkapp.rootedminds.utility.getCalender
import com.kizitonwose.calendarview.model.CalendarDay
import org.threeten.bp.LocalDate
import java.util.*

/**
 * Created by Abdul Rehman on 12-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

fun fetchReflection(day: CalendarDay, reflections: ArrayList<ReflectionParsed>): ReflectionParsed? {

    for (reflectionParsed in reflections) {
        if (day.date.dayOfYear == reflectionParsed.date!!.getCalender().get(Calendar.DAY_OF_YEAR) && day.date.year == reflectionParsed.date.getCalender().get(Calendar.YEAR))
            return reflectionParsed
    }

    return null
}

fun fetchDayReflections(day: LocalDate, allReflections: ArrayList<ReflectionParsed>): ArrayList<ReflectionParsed> {

    val dayReflections = ArrayList<ReflectionParsed>()

    for (reflectionParsed in allReflections) {
        if (day.dayOfYear == reflectionParsed.date!!.getCalender().get(Calendar.DAY_OF_YEAR) && day.year == reflectionParsed.date.getCalender().get(Calendar.YEAR))
            dayReflections.add(reflectionParsed)
    }

    return dayReflections
}
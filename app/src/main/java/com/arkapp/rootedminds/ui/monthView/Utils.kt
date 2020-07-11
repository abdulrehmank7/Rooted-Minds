package com.arkapp.rootedminds.ui.monthView

import com.arkapp.rootedminds.data.models.ActivitiesDescription
import com.arkapp.rootedminds.data.models.TrackedActivityParsed
import com.arkapp.rootedminds.utility.*
import org.threeten.bp.YearMonth
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Abdul Rehman on 11-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

fun getTotalActivityType(currentDayActivity: ArrayList<TrackedActivityParsed>): ArrayList<TrackedActivityParsed> {
    var addedActivity1 = false
    var addedActivity2 = false
    var addedActivity3 = false
    var addedActivity4 = false
    var addedActivity5 = false
    var addedActivity6 = false

    val differentTrackedActivity = ArrayList<TrackedActivityParsed>()

    for (activity in currentDayActivity) {
        when (activity.title) {

            CONNECTING_WITH_EARTH.title -> {
                if (!addedActivity1) {
                    differentTrackedActivity.add(activity)
                    addedActivity1 = true
                }
            }
            VISUALISATION_MEDITATION.title -> {
                if (!addedActivity2) {
                    differentTrackedActivity.add(activity)
                    addedActivity2 = true
                }
            }
            FRIENDS_WITH_TREES.title -> {
                if (!addedActivity3) {
                    differentTrackedActivity.add(activity)
                    addedActivity3 = true
                }
            }
            CONNECTING_WITH_NATURE.title -> {
                if (!addedActivity4) {
                    differentTrackedActivity.add(activity)
                    addedActivity4 = true
                }
            }
            RELATIONSHIP_WALK.title -> {
                if (!addedActivity5) {
                    differentTrackedActivity.add(activity)
                    addedActivity5 = true
                }
            }
            RELATIONSHIP_WITH_TREES.title -> {
                if (!addedActivity6) {
                    differentTrackedActivity.add(activity)
                    addedActivity6 = true
                }
            }
        }
    }

    return differentTrackedActivity
}

fun getActivityDetail(title: String): ActivitiesDescription {

    when (title) {
        CONNECTING_WITH_EARTH.title -> return CONNECTING_WITH_EARTH
        VISUALISATION_MEDITATION.title -> return VISUALISATION_MEDITATION
        FRIENDS_WITH_TREES.title -> return FRIENDS_WITH_TREES
        CONNECTING_WITH_NATURE.title -> return CONNECTING_WITH_NATURE
        RELATIONSHIP_WALK.title -> return RELATIONSHIP_WALK
        RELATIONSHIP_WITH_TREES.title -> return RELATIONSHIP_WITH_TREES
    }
    return VISUALISATION_MEDITATION
}

fun getMultipleLineTitle(title: String): String {
    val array = title.split(" ")
    var newString = ""

    for (x in array) newString = newString + "\n" + x

    return newString
}

fun getTwoLineTitle(title: String): String {
    val index = title.indexOf(" ")
    return title.substring(0, index).trim() + "\n" + title.substring(index).trim()
}


fun findMostTrackedActivity(allParsedActivities: ArrayList<TrackedActivityParsed>, yearMonth: YearMonth): ActivitiesDescription? {
    val selectedMonthActivity = ArrayList<TrackedActivityParsed>()
    for (activity in allParsedActivities) {
        val calRef = activity.date!!.getCalender()
        if (calRef.get(Calendar.YEAR) == yearMonth.year && calRef.get(Calendar.MONTH) == yearMonth.monthValue - 1) {
            selectedMonthActivity.add(activity)
        }
    }

    val activity1 = ArrayList<TrackedActivityParsed>()
    val activity2 = ArrayList<TrackedActivityParsed>()
    val activity3 = ArrayList<TrackedActivityParsed>()
    val activity4 = ArrayList<TrackedActivityParsed>()
    val activity5 = ArrayList<TrackedActivityParsed>()
    val activity6 = ArrayList<TrackedActivityParsed>()

    for (x in selectedMonthActivity) {
        when (x.title) {

            CONNECTING_WITH_EARTH.title -> {
                activity1.add(x)
            }
            VISUALISATION_MEDITATION.title -> {
                activity2.add(x)
            }
            FRIENDS_WITH_TREES.title -> {
                activity3.add(x)
            }
            CONNECTING_WITH_NATURE.title -> {
                activity4.add(x)
            }
            RELATIONSHIP_WALK.title -> {
                activity5.add(x)
            }
            RELATIONSHIP_WITH_TREES.title -> {
                activity6.add(x)
            }
        }
    }

    if (activity1.isEmpty() && activity2.isEmpty() && activity3.isEmpty() && activity4.isEmpty() && activity5.isEmpty() && activity6.isEmpty())
        return null

    when {
        activity1.size >= activity2.size &&
                activity1.size >= activity3.size &&
                activity1.size >= activity4.size &&
                activity1.size >= activity5.size &&
                activity1.size >= activity6.size -> {
            return CONNECTING_WITH_EARTH
        }
        activity2.size >= activity1.size &&
                activity2.size >= activity3.size &&
                activity2.size >= activity4.size &&
                activity2.size >= activity5.size &&
                activity2.size >= activity6.size -> {
            return VISUALISATION_MEDITATION
        }
        activity3.size >= activity2.size &&
                activity3.size >= activity1.size &&
                activity3.size >= activity4.size &&
                activity3.size >= activity5.size &&
                activity3.size >= activity6.size -> {
            return FRIENDS_WITH_TREES
        }
        activity4.size >= activity2.size &&
                activity4.size >= activity3.size &&
                activity4.size >= activity1.size &&
                activity4.size >= activity5.size &&
                activity4.size >= activity6.size -> {
            return CONNECTING_WITH_NATURE
        }
        activity5.size >= activity2.size &&
                activity5.size >= activity3.size &&
                activity5.size >= activity4.size &&
                activity5.size >= activity1.size &&
                activity5.size >= activity6.size -> {
            return RELATIONSHIP_WALK
        }
        activity6.size >= activity2.size &&
                activity6.size >= activity3.size &&
                activity6.size >= activity4.size &&
                activity6.size >= activity5.size &&
                activity6.size >= activity1.size -> {
            return RELATIONSHIP_WITH_TREES
        }
        else -> return VISUALISATION_MEDITATION
    }
}
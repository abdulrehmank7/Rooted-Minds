package com.arkapp.rootedminds.utility

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.kizitonwose.calendarview.ui.ViewContainer
import kotlinx.android.synthetic.main.calendar_day_layout.view.*

class DayViewContainer(view: View) : ViewContainer(view) {
    val parent: ConstraintLayout = view.parentLay
    val dateTv: TextView = view.calendarDayText
    val ivBorder: ImageView = view.ivBorder
}
package com.arkapp.rootedminds.ui.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY_DESCRIPTION
import com.arkapp.rootedminds.utility.loadImage
import kotlinx.android.synthetic.main.fragment_timer.*


class TimerFragment : Fragment(R.layout.fragment_timer) {

    private lateinit var countDownTimer: CountDownTimer

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivBg.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgRes!!)
        ivLogo.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgResLogo!!)

        tvActivityTitle.text = CURRENT_ACTIVITY_DESCRIPTION.title
        tvTime.text = "${CURRENT_ACTIVITY_DESCRIPTION.timeInMin}:00"

        btBack.setOnClickListener { requireActivity().onBackPressed() }

        circularProgressBar.progressMax = CURRENT_ACTIVITY_DESCRIPTION.timeInMin!! * 60f
        circularProgressBar.progress = circularProgressBar.progressMax

        countDownTimer = object : CountDownTimer(CURRENT_ACTIVITY_DESCRIPTION.timeInMin!!.toLong() * 60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = ((millisUntilFinished / 1000) % 60)
                val minutes = millisUntilFinished / 60000

                val formattedSeconds =
                    if (seconds < 10)
                        "0$seconds"
                    else
                        "$seconds"
                
                tvTime.text = "$minutes:$formattedSeconds"

                circularProgressBar.progress = circularProgressBar.progress - 1
            }

            override fun onFinish() {
                tvTime.text = "00:00"
            }
        }

        countDownTimer.start()
    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }

}
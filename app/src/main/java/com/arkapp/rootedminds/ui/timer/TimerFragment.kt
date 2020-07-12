package com.arkapp.rootedminds.ui.timer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY_DESCRIPTION
import com.arkapp.rootedminds.utility.loadImage
import kotlinx.android.synthetic.main.fragment_timer.*


class TimerFragment : Fragment(R.layout.fragment_timer) {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var countDownTimer: CountDownTimer

    private var remainingTime = CURRENT_ACTIVITY_DESCRIPTION.timeInMin!!.toLong() * 60000

    private var isPlaying = true

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBg.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgRes!!)
        ivLogo.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgResLogo!!)

        tvActivityTitle.text = CURRENT_ACTIVITY_DESCRIPTION.title
        tvTime.text = "${CURRENT_ACTIVITY_DESCRIPTION.timeInMin}:00"

        mediaPlayer = MediaPlayer.create(context, CURRENT_ACTIVITY_DESCRIPTION.audioRes!!)
        mediaPlayer.setScreenOnWhilePlaying(true)

        btBack.setOnClickListener { requireActivity().onBackPressed() }

        circularProgressBar.progressMax = CURRENT_ACTIVITY_DESCRIPTION.timeInMin!! * 60f
        circularProgressBar.progress = circularProgressBar.progressMax

        startTracking()

        btPlay.setOnClickListener {
            if (isPlaying) {
                btPlay.setIconResource(R.drawable.ic_play)
                stopTracking()
            } else {
                btPlay.setIconResource(R.drawable.ic_pause)
                startTracking()
            }
        }
    }

    private fun startTracking() {
        println("started tracking...")
        countDownTimer = object : CountDownTimer(remainingTime, 1000) {

            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
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

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                tvTime.text = "00:00"
                findNavController().navigate(R.id.action_timerFragment_to_activityCompletedFragment)
            }
        }
        countDownTimer.start()
        isPlaying = true
        tvTrackProgess.text = getString(R.string.activity_tracking_in_progress)
        mediaPlayer.start()
    }

    private fun stopTracking() {
        mediaPlayer.pause()
        println("stopping tracking...")
        countDownTimer.cancel()
        isPlaying = false
        tvTrackProgess.text = getString(R.string.activity_tracking_paused)
    }

    override fun onStop() {
        super.onStop()
        stopTracking()
        mediaPlayer.release()
    }

}
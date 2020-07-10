package com.arkapp.rootedminds.ui.activityCompleted

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY_DESCRIPTION
import com.arkapp.rootedminds.utility.loadImage
import kotlinx.android.synthetic.main.fragment_activity_completed.*

class ActivityCompletedFragment : Fragment(R.layout.fragment_activity_completed) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivCenterLogo.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgResLogo!!)

        tvTitle.text = CURRENT_ACTIVITY_DESCRIPTION.completionTitle
        tvActivityName.text = "You’ve completed ${CURRENT_ACTIVITY_DESCRIPTION.title}!"

        btCompleted.setOnClickListener { findNavController().navigate(R.id.action_activityCompletedFragment_to_discoverFragment) }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner) {
            findNavController().navigate(R.id.action_activityCompletedFragment_to_discoverFragment)
            true
        }

    }
}
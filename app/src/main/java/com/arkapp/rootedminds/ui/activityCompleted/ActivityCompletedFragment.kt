package com.arkapp.rootedminds.ui.activityCompleted

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.TrackedActivity
import com.arkapp.rootedminds.data.room.AppDatabase
import com.arkapp.rootedminds.data.room.AppDatabase.Companion.getDatabase
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY_DESCRIPTION
import com.arkapp.rootedminds.utility.loadImage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_activity_completed.*
import kotlinx.coroutines.launch
import java.util.*

class ActivityCompletedFragment : Fragment(R.layout.fragment_activity_completed) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val database: AppDatabase = getDatabase(requireContext())
            val activityDoa = database.trackedActivityDao()
            activityDoa.insert(TrackedActivity(
                null,
                CURRENT_ACTIVITY_DESCRIPTION.title,
                Gson().toJson(Date())))
        }


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
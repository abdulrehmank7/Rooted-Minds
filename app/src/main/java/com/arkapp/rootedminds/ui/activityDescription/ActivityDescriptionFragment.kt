package com.arkapp.rootedminds.ui.activityDescription

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY_DESCRIPTION
import com.arkapp.rootedminds.utility.loadImage
import kotlinx.android.synthetic.main.fragment_activity_description.*

class ActivityDescriptionFragment : Fragment(R.layout.fragment_activity_description) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandedImage.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgRes!!)
        ivLogo.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgResLogo!!)
        ivDesc.loadImage(CURRENT_ACTIVITY_DESCRIPTION.imgResDesc!!)

        tvTitle.text = CURRENT_ACTIVITY_DESCRIPTION.title
        tvCount.text = CURRENT_ACTIVITY_DESCRIPTION.countType

        btStart.setOnClickListener { findNavController().navigate(R.id.action_activityDescriptionFragment_to_timerFragment) }
    }
}
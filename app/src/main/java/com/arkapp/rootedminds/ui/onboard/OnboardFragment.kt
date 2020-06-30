package com.arkapp.rootedminds.ui.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import kotlinx.android.synthetic.main.fragment_onboard.*


class OnboardFragment : Fragment(R.layout.fragment_onboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        btProceed.setOnClickListener { findNavController().navigate(R.id.action_onboardFragment_to_termsAndConditionFragment) }
    }
}
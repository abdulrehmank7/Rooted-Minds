package com.arkapp.rootedminds.ui.termsandcondition

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import kotlinx.android.synthetic.main.fragment_terms_and_condition.*
import kotlinx.android.synthetic.main.include_toolbar.*

class TermsAndConditionFragment : Fragment(R.layout.fragment_terms_and_condition) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        materialToolbar.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green1))

        btAccept.setOnClickListener {
            findNavController().navigate(R.id.action_termsAndConditionFragment_to_discoverFragment)
        }

    }
}
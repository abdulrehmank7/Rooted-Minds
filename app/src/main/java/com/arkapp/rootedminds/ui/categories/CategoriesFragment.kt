package com.arkapp.rootedminds.ui.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.*
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btBack.setOnClickListener { requireActivity().onBackPressed() }

        val adapter =
            when (CURRENT_ACTIVITY) {
                0 -> {
                    tvTitle.text = getString(R.string.individual_activities)
                    ActivitiesAdapter(getIndividualActivity())
                }
                1 -> {
                    tvTitle.text = getString(R.string.group_activities)
                    ActivitiesAdapter(getGroupActivity())
                }
                2 -> {
                    tvTitle.text = getString(R.string.inc_positive_activities)
                    ActivitiesAdapter(getPositiveFeelingActivity())
                }
                3 -> {
                    tvTitle.text = getString(R.string.inc_stress_relief_activities)
                    ActivitiesAdapter(getStressReliefActivity())
                }
                4 -> {
                    tvTitle.text = getString(R.string.inc_improve_memory_activities)
                    ActivitiesAdapter(getImproveMemoryActivity())
                }
                else -> {
                    tvTitle.text = getString(R.string.individual_activities)
                    ActivitiesAdapter(getIndividualActivity())
                }
            }

        rvActivities.initVerticalAdapter(adapter, true)
    }
}
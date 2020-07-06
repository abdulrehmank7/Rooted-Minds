package com.arkapp.rootedminds.ui.discover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.include_toolbar.*

class DiscoverFragment : Fragment(R.layout.fragment_discover) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivMenu.show()
        ivMenu.setOnClickListener { requireActivity().drawerLayout.open() }

        val homeFeatureAdapter = HomeFeatureAdapter(getFeatures(), findNavController())
        rvFeature.initHorizontalAdapter(homeFeatureAdapter, true)

        val homeCategoryAdapter = HomeCategoryAdapter(getCategories(), findNavController())
        rvCategory.initVerticalAdapter(homeCategoryAdapter, true)
    }
}
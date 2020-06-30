package com.arkapp.rootedminds.ui.discover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.utility.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class DiscoverFragment : Fragment(R.layout.fragment_discover) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivMenu.show()

        ivMenu.setOnClickListener { requireActivity().drawerLayout.open() }
    }
}
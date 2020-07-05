package com.arkapp.rootedminds.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.arkapp.rootedminds.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findNavController(R.id.fragment)
            .addOnDestinationChangedListener { _: NavController?, destination: NavDestination, _: Bundle? ->
                if (destination.id == R.id.discoverFragment)
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                else
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }

        navView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.menu5) {
                findNavController(R.id.fragment).navigate(R.id.action_discoverFragment_to_partnersFragment)
            }
            true
        }
    }
}
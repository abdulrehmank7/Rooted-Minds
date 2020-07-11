package com.arkapp.rootedminds.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.preferences.PrefSession
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val prefSession = PrefSession(this)
        if (!prefSession.isAppOpened()) {
            findNavController(R.id.fragment).navigate(R.id.onboardFragment)
        }

        findNavController(R.id.fragment)
            .addOnDestinationChangedListener { _: NavController?, destination: NavDestination, _: Bundle? ->
                if (destination.id == R.id.discoverFragment ||
                    destination.id == R.id.partnersFragment ||
                    destination.id == R.id.helplinesFragment ||
                    destination.id == R.id.aboutUsFragment ||
                    destination.id == R.id.referencesFragment ||
                    destination.id == R.id.monthViewFragment)
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                else
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1 -> findNavController(R.id.fragment).navigate(R.id.discoverFragment)
                R.id.menu2 -> findNavController(R.id.fragment).navigate(R.id.monthViewFragment)
                R.id.menu4 -> findNavController(R.id.fragment).navigate(R.id.aboutUsFragment)
                R.id.menu5 -> findNavController(R.id.fragment).navigate(R.id.partnersFragment)
                R.id.menu6 -> findNavController(R.id.fragment).navigate(R.id.helplinesFragment)
                R.id.menu7 -> findNavController(R.id.fragment).navigate(R.id.referencesFragment)
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}
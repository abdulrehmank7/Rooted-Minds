package com.arkapp.rootedminds.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arkapp.rootedminds.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

/*        val navController = findNavController(R.id.fragment)
        NavigationUI.setup(this, navController)*/

        /* this.findNavController(R.id.fragment)
             .addOnDestinationChangedListener { _: NavController?, destination: NavDestination, _: Bundle? ->
                 if (destination.id == R.id.splashFragment) {
                     supportActionBar!!.hide()
                     bottomNavigation.hide()
                 } else {
                     supportActionBar!!.show()
                     bottomNavigation.show()
                 }
             }*/
    }
}
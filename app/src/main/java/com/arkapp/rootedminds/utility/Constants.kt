package com.arkapp.rootedminds.utility

import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Feature

/**
 * Created by Abdul Rehman on 01-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

fun getFeatures(): ArrayList<Feature> {

    val features = ArrayList<Feature>()

    features.add(Feature("Visualisation\nMeditation", "Senses", R.drawable.img_feature1, R.drawable.ic_feature1))
    features.add(Feature("Connecting with \nnature", "Touch", R.drawable.img_feature2, R.drawable.ic_feature2))
    features.add(Feature("Relationship\nWalk", "", R.drawable.img_feature3, R.drawable.ic_feature3))
    features.add(Feature("Connecting with\nEarth", "Sight and Touch", R.drawable.img_feature4, R.drawable.ic_feature4))
    features.add(Feature("Friends\nwith Trees", "", R.drawable.img_feature5, R.drawable.ic_feature5))
    features.add(Feature("Relationship\nwith Trees", "", R.drawable.img_feature6, R.drawable.ic_feature6))

    return features
}
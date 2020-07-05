package com.arkapp.rootedminds.utility

import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Activities
import com.arkapp.rootedminds.data.models.Category
import com.arkapp.rootedminds.data.models.Feature

/**
 * Created by Abdul Rehman on 01-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
var CURRENT_ACTIVITY = 0


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


fun getCategories(): ArrayList<Category> {

    val categories = ArrayList<Category>()
    categories.add(Category("Individual Activities", R.drawable.img_category1))
    categories.add(Category("Group Activities", R.drawable.img_category2))
    categories.add(Category("Increase Positive Feeling", R.drawable.img_category3))
    categories.add(Category("Relieve Stress", R.drawable.img_category4))
    categories.add(Category("Improve Memory", R.drawable.img_category5))

    return categories
}

fun getIndividualActivity(): ArrayList<Activities> {

    val activities = ArrayList<Activities>()
    activities.add(Activities("Visualisation Mediation", R.drawable.img_individual_activity1, 3))
    activities.add(Activities("Connecting with the Earth", R.drawable.img_individual_activity2, 2))
    activities.add(Activities("Connecting with Nature", R.drawable.img_individual_activity3, 10))
    activities.add(Activities("Friends with Trees", R.drawable.img_individual_activity4, 3))

    return activities
}

fun getGroupActivity(): ArrayList<Activities> {

    val activities = ArrayList<Activities>()
    activities.add(Activities("Relationship with Trees", R.drawable.img_group_activity1, 3))
    activities.add(Activities("Relationship Walk", R.drawable.img_group_activity2, 55))

    return activities
}

fun getPositiveFeelingActivity(): ArrayList<Activities> {

    val activities = ArrayList<Activities>()
    activities.add(Activities("Visualisation Mediation", R.drawable.img_individual_activity1, 3))
    activities.add(Activities("Connecting with the Earth", R.drawable.img_individual_activity2, 2))
    activities.add(Activities("Connecting with Nature", R.drawable.img_individual_activity3, 10))
    activities.add(Activities("Friends with Trees", R.drawable.img_individual_activity4, 3))

    return activities
}

fun getStressReliefActivity(): ArrayList<Activities> {

    val activities = ArrayList<Activities>()
    activities.add(Activities("Visualisation Mediation", R.drawable.img_individual_activity1, 3))
    activities.add(Activities("Connecting with the Earth", R.drawable.img_individual_activity2, 2))
    activities.add(Activities("Connecting with Nature", R.drawable.img_individual_activity3, 10))
    activities.add(Activities("Friends with Trees", R.drawable.img_individual_activity4, 3))

    return activities
}


fun getImproveMemoryActivity(): ArrayList<Activities> {

    val activities = ArrayList<Activities>()
    activities.add(Activities("Visualisation Mediation", R.drawable.img_individual_activity1, 3))
    activities.add(Activities("Connecting with the Earth", R.drawable.img_individual_activity2, 2))

    return activities
}

package com.arkapp.rootedminds.utility

import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.*

/**
 * Created by Abdul Rehman on 01-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
var CURRENT_ACTIVITY = 0
var CURRENT_ACTIVITY_DESCRIPTION = ActivitiesDescription()
var CURRENT_OPENED_REFLECTION_HISTORY: ReflectionParsed? = null


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

val CONNECTING_WITH_EARTH =
    ActivitiesDescription(
        "Connecting with Earth",
        "Solo/Partner",
        R.drawable.img_individual_activity2,
        R.drawable.ic_feature4,
        R.drawable.img_connecting_with_earth_desc,
        2,
        R.raw.sound_connecting_with_earth,
        "Way to Go!")

val VISUALISATION_MEDITATION =
    ActivitiesDescription(
        "Visualisation Meditation",
        "Solo/Partner",
        R.drawable.img_individual_activity1,
        R.drawable.ic_feature1,
        R.drawable.img_visual_meditatation_desc,
        3,
        R.raw.sound_visualisation_meditation,
        "Well Done!")

val FRIENDS_WITH_TREES =
    ActivitiesDescription(
        "Friends with Trees",
        "Solo",
        R.drawable.img_individual_activity4,
        R.drawable.ic_feature5,
        R.drawable.img_friends_desc,
        3,
        R.raw.sound_friends_with_trees,
        "Amazing!")

val CONNECTING_WITH_NATURE =
    ActivitiesDescription(
        "Connecting with Nature",
        "Solo/Partner",
        R.drawable.img_individual_activity3,
        R.drawable.ic_feature2,
        R.drawable.img_connecting_with_nature_desc,
        10,
        R.raw.sound_connecting_with_nature,
        "You're doing Great!")

val RELATIONSHIP_WALK =
    ActivitiesDescription(
        "Relationship Walk",
        "Partner",
        R.drawable.img_group_activity2,
        R.drawable.ic_feature3,
        R.drawable.img_relationship_desc,
        55,
        R.raw.sound_relationship_walk,
        "Keep it up!")

val RELATIONSHIP_WITH_TREES =
    ActivitiesDescription(
        "Relationship with Trees",
        "Solo/Partner",
        R.drawable.img_group_activity1,
        R.drawable.ic_feature6,
        R.drawable.img_relationtion_tree_desc,
        3,
        R.raw.sound_relationship_with_trees,
        "Outstanding Work!")

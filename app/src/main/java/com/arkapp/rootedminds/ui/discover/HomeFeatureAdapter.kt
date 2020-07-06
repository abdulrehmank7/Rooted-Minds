package com.arkapp.rootedminds.ui.discover

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Feature
import com.arkapp.rootedminds.utility.*

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class HomeFeatureAdapter(private val allFeatures: List<Feature>, private val findNavController: NavController) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeFeatureViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_home_feature,
                parent,
                false))
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as HomeFeatureViewHolder).viewBinding

        binding.ivTop.loadImage(allFeatures[position].topImgRes!!)
        binding.ivLogo.loadImage(allFeatures[position].logoImgRes!!)

        binding.tvTitle.text = allFeatures[position].title
        binding.tvBottom.text = allFeatures[position].desc

        binding.cvParent.setOnClickListener {
            when (position) {
                0 -> CURRENT_ACTIVITY_DESCRIPTION = VISUALISATION_MEDITATION
                1 -> CURRENT_ACTIVITY_DESCRIPTION = CONNECTING_WITH_NATURE
                2 -> CURRENT_ACTIVITY_DESCRIPTION = RELATIONSHIP_WALK
                3 -> CURRENT_ACTIVITY_DESCRIPTION = CONNECTING_WITH_EARTH
                4 -> CURRENT_ACTIVITY_DESCRIPTION = FRIENDS_WITH_TREES
                5 -> CURRENT_ACTIVITY_DESCRIPTION = RELATIONSHIP_WITH_TREES
            }

            findNavController.navigate(R.id.action_discoverFragment_to_activityDescriptionFragment)
        }
    }

    override fun getItemCount() = allFeatures.size

    override fun getItemId(position: Int): Long {
        return allFeatures[position].hashCode().toLong()
    }

}
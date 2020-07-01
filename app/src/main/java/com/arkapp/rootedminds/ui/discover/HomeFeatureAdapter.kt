package com.arkapp.rootedminds.ui.discover

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Feature
import com.arkapp.rootedminds.utility.loadImage

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class HomeFeatureAdapter(private val allFeatures: List<Feature>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
    }

    override fun getItemCount() = allFeatures.size

    override fun getItemId(position: Int): Long {
        return allFeatures[position].hashCode().toLong()
    }

}
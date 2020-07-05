package com.arkapp.rootedminds.ui.categories

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Activities
import com.arkapp.rootedminds.utility.loadImage

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class ActivitiesAdapter(private val allActivities: List<Activities>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ActivitiesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_activities,
                parent,
                false))
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ActivitiesViewHolder).viewBinding

        binding.ivTop.loadImage(allActivities[position].imgRes!!)

        binding.tvTitle.text = allActivities[position].title
        binding.tvTime.text = "Duration: ${allActivities[position].timeInMin.toString()} minutes"
    }

    override fun getItemCount() = allActivities.size

    override fun getItemId(position: Int): Long {
        return allActivities[position].hashCode().toLong()
    }

}
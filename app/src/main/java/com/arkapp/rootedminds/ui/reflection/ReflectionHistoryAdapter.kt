package com.arkapp.rootedminds.ui.reflection

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.ReflectionParsed
import com.arkapp.rootedminds.utility.CURRENT_OPENED_REFLECTION_HISTORY

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class ReflectionHistoryAdapter(private val allReflections: List<ReflectionParsed>, private val findNavController: NavController) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReflectionHistoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_reflection_history,
                parent,
                false))
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ReflectionHistoryViewHolder).viewBinding

        binding.tvTitle.text = allReflections[position].title

        binding.cvParent.setOnClickListener {
            CURRENT_OPENED_REFLECTION_HISTORY = allReflections[position]
            findNavController.navigate(R.id.action_reflectionFragment_to_addReflectionFragment)
        }

    }

    override fun getItemCount() = allReflections.size

    override fun getItemId(position: Int): Long {
        return allReflections[position].hashCode().toLong()
    }

}
package com.arkapp.rootedminds.ui.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Category
import com.arkapp.rootedminds.utility.CURRENT_ACTIVITY
import com.arkapp.rootedminds.utility.loadImage

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class HomeCategoryAdapter(private val allCategories: List<Category>, private val findNavController: NavController) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeCategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_home_category,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as HomeCategoryViewHolder).viewBinding

        binding.ivTop.loadImage(allCategories[position].imgRes!!)
        binding.tvTitle.text = allCategories[position].title

        binding.cvParent.setOnClickListener {
            CURRENT_ACTIVITY = position
            findNavController.navigate(R.id.action_discoverFragment_to_categoriesFragment)
        }
    }

    override fun getItemCount() = allCategories.size

    override fun getItemId(position: Int): Long {
        return allCategories[position].hashCode().toLong()
    }

}
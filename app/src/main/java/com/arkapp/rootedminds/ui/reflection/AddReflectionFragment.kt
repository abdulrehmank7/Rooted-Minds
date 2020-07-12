package com.arkapp.rootedminds.ui.reflection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.arkapp.rootedminds.R
import com.arkapp.rootedminds.data.models.Reflection
import com.arkapp.rootedminds.data.room.AppDatabase
import com.arkapp.rootedminds.utility.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_add_reflection.*
import kotlinx.coroutines.launch
import java.util.*


class AddReflectionFragment : Fragment(R.layout.fragment_add_reflection) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (CURRENT_OPENED_REFLECTION_HISTORY != null) {
            btAddReflection.hide()

            etTitle.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.title)
            etLocation.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.location)
            etNotesOverall.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note1)
            etObservation.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note2)
            etObservationRevealed.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note3)
            etDetail.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note4)
            etChanges.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note5)
            etSensation.setText(CURRENT_OPENED_REFLECTION_HISTORY!!.note6)

            etTitle.isEnabled = false
            etLocation.isEnabled = false
            etNotesOverall.isEnabled = false
            etObservation.isEnabled = false
            etObservationRevealed.isEnabled = false
            etDetail.isEnabled = false
            etChanges.isEnabled = false
            etSensation.isEnabled = false
        }

        btAddReflection.setOnClickListener {

            if (etTitle.value().isEmpty() &&
                etLocation.value().isEmpty() &&
                etNotesOverall.value().isEmpty() &&
                etObservation.value().isEmpty() &&
                etObservationRevealed.value().isEmpty() &&
                etDetail.value().isEmpty() &&
                etChanges.value().isEmpty() &&
                etSensation.value().isEmpty()) {
                requireActivity().toast("Please enter reflection details...")
                return@setOnClickListener
            }

            lifecycleScope.launch {
                progressBar.show()
                requireActivity().window.disableTouch()
                val database: AppDatabase = AppDatabase.getDatabase(requireContext())
                val reflectionDoa = database.reflectionDoa()
                reflectionDoa.insert(
                    Reflection(
                        null,
                        etTitle.value(),
                        etLocation.value(),
                        etNotesOverall.value(),
                        etObservation.value(),
                        etObservationRevealed.value(),
                        etDetail.value(),
                        etChanges.value(),
                        etSensation.value(),
                        Gson().toJson(Date())))

                requireActivity().window.enableTouch()
                requireActivity().onBackPressed()
            }

        }
    }
}
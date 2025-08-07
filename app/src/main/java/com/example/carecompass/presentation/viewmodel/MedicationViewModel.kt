package com.example.carecompass.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.carecompass.domain.model.Medication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MedicationViewModel : ViewModel() {
    private val _medications = MutableStateFlow<List<Medication>>(emptyList())
    val medications: StateFlow<List<Medication>> = _medications

    fun addMedication(name: String, time: String) {
        val newMedication = Medication(name = name, time = time)
        _medications.value = _medications.value + newMedication
    }

    fun deleteMedication(id: String) {
        _medications.value = _medications.value.filterNot { it.id == id }
    }
}

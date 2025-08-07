package com.example.carecompass.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.carecompass.domain.model.Appointment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppointmentViewModel : ViewModel() {
    private val _appointments = MutableStateFlow<List<Appointment>>(emptyList())
    val appointments: StateFlow<List<Appointment>> = _appointments

    private var nextId = 1

    fun addAppointment(title: String, dateTime: String) {
        val newAppointment = Appointment(id = nextId++, title = title, dateTime = dateTime)
        _appointments.value = _appointments.value + newAppointment
    }

    fun deleteAppointment(id: Int) {
        _appointments.value = _appointments.value.filterNot { it.id == id }
    }
}

package com.example.carecompass.presentation.screens.appointment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carecompass.presentation.viewmodel.AppointmentViewModel
import com.example.carecompass.presentation.navigation.Routes
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScreen(navController: NavController, viewModel: AppointmentViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var dateTime by remember { mutableStateOf("") }
    val appointments by viewModel.appointments.collectAsState()
    val context = LocalContext.current


    LaunchedEffect(Unit) {
        if (appointments.isEmpty()) {
            viewModel.addAppointment(
                title = "Dentist Appointment",
                dateTime = "2025-08-10 10:00 AM"
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Upcoming Appointments") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.Dashboard.route) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Appointment Title") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = dateTime,
                onValueChange = { dateTime = it },
                label = { Text("Date & Time") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (title.isNotBlank() && dateTime.isNotBlank()) {
                        viewModel.addAppointment(title, dateTime)
                        Toast.makeText(context, "Appointment added!", Toast.LENGTH_SHORT).show()
                        title = ""
                        dateTime = ""
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Add")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Upcoming Appointments:", style = MaterialTheme.typography.titleMedium)

            LazyColumn {
                items(appointments) { appointment ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(text = appointment.title, style = MaterialTheme.typography.bodyLarge)
                                Text(text = appointment.dateTime, style = MaterialTheme.typography.bodySmall)
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = { viewModel.deleteAppointment(appointment.id) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}


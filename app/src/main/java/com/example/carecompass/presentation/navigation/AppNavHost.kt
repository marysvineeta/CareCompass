package com.example.carecompass.presentation.navigation

import com.example.carecompass.presentation.screens.notes.NotesScreen
import com.example.carecompass.presentation.screens.tasks.TasksScreen
import com.example.carecompass.presentation.screens.medication.MedicationScreen
import com.example.carecompass.presentation.screens.quote.QuoteScreen
import com.example.carecompass.presentation.screens.appointment.AppointmentScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carecompass.presentation.screens.auth.LoginScreen
import com.example.carecompass.presentation.screens.auth.SignupScreen
import com.example.carecompass.presentation.screens.dashboard.DashboardScreen
import com.example.carecompass.presentation.screens.healthtips.HealthTipScreen
import com.example.carecompass.presentation.screens.helpsupport.HelpSupportScreen
import com.example.carecompass.presentation.screens.emergency.EmergencyAlertScreen


@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = Routes.Login.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Routes.Signup.route) {
            SignupScreen(navController = navController)
        }
        composable(Routes.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(Routes.Tasks.route) {
            TasksScreen(navController = navController)
        }
        composable(Routes.Notes.route) {
            NotesScreen(navController = navController)
        }
        composable(Routes.Medications.route) {
            MedicationScreen(navController = navController)
        }
        composable(Routes.Quote.route) {
            QuoteScreen(navController)
        }
        composable(Routes.Appointment.route) {
            AppointmentScreen(navController)
        }
        composable(Routes.HealthTips.route) {
            HealthTipScreen(navController)
        }
        composable(Routes.HelpSupport.route) {
            HelpSupportScreen(navController)
        }
        composable(Routes.Emergency.route) {
            EmergencyAlertScreen(navController)
        }







    }
}

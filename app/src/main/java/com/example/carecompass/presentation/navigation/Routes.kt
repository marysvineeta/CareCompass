package com.example.carecompass.presentation.navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Signup : Routes("signup")
    object Dashboard : Routes("dashboard")
    object Tasks : Routes("tasks")
    object Notes : Routes("notes")
    object Medications : Routes("medications")

    object Quote : Routes("quote")
    object Appointment : Routes("appointment_screen")

    object HealthTips : Routes("health_tip")

    object HelpSupport : Routes("help_support")
    object Emergency : Routes("emergency")




}

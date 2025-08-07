CareCompass is an Android app designed to support families and caregivers in managing the healthcare and wellbeing of elderly individuals. The app provides a centralized dashboard to coordinate tasks, track medications, manage appointments, and respond to emergencies efficiently.

Core Features & Implementation

1. User Authentication
Firebase Authentication is used for secure sign-up and login.
Auth flow is implemented using `LoginScreen.kt` and `SignupScreen.kt`.
Navigation is managed via `NavController` with Jetpack Compose.

2. Task Manager
Users can add, view, and delete caregiving tasks.
Tasks are stored in an in-memory list using a ViewModel (`TaskViewModel`), avoiding Room for simplicity.
Implemented using Jetpack Compose’s `LazyColumn` for dynamic display.

3. Notes
Caregivers can record shared notes about the patient’s condition.
Notes are stored using Firebase Firestore.
Users can add and delete notes with real-time updates.

4. Medication Reminders
Allows users to enter medication names and scheduled times.
Data is managed through a `MedicationViewModel` and displayed in a clean card layout.
Provides visual reminders for daily medications.

5. Appointment Tracker
Users can add upcoming doctor or therapy appointments.
Appointments are displayed in a scrollable list format.
Appointments are stored in-memory via ViewModel for simplicity.

6. Quote of the Day
Fetches inspirational quotes from a public API.
Demonstrates API integration using retrofit2.

7. Health Tips
Displays rotating wellness tips for elderly health care.
Static content displayed with friendly UI elements and design.

8. Emergency Alert
Sends out an alert message to designated caregivers.
Quick access from the dashboard with a red warning icon.
Implementation uses dialog prompts to simulate emergency actions.

9. Dashboard Navigation
Centralized access to all features via `DashboardScreen.kt`.
Each feature is accessible via Jetpack Compose buttons and icons.
Clean and accessible design prioritizing ease of use for all users.


Tools used:
Kotlin - Core programming language   
Jetpack Compose - UI Framework                        
Firebase Auth - User Authentication                 
Firebase Firestore - Cloud Notes Storage                 
ViewModel - Data and UI Management              
Retrofit2 - API integration (Quote feature)     


The app has been tested in Android Emulator and runs without any crashes.
Its also known to work on Android API 28 and above.

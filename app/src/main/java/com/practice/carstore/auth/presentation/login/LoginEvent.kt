package com.practice.carstore.auth.presentation.login

/**
 * @author Hazrat Ummar Shaikh
 */

sealed interface LoginEvent {

    data class SetUserName(val userName: String) : LoginEvent

    data class SetPassword(val password: String) : LoginEvent

    data object Login : LoginEvent

    data object TogglePasswordVisibility : LoginEvent
}
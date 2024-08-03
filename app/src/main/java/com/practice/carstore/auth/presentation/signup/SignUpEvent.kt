package com.practice.carstore.auth.presentation.signup

/**
 * @author Hazrat Ummar Shaikh
 */

sealed interface SignUpEvent {

    data class SetFullName(val fullName: String) : SignUpEvent

    data class SeEmail(val email: String) : SignUpEvent

    data class SetMobile(val phone: String) : SignUpEvent

    data class Password(val password: String) : SignUpEvent

    data object TogglePasswordVisibility : SignUpEvent

    data object SignUp : SignUpEvent

}
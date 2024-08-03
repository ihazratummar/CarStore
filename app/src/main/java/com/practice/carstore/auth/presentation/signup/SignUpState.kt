package com.practice.carstore.auth.presentation.signup

data class SignUpState(
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false
)

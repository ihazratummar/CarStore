package com.practice.carstore.auth.presentation.login

data class LoginState(

    val userName: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false
)

package com.practice.carstore.auth

import androidx.lifecycle.ViewModel
import com.practice.carstore.auth.presentation.login.LoginEvent
import com.practice.carstore.auth.presentation.login.LoginState
import com.practice.carstore.auth.presentation.signup.SignUpEvent
import com.practice.carstore.auth.presentation.signup.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * @author Hazrat Ummar Shaikh
 */


@HiltViewModel
class AuthViewModel @Inject constructor(

) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.UnAuthenticated)
    val authState: StateFlow<AuthState> = _authState

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState: StateFlow<SignUpState> = _signUpState


    fun onLoginEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.Login -> {
                signIn()
            }

            is LoginEvent.SetPassword -> {
                _loginState.update {
                    it.copy(
                        password = event.password
                    )
                }
            }

            is LoginEvent.SetUserName -> {
                _loginState.update {
                    it.copy(
                        userName = event.userName
                    )
                }
            }

            LoginEvent.TogglePasswordVisibility -> {
                _loginState.update {
                    it.copy(
                        passwordVisible = !it.passwordVisible
                    )
                }
            }
        }
    }

    fun onSignUpEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.Password -> {
                _signUpState.update {
                    it.copy(
                        password = event.password
                    )
                }
            }

            is SignUpEvent.SeEmail -> {
                _signUpState.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is SignUpEvent.SetFullName -> {
                _signUpState.update {
                    it.copy(
                        fullName = event.fullName
                    )
                }
            }

            is SignUpEvent.SetMobile -> {
                _signUpState.update {
                    it.copy(
                        phoneNumber = event.phone
                    )
                }
            }

            SignUpEvent.SignUp -> {
                signUp()
            }

            SignUpEvent.TogglePasswordVisibility -> {
                _signUpState.update {
                    it.copy(
                        passwordVisible = !it.passwordVisible
                    )
                }
            }
        }
    }

    private fun signIn() {
        _loginState.update {
            it.copy(
                userName = "",
                password = ""
            )
        }
        _authState.value = AuthState.Authenticated
    }

    fun signOut() {
        _authState.value = AuthState.UnAuthenticated
    }

    fun signUp() {
        _signUpState.update {
            it.copy(
                fullName = "",
                email = "",
                phoneNumber = "",
                password = ""
            )
        }
        _authState.value = AuthState.Authenticated
    }

}
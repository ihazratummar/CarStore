package com.practice.carstore.auth.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.practice.carstore.auth.AuthViewModel
import com.practice.carstore.auth.presentation.login.LoginScreen
import com.practice.carstore.auth.presentation.signup.SignUpScreen
import com.practice.carstore.navigation.AuthNav
import kotlinx.serialization.Serializable

/**
 * @author Hazrat Ummar Shaikh
 */

fun NavGraphBuilder.authGraph(
    navController: NavController,
    viewModel: AuthViewModel
) {
    navigation<AuthNav>(startDestination = Login) {
        composable<Login> {
            val state by viewModel.loginState.collectAsState()
            val event = viewModel::onLoginEvent
            LoginScreen(
                onSignUpClick = { navController.navigate(SignUp) },
                state = state,
                event = event,

            )
        }
        composable<SignUp> {
            val state by viewModel.signUpState.collectAsState()
            val event = viewModel::onSignUpEvent
            SignUpScreen(
                onSignInClick = {
                    navController.popBackStack()
                },
                state = state,
                event = event,
            )
        }
    }

}

@Serializable
data object Login

@Serializable
data object SignUp

@Serializable
data object ForgotPassword
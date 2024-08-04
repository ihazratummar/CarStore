package com.practice.carstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.practice.carstore.auth.AuthState
import com.practice.carstore.auth.AuthViewModel
import com.practice.carstore.auth.navigation.Login
import com.practice.carstore.auth.navigation.authGraph
import com.practice.carstore.core.navigation.AppNavigation
import com.practice.carstore.core.navigation.HomeScreen
import com.practice.carstore.core.navigation.contentNav
import kotlinx.serialization.Serializable

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel
) {
    val authState by authViewModel.authState.collectAsState()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (authState is AuthState.UnAuthenticated) ContentNav else ContentNav
    ) {
        authGraph(
            navController = navController,
            viewModel = authViewModel
        )
        contentNav(navController = navController, authViewModel = authViewModel)
    }

}


@Serializable
data object AuthNav

@Serializable
data object ContentNav


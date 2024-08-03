package com.practice.carstore.core.navigation

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.practice.carstore.R
import com.practice.carstore.auth.AuthViewModel
import com.practice.carstore.core.presentation.FavouriteScreen
import com.practice.carstore.core.presentation.home.HomeScreen
import com.practice.carstore.navigation.ContentNav
import kotlinx.serialization.Serializable

/**
 * @author Hazrat Ummar Shaikh
 */

fun NavGraphBuilder.contentNav(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    navigation<ContentNav>(startDestination = HomeScreen) {
        composable<HomeScreen> {
            AppNavigation(authViewModel = authViewModel)
        }
    }
}


@Serializable
data object HomeScreen

@Serializable
data object FavouriteScreen

@Serializable
data object ProfileScreen

@Serializable
data object CarDetailsScreen


@Serializable
sealed class ContentDestinations<T>(val name: String, @DrawableRes val icon: Int, val route: T) {
    @Serializable
    data object Home :
        ContentDestinations<HomeScreen>(name = "Home", icon = R.drawable.home, route = HomeScreen)

    @Serializable
    data object Favourite : ContentDestinations<FavouriteScreen>(
        name = "favourite",
        icon = R.drawable.heart,
        route = FavouriteScreen
    )

    @Serializable
    data object Profile : ContentDestinations<ProfileScreen>(
        name = "Profile",
        icon = R.drawable.profile,
        route = ProfileScreen
    )
}


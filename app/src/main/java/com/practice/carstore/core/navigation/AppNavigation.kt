package com.practice.carstore.core.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.practice.carstore.auth.AuthViewModel
import com.practice.carstore.core.presentation.FavouriteScreen
import com.practice.carstore.core.presentation.details.CarDetailsScreen
import com.practice.carstore.core.presentation.home.HomeScreen
import com.practice.carstore.core.presentation.profile.ProfileScreen

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController, startDestination = HomeScreen
            ) {
                composable<HomeScreen> {
                    HomeScreen(navController = navController)
                }
                composable<FavouriteScreen> {
                    FavouriteScreen(
                        navController = navController,
                        authViewModel = authViewModel
                    )
                }
                composable<ProfileScreen> {
                    ProfileScreen(navController = navController, authViewModel = authViewModel)
                }
                composable<CarDetailsScreen> {
                    CarDetailsScreen(navController = navController)
                }
            }
        }

        val bottomNavItems = listOf(
            ContentDestinations.Home,
            ContentDestinations.Favourite,
            ContentDestinations.Profile
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val isBottomBarVisible =
            bottomNavItems.any { it.route::class.qualifiedName == currentDestination?.route }
        BottomBar(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomEnd)
                .padding(bottom = 26.dp),
            isBottomBarVisible,
            bottomNavItems,
            currentDestination,
            navController
        )
    }
}

@Composable
private fun BottomBar(
    modifier: Modifier,
    isBottomBarVisible: Boolean,
    bottomNavItems: List<ContentDestinations<out Any>>,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 35.dp)
            .shadow(4.dp, shape = RoundedCornerShape(26.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(26.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (isBottomBarVisible) {
                bottomNavItems.forEach { screen ->
                    val isSelected =
                        currentDestination?.hierarchy?.any { it.route == screen.route::class.qualifiedName } == true

                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(shape = RoundedCornerShape(14.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = {
                                navController.navigate(screen.route)
                            }) {
                                Icon(
                                    painter = painterResource(id = screen.icon),
                                    contentDescription = screen.name,
                                    tint = Color(0xFFFF5C00)
                                )
                            }
                        }
                    } else {
                        IconButton(onClick = {
                            navController.navigate(screen.route)
                        }) {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = screen.name,
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

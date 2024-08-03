package com.practice.carstore.core.presentation.details

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun CarDetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold {paddingValues ->  
        LazyColumn (
            contentPadding = paddingValues,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item { 
                Text(text = "Details Page")
            }
        }
    }
}
package com.practice.carstore.core.presentation.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.practice.carstore.R
import com.practice.carstore.auth.AuthState
import com.practice.carstore.auth.AuthViewModel
import com.practice.carstore.auth.navigation.Login
import com.practice.carstore.auth.presentation.component.CustomTextField
import com.practice.carstore.core.domain.model.featuredCars
import com.practice.carstore.core.navigation.CarDetailsScreen
import com.practice.carstore.core.navigation.HomeScreen
import com.practice.carstore.core.navigation.ProfileScreen
import com.practice.carstore.core.presentation.component.FeatureCarsCard
import com.practice.carstore.core.presentation.component.RecommendedCarsCard
import com.practice.carstore.navigation.AuthNav
import com.practice.carstore.navigation.ContentNav

/**
 * @author Hazrat Ummar Shaikh
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "CarStore",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5C00)
                )
            },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(CarDetailsScreen) }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = paddingValues
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                modifier = Modifier.padding(vertical = 10.dp),
                                text = "Search for Honda Pilot 7-Passenger",
                                color = Color(0xFFA8AFB9),
                                style = MaterialTheme.typography.labelLarge,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                modifier = Modifier,
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search",
                                tint = Color(0xFFA8AFB9)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color(0xffEDEEEF),
                            unfocusedContainerColor = Color(0xffEDEEEF)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter"
                    )
                }
            }
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    items(featuredCars) { car ->
                        Box(
                            modifier = Modifier
                                .width(350.dp)
                                .height(210.dp)
                        ) {
                            val painter: Painter = rememberAsyncImagePainter(car.image[0])
                            FeatureCarsCard(
                                modifier = Modifier.padding(5.dp),
                                image = painter,
                                text = car.carShortDetails
                            )
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Recommended", style = MaterialTheme.typography.headlineSmall)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "See all")
                    }
                }
            }
            items(featuredCars.chunked(2)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    it.forEach { car ->
                        val painter: Painter = rememberAsyncImagePainter(car.image[0])
                        RecommendedCarsCard(
                            modifier = Modifier
                                .weight(1f)
                                .padding(5.dp),
                            image = painter,
                            name = car.carShortDetails,
                            price = car.price.toString()
                        )
                    }
                    // If there's only one car in the pair, add an empty space
                    if (it.size < 2) {
                        Spacer(modifier = Modifier.weight(1f).padding(5.dp))
                    }
                }
            }
        }
    }
}
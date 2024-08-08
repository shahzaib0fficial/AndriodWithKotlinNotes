package com.example.app12_flightsearch.ui.theme

import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app12_flightsearch.ui.AddFlight
import com.example.app12_flightsearch.ui.FlightScreen
import com.example.app12_flightsearch.ui.HomeScreen

enum class Screens(val title:String){
    HomeScreen("Flight Search"),
    AddFlight("Add Flight"),
    FlightScreen("Flights")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightTopBar(
    onBackClick: ()-> Unit,
    addFlightClick: ()-> Unit,
    currentScreen: Screens
){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF003151),
            titleContentColor = Color(0xFFFFFFFF)
        ),
        navigationIcon = {
            if (currentScreen.title != Screens.HomeScreen.title){
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xFFFFFFFF)
                    )
                }
            }
        },
        title = {
        Text(
            text = currentScreen.title,
            fontSize = 28.sp
        )
        },
        actions = {
            if(currentScreen.title == Screens.HomeScreen.title){
                IconButton(
                    onClick = { addFlightClick() },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun FlightApp(navController: NavHostController = rememberNavController(),requestPermissionLauncher: ActivityResultLauncher<String>){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.HomeScreen.name
    )
    Scaffold(
        topBar = { FlightTopBar(
            onBackClick = {
                navController.navigateUp()
            },
            addFlightClick = {
                navController.navigate(Screens.AddFlight.name)
            },
            currentScreen = currentScreen
        ) }
    ) { innerPadding->
        ScreenNavigator(innerPadding = innerPadding, navController = navController, requestPermissionLauncher = requestPermissionLauncher)
    }
}

@Composable
fun ScreenNavigator(innerPadding:PaddingValues,navController: NavHostController,requestPermissionLauncher: ActivityResultLauncher<String>){
    var itemName by rememberSaveable {
        mutableStateOf("")
    }
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name, modifier = Modifier.padding(innerPadding)){
        composable(route = Screens.HomeScreen.name){
            HomeScreen(
                requestPermissionLauncher = requestPermissionLauncher,
                onItemClick = {
                    itemName = it
                    navController.navigate(Screens.FlightScreen.name)
                }
            )
        }
        composable(route = Screens.AddFlight.name){
            AddFlight()
        }
        composable(route = Screens.FlightScreen.name){
            FlightScreen(fromAirportName = itemName)
        }
    }
}
package com.example.app11_busshedule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app11_busshedule.ui.AddBusTime
import com.example.app11_busshedule.ui.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusTopBar(currentScreens: Screens,backClick:() -> Unit){
    TopAppBar(
        title = {
            Text(
                currentScreens.title,
                fontSize = 28.sp
            )
        },
        navigationIcon = {
            if (currentScreens.title != Screens.HomeScreen.title){
                IconButton(onClick = { backClick() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

enum class Screens(val title: String){
    HomeScreen("Bus Schedule"),
    AddBusTime("Add Bus Time")
}

@Composable
fun BusApp(navController:NavHostController = rememberNavController()){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?:Screens.HomeScreen.name
    )
    Scaffold (
        topBar = {
            BusTopBar(
                currentScreen,
                backClick = {
                    navController.navigateUp()
                }
            )
        },
        floatingActionButton = {
            if (currentScreen.title == Screens.HomeScreen.title) {
                FloatingActionButton(
                    onClick = { navController.navigate(Screens.AddBusTime.name) },
                    modifier = Modifier.padding(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Schedule Button"
                    )
                }
            }
        }
    )
    { innerPadding->
        AllScreenNavigator(innerPadding,navController)
    }
}

@Composable
fun AllScreenNavigator(innerPadding: PaddingValues,navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name, modifier = Modifier.padding(innerPadding)){
        composable(route = Screens.HomeScreen.name){
            HomeScreen()
        }
        composable(route = Screens.AddBusTime.name){
            AddBusTime(
                onAddClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}
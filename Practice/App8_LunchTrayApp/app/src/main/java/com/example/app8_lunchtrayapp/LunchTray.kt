package com.example.app8_lunchtrayapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app8_lunchtrayapp.data.DataSource
import com.example.app8_lunchtrayapp.ui.ChooseOption
import com.example.app8_lunchtrayapp.ui.StartOrder
import com.example.app8_lunchtrayapp.ui.CheckOut
import com.example.app8_lunchtrayapp.ui.LunchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import android.content.Intent
import android.content.Context
import android.util.Log
import androidx.compose.ui.res.stringResource


enum class LunchTrayScreens(val title: String){
    Start(title = "Lunch Tray"),
    ChooseEntry(title = "Choose Entree"),
    ChooseSideDish(title = "Choose Side Dish"),
    ChooseAccompaniment(title = "Choose Accompaniment"),
    OrderCheckOut(title = "Order Checkout")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayTopAppBar(
    currentScreen: LunchTrayScreens
)
{
    CenterAlignedTopAppBar(
        title = { Text(text = currentScreen.title) },
//        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//            containerColor = Color.Red,
//            titleContentColor = Color.White
//        ) // used to set color to a Top App Bar
    )
}

@Composable
fun LunchTrayApp(
    viewModel: LunchViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)
{
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreens.valueOf(
        backStackEntry?.destination?.route ?:LunchTrayScreens.Start.name
    )
    val uiState by viewModel.uiState.collectAsState()
    Scaffold (
        topBar = {
            LunchTrayTopAppBar(
                currentScreen = currentScreen
            )
        }
    ) {
        innerPadding->

        NavHost(navController = navController, startDestination = LunchTrayScreens.Start.name, modifier = Modifier.padding(innerPadding)) {
            composable(route = LunchTrayScreens.Start.name){
                StartOrder(
                    modifier = Modifier.fillMaxSize(),
                    onOrderClicked = {
                        navController.navigate(LunchTrayScreens.ChooseEntry.name)
                    }
                )
            }
            composable(route = LunchTrayScreens.ChooseEntry.name){
                ChooseOption(
                    options = DataSource().EntreeList(),
                    modifier = Modifier.fillMaxSize(),
                    onSelectionChange = {
                        viewModel.setEntree(it.first)
                        viewModel.setEntreePrice(it.third)
                        viewModel.setTotalPrice(it.third)
                                        },
                    OnNextClick = {
                        navController.navigate(LunchTrayScreens.ChooseSideDish.name)
                    },
                    onCancelClick = {
                        navController.popBackStack(LunchTrayScreens.Start.name,inclusive = false)
                        viewModel.reSet()
                    }
                )
            }
            composable(route = LunchTrayScreens.ChooseSideDish.name){
                ChooseOption(
                    modifier = Modifier.fillMaxSize(),
                    options = DataSource().SideDishList(),
                    onSelectionChange = {
                        viewModel.setSideDish(it.first)
                        viewModel.setSideDishPrice(it.third)
                        viewModel.setTotalPrice(it.third)
                                        },
                    OnNextClick = {
                        navController.navigate(LunchTrayScreens.ChooseAccompaniment.name)
                    },
                    onCancelClick = {
                        navController.popBackStack(LunchTrayScreens.Start.name,inclusive = false)
                        viewModel.reSet()
                    }
                )
            }
            composable(route = LunchTrayScreens.ChooseAccompaniment.name){
                ChooseOption(
                    modifier = Modifier.fillMaxSize(),
                    options = DataSource().AccompanientList(),
                    onSelectionChange = {
                        viewModel.setAccompanient(it.first)
                        viewModel.setAccompanientPrice(it.third)
                        viewModel.setTotalPrice(it.third)
                    },
                    OnNextClick = {
                        navController.navigate(LunchTrayScreens.OrderCheckOut.name)
                    },
                    onCancelClick = {
                        navController.popBackStack(LunchTrayScreens.Start.name,inclusive = false)
                        viewModel.reSet()
                    }
                )
            }
            composable(route = LunchTrayScreens.OrderCheckOut.name){
                val context = LocalContext.current
                CheckOut(
                    modifier = Modifier.fillMaxSize(),
                    uiState = uiState,
                    onSubmitClick = { summary: String->
                        onSubmit(context,summary)
                    },
                    onCancelClick = {
                        navController.popBackStack(LunchTrayScreens.Start.name,inclusive = false)
                        viewModel.reSet()
                    }
                )
            }
        }
    }
}

private fun onSubmit(context: Context, orderSummary:String){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT,context.getString(R.string.order_detail))
        putExtra(Intent.EXTRA_TEXT,orderSummary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.order_detail_title)
        )
    )
}
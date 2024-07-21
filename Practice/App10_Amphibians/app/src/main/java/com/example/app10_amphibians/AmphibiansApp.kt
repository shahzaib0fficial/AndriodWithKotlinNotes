package com.example.app10_amphibians

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app10_amphibians.network.AppUiState
import com.example.app10_amphibians.network.DataFormatClass
import com.example.app10_amphibians.ui.screens.AppViewModel
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.util.CoilUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansTopBar(){
    TopAppBar(
        title = {
            Text(
                text = "Amphibians",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    )
}

@Composable
fun AmphibiansApp(){
    Scaffold (
        topBar = { AmphibiansTopBar() }
    ){innerPadding->
        val appViewModel:AppViewModel = viewModel(factory = AppViewModel.Factory)

        HomeScreen(
            innerPadding,
            appViewModel.uiState,
            onRetry = {
                appViewModel.getData()
                appViewModel.uiState = AppUiState.Loading
            })
//        LoadingScreen(innerPadding = innerPadding)
    }
}

@Composable
fun HomeScreen(innerPadding: PaddingValues,uiState:AppUiState,onRetry: () -> Unit){
    when(uiState){
        is AppUiState.Loading -> LoadingScreen(innerPadding)
        is AppUiState.Success -> SuccessScreen(innerPadding,uiState.data)
        is AppUiState.Error -> ErrorScreen(innerPadding, onRetry = onRetry)
        else -> ErrorScreen(innerPadding, onRetry = onRetry)
    }
}

@Composable
fun SuccessScreen(innerPadding: PaddingValues, data: List<DataFormatClass>){
    LazyColumn(Modifier.padding(innerPadding)) {
        items(data){ item ->
            Card(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 10.dp, bottomEnd = 10.dp)
            ) {
                Text(
                    text = "${item.name} (Toad)",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(item.img_src)
                        .crossfade(true)
                        .build(),
                    contentDescription = item.description,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.ic_broken_image),
                    placeholder = painterResource(id = R.drawable.loading_img)
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun LoadingScreen(innerPadding:PaddingValues){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_img),
            modifier = Modifier.size(500.dp),
            contentDescription = null,
        )
    }
}

@Composable
fun ErrorScreen(innerPadding:PaddingValues,onRetry:()->Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            modifier = Modifier.size(200.dp),
            contentDescription = null,
        )
        Button(onClick = onRetry) {
            Text(
                text = "Retry"
            )
        }
    }
}























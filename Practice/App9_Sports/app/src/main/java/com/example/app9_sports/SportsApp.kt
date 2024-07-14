package com.example.app9_sports

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.app9_sports.data.Sport
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app9_sports.data.SportsData
import com.example.app9_sports.ui.SportUiState
import com.example.app9_sports.ui.SportViewModel
import com.example.app9_sports.ui.utils.NavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportTopAppBar(text:String,backButton: Boolean,onBackClicked: ()->Unit = {}){
    TopAppBar(
        title = {Text(text = text)},
        navigationIcon = {
            if (backButton){
                IconButton(onClick = { onBackClicked() }) {
                    Icon(imageVector = Icons.Default.ArrowBack , contentDescription = "Back Button")
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF006400),
            titleContentColor = Color.White
        )
    )
}

@Composable
fun SportApp(modifier: Modifier = Modifier,windowWidth: WindowWidthSizeClass){
    val viewModel: SportViewModel = viewModel()
    val uiState: SportUiState = viewModel._uiState.collectAsState().value

    val navigationType: NavigationType = when(windowWidth){
        WindowWidthSizeClass.Compact -> {
            NavigationType.COMPACT
        }
        WindowWidthSizeClass.Medium -> {
            NavigationType.MEDIUM
        }
        WindowWidthSizeClass.Expanded -> {
            NavigationType.Expanded
        }
        else ->{
            NavigationType.COMPACT
        }
    }

    Scaffold(
        topBar = {
            if (uiState.DetailScreen){
                SportTopAppBar(text = "Sports Info",backButton = true, onBackClicked = {viewModel.setDetailScreen(false)})
            }
            else{
                SportTopAppBar(text = "Sports", backButton = false)
            }
        }
    ) { innerPadding ->
        if(uiState.DetailScreen) {
            if (navigationType == NavigationType.MEDIUM){
                viewModel.setDetailScreen(false)
                viewModel.setDetailMediumScreen(true)
            }
            else{
                DetailScreen(innerPadding, currentSelectedSport = uiState.currentSelectedSport, onBackClicked = {viewModel.setDetailScreen(false)})
            }
        }
        else
        {
            viewModel.setDetailScreen(false)
            if (navigationType == NavigationType.MEDIUM){
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        HomeScreen(
                            sports = SportsData().sportsData,
                            innerPadding = innerPadding,
                            cardClick = {
                                viewModel.setCurrentSport(it.id)
                                viewModel.setDetailMediumScreen(true)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    if (uiState.detailMediumScreen){
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            DetailScreen(innerPadding = innerPadding, currentSelectedSport = uiState.currentSelectedSport, onBackClicked = { viewModel.setDetailMediumScreen(false) })
                        }
                    }
                }
            }
            else{
                viewModel.setDetailMediumScreen(false)
                HomeScreen(
                    sports = SportsData().sportsData,
                    innerPadding = innerPadding,
                    cardClick = {
                        viewModel.setCurrentSport(it.id)
                        viewModel.setDetailScreen(true)
                    }
                )
            }
        }
    }
}

@Composable
fun HomeScreen(sports: List<Sport>,innerPadding: PaddingValues,cardClick: (Sport)->Unit){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(scrollState)
    ) {
        sports.forEach { sport ->
            Card(
                modifier = Modifier
                    .clickable {
                        cardClick(sport)
                    }
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                ) {
                    Image(
                        painter = painterResource(id =sport.image),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxHeight()
                            //.height(100.dp)
                            .width(100.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = sport.Title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = sport.BasicInfo,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${sport.Players} Players",
                                fontSize = 12.sp
                            )
                            if (sport.Olympics){
                                Text(
                                    text = "Olympics",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(innerPadding: PaddingValues, currentSelectedSport:Sport,onBackClicked: () -> Unit){
    BackHandler {
        onBackClicked()
    }

    Column {
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = currentSelectedSport.image),
                contentDescription =null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.FillHeight
            )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp),
                ) {
                    Text(
                        text = currentSelectedSport.Title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Players ${currentSelectedSport.Players}",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                        if (currentSelectedSport.Olympics){
                            Text(
                                text = "Olympic",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
        }

        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {
            item {
                Text(
                    text = currentSelectedSport.Description
                )
            }
        }
    }

}

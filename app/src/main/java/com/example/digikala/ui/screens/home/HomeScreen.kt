package com.example.digikala.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala.util.Constants.USER_LANGUAGE
import com.example.digikala.util.LocaleUtils
import com.example.digikala.viewmodel.HomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {

    Home(navController)
}

@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
    LaunchedEffect(true) {
        refreshData(viewModel)
    }
    SwipeRefreshSection(viewModel, navController)

}

@Composable
fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshData(viewModel)
            }
        }) {

        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 60.dp)) {
            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowcaseSection(navController) }
            item { AmazingOfferSection() }
        }


    }

}


private suspend fun refreshData(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()


}
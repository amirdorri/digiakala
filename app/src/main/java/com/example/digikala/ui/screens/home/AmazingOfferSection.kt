package com.example.digikala.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.remote.NetworkResult
import com.example.digikala.viewmodel.HomeViewModel

@Composable
fun AmazingOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var amazingItemList by remember{ mutableStateOf<List<AmazingItem>>(emptyList()) }
    var loading by remember { mutableStateOf(false) }
    val amazingItemResult by viewModel.amazingItems.collectAsState()

    when(amazingItemResult) {

        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.e("dorrri1", amazingItemList[0].name)
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("dorrri2", amazingItemResult.message.toString())
        }

        is NetworkResult.Loading -> {
            loading = true
        }

    }

}
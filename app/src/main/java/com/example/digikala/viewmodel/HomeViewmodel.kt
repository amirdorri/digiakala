package com.example.digikala.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.digikala.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.remote.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                amazingItems.emit(repository.getAmazingItems())
            }


        }
    }

//    suspend fun getSlider() {
//        viewModelScope.launch {
//           // val result =
//            slider.emit(repository.getSlider())
//        }
//    }
//
//    suspend fun getAmazingItems() {
//        viewModelScope.launch {
//            amazingItems.emit(repository.getAmazingItems())
//        }
//    }

}
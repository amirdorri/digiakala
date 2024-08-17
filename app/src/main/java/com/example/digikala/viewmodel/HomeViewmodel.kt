package com.example.digikala.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.digikala.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.remote.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository): ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    suspend fun getSlider(){
        Log.d("HomeViewModel", "getSlider called")
        viewModelScope.launch {
            val result = repository.getSlider()
            Log.d("HomeViewModel", "Repository returned: $result")
            slider.emit(result)
        }
    }
}
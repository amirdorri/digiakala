package com.example.digikala.repository

import android.util.Log
import com.example.digikala.data.datastore.BaseApiResponse
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.remote.HomeApiInterface
import com.example.digikala.data.remote.NetworkResult
import com.example.digikala.di.HomeApiInterfaceModule
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : HomeApiInterface): BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> {
        Log.d("HomeRepository", "API call getSlider")
        return safeApiCall {
            api.getSlider()
        }
    }

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> {
        Log.d("HomeRepository", "API call getSlider")
        return safeApiCall {
            api.getAmazingItems()
        }
    }

}
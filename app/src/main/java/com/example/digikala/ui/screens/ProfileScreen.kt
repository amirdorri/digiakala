package com.example.digikala.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala.MainActivity
import com.example.digikala.util.Constants.ENGLISH_LANG
import com.example.digikala.util.Constants.PERSIAN_LANG
import com.example.digikala.viewmodel.DataStoreViewModel


@Composable
fun profileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val activity = LocalContext.current as Activity

        Text(text = "profile screen")

        Button(onClick = { //farsi
            dataStore.saveUserLanguage(PERSIAN_LANG)
            activity.finish()
            activity.startActivity(Intent(activity, MainActivity::class.java))
             }) {

            Text(text = "Fa")

        }

        Button(onClick = {  //english
            dataStore.saveUserLanguage(ENGLISH_LANG)

            activity.finish()
            activity.startActivity(Intent(activity, MainActivity::class.java))
            }) {

            Text(text = "En")

        }


    }

}
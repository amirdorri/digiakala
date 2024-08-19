package com.example.digikala.ui.theme

import android.provider.CalendarContract
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//val Purple80 = Color(0xffed1b34)
//val PurpleGrey80 = Color(0xFFCCC2DC)
//val Pink80 = Color(0xFFEFB8C8)
//
//val Purple40 = Color(0xFF6650a4)
//val PurpleGrey40 = Color(0xFF625b71)
//val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.splashBg : Color
    @Composable
    get() = Color(0xffed1b34)

val Colors.selecedBottomBar : Color
    @Composable
    get() = if (isLight)  Color(0xff43474c) else Color(0xffcfd4da)

val Colors.unSelecedBottomBar : Color
    @Composable
    get() = if (isLight)  Color(0xffa4a1a1) else Color(0xff575a5e)


val Colors.searchBarBg : Color
    @Composable
    get() = if (isLight)  Color(0xfff1f0ee) else Color(0xff303235)



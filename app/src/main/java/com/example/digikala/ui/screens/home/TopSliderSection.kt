package com.example.digikala.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.remote.NetworkResult
import com.example.digikala.ui.theme.LocalShape
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.viewmodel.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopSliderSection(viewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current

    var sliderList by remember { mutableStateOf<List<Slider>>(emptyList()) }

    var loading by remember { mutableStateOf(false) }

    val sliderResult by viewModel.slider.collectAsState()

    //   LaunchedEffect(true) {
//        viewModel.slider.collectLatest { result ->

    when (sliderResult) {

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Success -> {
            sliderList = sliderResult.data ?: emptyList()
            loading = false
            //Toast.makeText(context, "${sliderResult.message}", Toast.LENGTH_LONG).show()

        }

        is NetworkResult.Error -> {
            loading = false
            Toast.makeText(context, "${sliderResult.message}", Toast.LENGTH_LONG).show()

        }
    }
//
//        }
//    }

    Column(
        modifier = Modifier
            .height(200.dp)
            .background(Color.White)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(
                    horizontal = LocalSpacing.current.extraSmall,
                    vertical = LocalSpacing.current.small,

                    )
        ) {

            val pagerState = com.google.accompanist.pager.rememberPagerState()
            var imageUrl by remember { mutableStateOf("") }

            com.google.accompanist.pager.HorizontalPager(
                count = sliderList.size,
                state = pagerState,
                contentPadding = PaddingValues(horizontal = LocalSpacing.current.medium),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { index ->

                imageUrl = sliderList[index].image

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {

                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = imageUrl)
                            .apply(
                                block = fun ImageRequest.Builder.() {
                                    scale(Scale.FILL)
                                }
                            )
                            .build()

                    )
                   
                    Image(
                        painter = painter, contentDescription = "",
                        modifier = Modifier
                            .padding(LocalSpacing.current.small)
                            .clip(LocalShape.current.medium)
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                        )
                    
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(LocalSpacing.current.semiLarge),
                        activeColor = Color.Black,
                        inactiveColor = Color.LightGray,
                        indicatorHeight = LocalSpacing.current.small,
                        indicatorWidth = LocalSpacing.current.small,
                        indicatorShape = CircleShape
                    )


                }

            }

            LaunchedEffect(key1 = pagerState.currentPage) {
                delay(6000)
                var newPosition = pagerState.currentPage + 1
                if (newPosition > sliderList.size - 1 ) newPosition = 0
                pagerState.scrollToPage(newPosition)
            }
            

        }

    }


}
package com.locrz.nearby.ui.components.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.locrz.nearby.R
import com.locrz.nearby.data.model.mocks.mockedUserLocation
import com.locrz.nearby.ui.screens.home.HomeUIState
import com.locrz.nearby.ui.util.findNortheastPoint
import com.locrz.nearby.ui.util.findSouthwestPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import kotlin.math.roundToInt

@Composable
fun NearbyMap(modifier: Modifier = Modifier, uiState: HomeUIState) {

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val density = LocalDensity.current

    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(mockedUserLocation, 15f)
    }

    val uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }

    GoogleMap(
        uiSettings = uiSettings,
        cameraPositionState = cameraPosition
    ) {
        context.getDrawable(R.drawable.ic_user_location)?.let { userPinRes ->
            Marker(
                state = MarkerState(position = mockedUserLocation),
                icon = BitmapDescriptorFactory.fromBitmap(
                    userPinRes.toBitmap(
                        width = density.run { 72.dp.toPx() }.roundToInt(),
                        height = density.run { 72.dp.toPx() }.roundToInt(),
                    )
                )
            )
        }

        context.getDrawable(R.drawable.img_pin)?.let { pinRes ->
            uiState.marketLocations?.toImmutableList()
                ?.forEachIndexed { index, marketLocation ->
                    Marker(
                        state = MarkerState(position = marketLocation),
                        icon = BitmapDescriptorFactory.fromBitmap(
                            pinRes.toBitmap(
                                width = density.run { 36.dp.toPx() }.roundToInt(),
                                height = density.run { 36.dp.toPx() }.roundToInt(),
                            )
                        ),
                        title = uiState.markets?.get(index)?.name
                    )
                }.also {
                    coroutineScope.launch {
                        val allMarks =
                            uiState.marketLocations?.plus(mockedUserLocation)
                        val southwestPoint = findSouthwestPoint(allMarks.orEmpty())
                        val northeastPoint = findNortheastPoint(allMarks.orEmpty())

                        val centerPointLatitude =
                            (southwestPoint.latitude + northeastPoint.latitude) / 2
                        val centerPointLongitude =
                            (southwestPoint.longitude + northeastPoint.longitude) / 2

                        val cameraUpdate =
                            CameraUpdateFactory.newCameraPosition(
                                CameraPosition(
                                    LatLng(
                                        centerPointLatitude,
                                        centerPointLongitude
                                    ),
                                    13f,
                                    0f,
                                    0f
                                )
                            )
                        delay(200)
                        cameraPosition.animate(
                            cameraUpdate,
                            durationMs = 500
                        )
                    }
                }
        }
    }
}

package com.locrz.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.ui.routes.Home
import com.locrz.nearby.ui.routes.Splash
import com.locrz.nearby.ui.routes.Welcome
import com.locrz.nearby.ui.screens.HomeScreen
import com.locrz.nearby.ui.screens.SplashScreen
import com.locrz.nearby.ui.screens.MarketDetailScreen
import com.locrz.nearby.ui.screens.WelcomeScreen
import com.locrz.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppProvider()
        }
    }
}

@Composable
fun AppProvider(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NearbyTheme {
        NavHost(
            navController = navController, startDestination = Splash
        ) {
            composable<Splash> {
                SplashScreen(onNavigateToWelcome = {
                    navController.navigate(Welcome) {
                        // reset stack
                        popUpTo(0)
                    }
                })
            }
            composable<Welcome> {
                WelcomeScreen(onNavigateToHome = {
                    navController.navigate(Home)
                })
            }
            composable<Home> {
                HomeScreen(openMarketDetails = { selectedMarket ->
                    navController.navigate(selectedMarket)
                })
            }
            composable<Market> { backStackEntry ->
                val selectedMarket = backStackEntry.toRoute<Market>()
                MarketDetailScreen(
                    market = selectedMarket,
                    goBack = { navController.popBackStack() })
            }
        }
    }
}
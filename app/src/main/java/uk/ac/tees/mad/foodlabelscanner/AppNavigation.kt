package uk.ac.tees.mad.foodlabelscanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onFinished = {
                navController.navigate("scan") { popUpTo("splash") { inclusive = true } }
            })
        }
        composable("scan") {
            ScanScreen(
                onLookup = { barcode -> navController.navigate("detail/$barcode") },
                onHistory = { navController.navigate("history") }
            )
        }
        composable("detail/{barcode}") { entry ->
            DetailScreen(
                barcode = entry.arguments?.getString("barcode") ?: "",
                onBack = { navController.popBackStack() }
            )
        }
        composable("history") {
            HistoryScreen(onBack = { navController.popBackStack() })
        }
    }
}
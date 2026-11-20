package com.example.p9.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.p9.view.DetailSiswaScreen
import com.example.p9.view.EditSiswaScreen
import com.example.p9.view.EntrySiswaScreen
import com.example.p9.view.HomeScreen
import com.example.p9.view.route.DestinasiDetailSIswa
import com.example.p9.view.route.DestinasiEditSiswa
import com.example.p9.view.route.DestinasiEntry
import com.example.p9.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { id ->
                    navController.navigate("${DestinasiDetailSIswa.route}/$id")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        composable(
            route = DestinasiDetailSIswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSIswa.ItemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEditSiswa.route}/$id")
                },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

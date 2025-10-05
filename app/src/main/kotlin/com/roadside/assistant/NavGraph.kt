package com.roadside.assistant

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.roadside.assistant.feature.create.CreateRequestScreen
import com.roadside.assistant.feature.detail.RequestDetailScreen
import com.roadside.assistant.feature.list.RequestListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            RequestListScreen(
                onOpen = { id -> navController.navigate("detail/$id") },
                onCreate = { navController.navigate("create") }
            )
        }
        composable("create") {
            CreateRequestScreen(onDone = { createdId ->
                navController.popBackStack()
                navController.navigate("detail/$createdId")
            })
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id").orEmpty()
            RequestDetailScreen(id = id, onBack = { navController.popBackStack() })
        }
    }
}

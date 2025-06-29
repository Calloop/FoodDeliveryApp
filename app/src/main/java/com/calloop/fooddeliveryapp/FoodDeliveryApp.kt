package com.calloop.fooddeliveryapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun FoodDeliveryApp(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                onRestaurantClick = { id ->
                    navController.navigate(
                        RestaurantDestination.routeWithArgs
                            .replace("{${RestaurantDestination.restaurantIdArg}}", id.toString())
                    )
                },
                onCategoryClick = { /* Handle category navigation */ }
            )
        }

        composable(
            route = RestaurantDestination.routeWithArgs,
            arguments = listOf(navArgument(RestaurantDestination.restaurantIdArg) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt(
                RestaurantDestination.restaurantIdArg
            ) ?: 0
            RestaurantDetailScreen(restaurantId = restaurantId)
        }

        // Add other destinations
    }
}
package com.calloop.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.calloop.home.presentation.screens.HomeScreen

object HomeDestination : FoodDeliveryAppNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(
    onRestaurantClick: (Int) -> Unit,
    onCategoryClick: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            onRestaurantClick = onRestaurantClick,
            onCategoryClick = onCategoryClick
        )
    }
    nestedGraphs()
}
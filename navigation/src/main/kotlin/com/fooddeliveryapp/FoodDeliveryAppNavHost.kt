interface FoodDeliveryAppNavHost {
    val route: String
    val destination: String
}

object HomeDestination : FoodDeliveryAppNavHost {
    override val route = "home_route"
    override val destination = "home_destination"
}

object RestaurantDestination : FoodDeliveryAppNavHost {
    override val route = "restaurant_route"
    override val destination = "restaurant_destination"
    const val restaurantIdArg = "restaurantId"
    val routeWithArgs = "$route/{$restaurantIdArg}"
}

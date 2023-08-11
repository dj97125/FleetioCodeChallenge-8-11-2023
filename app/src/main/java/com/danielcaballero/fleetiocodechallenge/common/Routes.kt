package com.danielcaballero.fleetiocodechallenge.common

sealed class Routes(val route: String) {
    object VehiclesList : Routes("vehicles_list_view")
    object VehiclesDetails : Routes("vehicles_details_view")
}
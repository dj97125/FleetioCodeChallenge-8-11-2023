package com.danielcaballero.fleetiocodechallenge.ui

import VehicleInformationList
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danielcaballero.fleetiocodechallenge.common.Routes
import com.danielcaballero.fleetiocodechallenge.ui.composables.VehicleDetails
import com.danielcaballero.fleetiocodechallenge.view_model.VehiclesInformationViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<VehiclesInformationViewModel>()
    NavHost(
        navController = navController,
        startDestination = Routes.VehiclesList.route
    ) {

        composable(route = Routes.VehiclesList.route) {
            VehicleInformationList(
                viewModel = viewModel,
                onNavigate = { navController.navigate(Routes.VehiclesDetails.route) })

        }
        composable(
            route = Routes.VehiclesDetails.route,
        ) {
            VehicleDetails(viewModel = viewModel)
        }


    }
}
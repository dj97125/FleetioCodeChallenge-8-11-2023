package com.danielcaballero.fleetiocodechallenge.model.network

import com.danielcaballero.fleetiocodechallenge.common.END_URL
import com.danielcaballero.fleetiocodechallenge.model.network.fleet_response.FleetResponse
import retrofit2.Response
import retrofit2.http.GET


interface NetworkFleet {

    @GET(END_URL)
    suspend fun getAllVehicles(): Response<FleetResponse>

}

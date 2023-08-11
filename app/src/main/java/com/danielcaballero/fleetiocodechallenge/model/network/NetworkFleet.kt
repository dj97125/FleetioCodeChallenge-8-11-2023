package com.danielcaballero.fleetiocodechallenge.model.network

import com.danielcaballero.fleetiocodechallenge.common.ACCOUNT_TOKEN
import com.danielcaballero.fleetiocodechallenge.common.END_URL
import com.danielcaballero.fleetiocodechallenge.common.TOKEN
import com.danielcaballero.fleetiocodechallenge.model.network.fleet_response.FleetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface NetworkFleet {
    @Headers(
        "Accept: application/json",
        "Authorization: $TOKEN",
        "Account-Token: $ACCOUNT_TOKEN"
    )
    @GET(END_URL)
    suspend fun getAllVehicles(): Response<FleetResponse>

}

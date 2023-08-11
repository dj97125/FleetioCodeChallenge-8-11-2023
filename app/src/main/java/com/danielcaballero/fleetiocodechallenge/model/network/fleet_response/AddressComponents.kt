package com.danielcaballero.fleetiocodechallenge.model.network.fleet_response

data class AddressComponents(
    val city: String?,
    val country: String?,
    val country_short: String?,
    val postal_code: String?,
    val region: String?,
    val region_short: String?,
    val street: String?,
    val street_number: String?
)
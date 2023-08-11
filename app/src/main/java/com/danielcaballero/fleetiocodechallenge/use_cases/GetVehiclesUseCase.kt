package com.danielcaballero.fleetiocodechallenge.use_cases

import com.danielcaballero.fleetiocodechallenge.domain.Repository
import javax.inject.Inject

class GetVehiclesUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke() = repository.getVehiclesDomainLayer()
}
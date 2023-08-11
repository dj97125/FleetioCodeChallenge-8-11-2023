package com.danielcaballero.fleetiocodechallenge.domain

import com.danielcaballero.fleetiocodechallenge.common.StateAction
import com.danielcaballero.fleetiocodechallenge.model.network.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface Repository {
    fun getVehiclesDomainLayer(): Flow<StateAction>
}

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {


    override fun getVehiclesDomainLayer(): Flow<StateAction> = flow {

        localDataSource.getVehiclesDataSource().collect() { state ->
            when (state) {
                is StateAction.Succes<*> -> {
                    val retrievedCountries = state.respoonse
                    val code = state.code

                    emit(StateAction.Succes(retrievedCountries, code))

                }

                is StateAction.Errror -> {
                    emit(StateAction.Errror(state.exception))
                }

                else -> {}
            }

        }

    }
}



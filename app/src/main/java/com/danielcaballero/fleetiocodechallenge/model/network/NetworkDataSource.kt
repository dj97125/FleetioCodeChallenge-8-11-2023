package com.danielcaballero.fleetiocodechallenge.model.network

import com.danielcaballero.fleetiocodechallenge.common.Code400Exception
import com.danielcaballero.fleetiocodechallenge.common.NullBody
import com.danielcaballero.fleetiocodechallenge.common.StateAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface LocalDataSource {
    fun getVehiclesDataSource(): Flow<StateAction>
}

class LocalDataSourceImpl @Inject constructor(
    private val service: NetworkFleet

) : LocalDataSource {
    override fun getVehiclesDataSource(): Flow<StateAction> = flow {
        val networkService = service.getAllVehicles()

        networkService.body()?.let { response ->
            emit(StateAction.Succes(response, networkService.code().toString()))
        } ?: run {
            emit(StateAction.Errror(NullBody()))
        }

        if (!networkService.isSuccessful) {
            if (networkService.code().toString().startsWith("4")) {
                emit(StateAction.Errror(Code400Exception()))
            }
        }

    }
}
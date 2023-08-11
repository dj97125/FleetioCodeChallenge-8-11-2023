package com.danielcaballero.fleetiocodechallenge.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcaballero.fleetiocodechallenge.common.StateAction
import com.danielcaballero.fleetiocodechallenge.model.network.fleet_response.FleetResponseItem
import com.danielcaballero.fleetiocodechallenge.use_cases.GetVehiclesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject


@HiltViewModel
class VehiclesInformationViewModel @Inject constructor(
    private val getVehiclesUseCase: GetVehiclesUseCase,
    private val corroutineExceptionHandler: CoroutineExceptionHandler
) : ViewModel() {

    private val _vehiclesResponse: MutableStateFlow<StateAction?> =
        MutableStateFlow(null)
    val vehiclesResponse: StateFlow<StateAction?>
        get() = _vehiclesResponse.asStateFlow()

    private val eventChannel = Channel<StateAction>()
    val eventFlow = eventChannel.receiveAsFlow()

    var vehicleDetails by mutableStateOf<FleetResponseItem?>(null)
        private set

    init {
        getVehicles()
    }

    fun addVehicleDetails(details: FleetResponseItem) {
        vehicleDetails = details
    }

    fun getVehicles() {
        _vehiclesResponse.value = StateAction.Loading
        viewModelScope.launch(corroutineExceptionHandler) {
            supervisorScope {
                launch {
                    delay(3000L)///// bad pratice this line, just created with the purpose for enjoying the splash screen
                    getVehiclesUseCase().collect() {
                        _vehiclesResponse.value = it
                        eventChannel.send(it)/// this is for handling componse side effects at the moment to rotate the screen
                    }
                }
            }
        }
    }

}
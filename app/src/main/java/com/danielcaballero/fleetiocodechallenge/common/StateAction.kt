package com.danielcaballero.fleetiocodechallenge.common

sealed interface StateAction {
    class Succes<T>(val respoonse: T, val code: String) : StateAction
    class Errror(val exception: Exception) : StateAction
    object Loading : StateAction
}



package com.danielcaballero.fleetiocodechallenge.common

class Code400Exception(
    message: String = "Invalid Parameters"
) : Exception(message)

class NullBody(
    message: String = "Null Body"
) : Exception(message)


class NoInternetConnection(
    message: String = "No Internet Conection"
) : Exception(message)
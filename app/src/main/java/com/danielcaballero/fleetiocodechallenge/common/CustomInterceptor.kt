package com.danielcaballero.fleetiocodechallenge.common

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", "Token token=$TOKEN")
            .addHeader("Account-Token", ACCOUNT_TOKEN)
            .build()
        return chain.proceed(request)

    }
}
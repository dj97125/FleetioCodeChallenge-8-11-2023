package com.danielcaballero.fleetiocodechallenge.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danielcaballero.fleetiocodechallenge.ui.theme.FleetioCodeChallengeTheme

@Composable
fun FleetioAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,

    ) {

    FleetioCodeChallengeTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Navigation()


        }
    }
}
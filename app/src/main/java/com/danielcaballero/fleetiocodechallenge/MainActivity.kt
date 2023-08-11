package com.danielcaballero.fleetiocodechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.danielcaballero.fleetiocodechallenge.ui.FleetioAppTheme
import com.danielcaballero.fleetiocodechallenge.ui.theme.FleetioCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FleetioCodeChallengeTheme {
                FleetioAppTheme()
            }
        }
    }
}

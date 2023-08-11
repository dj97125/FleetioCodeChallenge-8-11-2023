package com.danielcaballero.fleetiocodechallenge.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.danielcaballero.composetest.ui.util.AutoResizedText
import com.danielcaballero.fleetiocodechallenge.model.network.fleet_response.FleetResponseItem
import com.danielcaballero.fleetiocodechallenge.ui.theme.Typography
import com.danielcaballero.fleetiocodechallenge.ui.util.DETAILS_LICENSE_PLATE
import com.danielcaballero.fleetiocodechallenge.ui.util.DETAILS_VIN
import com.danielcaballero.fleetiocodechallenge.ui.util.VEHICLE_DETAILS_LICENSE_PLATE_LABEL
import com.danielcaballero.fleetiocodechallenge.ui.util.VEHICLE_DETAILS_VIN_LABEL
import com.danielcaballero.fleetiocodechallenge.view_model.VehiclesInformationViewModel

@Composable
fun VehicleDetails(viewModel: VehiclesInformationViewModel) {
    val details = viewModel.vehicleDetails
    VehicleDetailBody(vehicle = details)

}

@Composable
fun VehicleDetailBody(
    vehicle: FleetResponseItem?,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(2.dp, Color.LightGray),
            modifier = modifier
                .wrapContentHeight()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    AutoResizedText(
                        text = VEHICLE_DETAILS_VIN_LABEL,
                        modifier = modifier
                            .weight(.5f)
                            .testTag(DETAILS_VIN),
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    AutoResizedText(
                        text = vehicle?.vin ?: "N/A",
                        modifier = modifier
                            .weight(.5f)
                            .testTag(DETAILS_VIN),
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {
                    AutoResizedText(
                        text = VEHICLE_DETAILS_LICENSE_PLATE_LABEL,
                        modifier = modifier
                            .weight(.5f)
                            .testTag(DETAILS_LICENSE_PLATE),
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    AutoResizedText(
                        text = vehicle?.license_plate ?: "N/A",
                        modifier = modifier
                            .weight(.5f)
                            .testTag(DETAILS_LICENSE_PLATE),
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

            }

        }
    }

}

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danielcaballero.composetest.ui.util.AlertError
import com.danielcaballero.composetest.ui.util.AlertWelcome
import com.danielcaballero.composetest.ui.util.AutoResizedText
import com.danielcaballero.composetest.ui.util.LoadingAnimation
import com.danielcaballero.fleetiocodechallenge.common.StateAction
import com.danielcaballero.fleetiocodechallenge.model.network.fleet_response.FleetResponseItem
import com.danielcaballero.fleetiocodechallenge.ui.theme.Typography
import com.danielcaballero.fleetiocodechallenge.ui.util.LIST_VEHICLE_MAKE
import com.danielcaballero.fleetiocodechallenge.ui.util.LIST_VEHICLE_NAME
import com.danielcaballero.fleetiocodechallenge.ui.util.VEHICLE_MAKE_LABEL
import com.danielcaballero.fleetiocodechallenge.ui.util.VEHICLE_NAME_LABEL
import com.danielcaballero.fleetiocodechallenge.view_model.VehiclesInformationViewModel

@Composable
fun VehicleInformationList(viewModel: VehiclesInformationViewModel, onNavigate: () -> Unit) {

    val vehicleInfo by viewModel.vehiclesResponse.collectAsStateWithLifecycle()
    val eventFlow by viewModel.eventFlow.collectAsState(null)



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        when (eventFlow) {
            is StateAction.Succes<*> -> AlertWelcome(
                title = "SUCCESS",
                body = "Welcome to your fleet list"
            )

            is StateAction.Errror -> AlertError(
                onRetry = { viewModel.getVehicles() },
                title = "ERROR",
                body = "Something went wrong"
            )

            else -> {}
        }

        when (val state = vehicleInfo) {
            is StateAction.Succes<*> -> {
                val retrievedElements = state.respoonse as List<FleetResponseItem>
                ListOfElements(vehicle = retrievedElements,
                    onNavigate = {
                        viewModel.addVehicleDetails(it)
                    },
                    onNextScreen = { onNavigate() })

            }

            StateAction.Loading -> LoadingAnimation()
            else -> {}
        }


    }

}

@Composable
fun ListOfElements(
    vehicle: List<FleetResponseItem>,
    modifier: Modifier = Modifier,
    onNavigate: (FleetResponseItem) -> Unit,
    onNextScreen: () -> Unit
) {

    LazyColumn(modifier = modifier.fillMaxSize()) {
        vehicle.forEach { vehicle ->
            item {
                VehicleElement(
                    vehicle,
                    modifier = modifier,
                    onNavigate = { onNavigate(vehicle) },
                    onNextScreen = { onNextScreen() })
            }
        }
    }


}

@Composable
fun VehicleElement(
    vehicle: FleetResponseItem,
    modifier: Modifier = Modifier,
    onNavigate: (FleetResponseItem) -> Unit,
    onNextScreen: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(3.dp, Color.Black),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onNavigate(vehicle)
                onNextScreen()
            }
    ) {
        Column(
            modifier = modifier.weight(.5f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = modifier.size(10.dp))
                AutoResizedText(
                    text = VEHICLE_NAME_LABEL,
                    modifier = modifier
                        .weight(.5f)
                        .testTag(VEHICLE_NAME_LABEL),
                    textAlign = TextAlign.Start,
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                AutoResizedText(
                    text = vehicle.name ?: "N/A",
                    modifier = modifier
                        .weight(.5f)
                        .testTag(LIST_VEHICLE_NAME),
                    textAlign = TextAlign.Justify,
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Column(
            modifier = modifier.weight(.5f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = modifier.size(10.dp))
                AutoResizedText(
                    text = VEHICLE_MAKE_LABEL,
                    modifier = modifier
                        .weight(.5f)
                        .testTag(VEHICLE_MAKE_LABEL),
                    textAlign = TextAlign.Start,
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                AutoResizedText(
                    text = vehicle.make ?: "N/A",
                    modifier = modifier
                        .weight(.5f)
                        .testTag(LIST_VEHICLE_MAKE),
                    textAlign = TextAlign.Justify,
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }

}
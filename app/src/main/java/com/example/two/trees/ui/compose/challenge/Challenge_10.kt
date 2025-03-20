package com.example.two.trees.ui.compose.challenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.two.trees.R
import com.example.two.trees.ui.compose.TwoTreesAppBar
import com.example.two.trees.ui.theme.AppTheme
import com.example.two.trees.ui.theme.accent

@Composable
fun Challenge10App() {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TwoTreesAppBar(appName = R.string.challenge10_app_name)
            }
        ) { innerPadding ->
            val viewModel = viewModel<Challenge10ViewModel>()
            val quantity by viewModel.quantity.collectAsState()
            val totalAmount by viewModel.totalAmount.collectAsState()
            // TODO: create missing variables

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    text = "Can of olives",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge
                )

                QuantityButtons(
                    increaseQuantity = {
                        viewModel.increaseQuantity()
                    },
                    decreaseQuantity = {
                        viewModel.decreaseQuantity()
                    }
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    text = "Total cans: $quantity",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    text = "Total amount: $$totalAmount.00",
                    style = MaterialTheme.typography.titleLarge
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    onClick = {
                        viewModel.checkout()
                    }
                ) {
                    Text(
                        text = "Checkout",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Composable
private fun QuantityButtons(
    increaseQuantity: () -> Unit,
    decreaseQuantity: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(24.dp),
            imageVector = ImageVector.vectorResource(
                R.drawable.olive_branch_vector
            ),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            FilledIconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = accent
                ),
                onClick = increaseQuantity
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    tint = Color.White,
                    contentDescription = "increase quantity"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            FilledIconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = accent
                ),
                onClick = decreaseQuantity
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    tint = Color.White,
                    contentDescription = "decrease quantity"
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun Challenge10AppPreview() {
    AppTheme {
        Challenge10App()
    }
}

package com.example.two.trees.ui.compose

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.two.trees.MainViewModel

@Composable
fun TwoTreesBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        // TODO: create a variable that has the current quantity
        val quantity by viewModel.quantity.collectAsStateWithLifecycle()

        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    // TODO: update the icon to be a badged icon
                    // TODO: only display badge when quantity not zero
                    // TODO: and only on the shop screen
                    BadgedBox(
                        badge = {
                            if (quantity > 0 &&
                                currentDestination?.hierarchy?.any {
                                    it.route == Screen.Shop.route
                                } == true &&
                                screen.icon == Screen.Shop.icon
                            ) {
                                Badge(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                ) {
                                    Text("$quantity")
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = label
                        )
                    }
                },
                label = {
                    Text(label)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

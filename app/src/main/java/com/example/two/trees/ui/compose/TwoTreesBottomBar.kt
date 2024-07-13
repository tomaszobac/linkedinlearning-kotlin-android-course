package com.example.two.trees.ui.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    // TODO: update the icon to be a badged icon
                    // TODO: only display badge when quantity not zero
                    // TODO: and only on the shop screen
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = label
                    )
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

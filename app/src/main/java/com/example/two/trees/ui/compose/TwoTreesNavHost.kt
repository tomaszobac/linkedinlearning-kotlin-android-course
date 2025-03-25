package com.example.two.trees.ui.compose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.two.trees.MainViewModel
import com.example.two.trees.data.Product

private const val TAG = "TwoTreesNavHost"

@Composable
fun TwoTreesNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val products by viewModel.products.collectAsStateWithLifecycle()
    val selectedProduct by viewModel.selectedProduct.collectAsStateWithLifecycle()
    // TODO: collect state changes to isSubscribed variable
    val isSubscribed by viewModel.subscriptionStatus.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                takeTourClick = {
                    navController.navigate(Screen.Tours.route)
                }
            )
        }
        composable(route = Screen.Tours.route) {
            ToursScreen(
                isSubscribed = isSubscribed,
                onSubscribeClick = { _: String ->
                    Log.i(TAG, "Subscribe to newsletter")
                    viewModel.onSubscribeClick()
                }
            )
        }
        composable(route = Screen.Shop.route) {
            ShopScreen(
                products = products,
                onProductClick = { product: Product ->
                    Log.i(TAG, "The selected product: $product")
                    viewModel.selectProduct(product)
                    navController.navigate(Screen.Product.route)
                }
            )
        }
        composable(route = Screen.Product.route) {
            selectedProduct?.let {
                ProductScreen(
                    product = it,
                    incrementQuantityClick = { viewModel.incrementQuantity() },
                    decrementQuantityClick = { viewModel.decrementQuantity() },
                )
            }
        }
    }
}

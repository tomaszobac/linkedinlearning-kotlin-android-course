package com.example.two.trees.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.two.trees.R
import com.example.two.trees.data.Product
import com.example.two.trees.ui.theme.AppTheme
import java.text.NumberFormat

@Composable
fun ShopScreen(
    products: List<Product>,
    onProductClick: (product: Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ShopLabel()
        }
        item {
            FreeShipping()
        }
        items(products) {
            ProductItem(
                product = it,
                onProductClick
            )
        }
    }
}

@Composable
private fun ShopLabel(modifier: Modifier = Modifier) {
    Text(
        stringResource(R.string.shop_label).uppercase(),
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FreeShipping(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Text(
            stringResource(id = R.string.free_shipping_label).uppercase(),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 4.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProductItem(
    product: Product,
    onProductClick: (product: Product) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        onClick = { onProductClick(product) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageFile)
                    .placeholder(R.drawable.logo)
                    .crossfade(true)
                    .build(),
                contentDescription = null
            )
            Text(
                product.name.uppercase(),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            Text(
                stringResource(id = R.string.product_size_label, product.size),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Text(
                NumberFormat.getCurrencyInstance().format(product.price),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AppTheme {
        ProductItem(
            product = Product(
                name = "Avis",
                imageFile = "nisl",
                description = "mei",
                size = 4363,
                price = 6.7
            ),
            onProductClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    val products = listOf(
        Product(
            name = "Carla Montoya",
            imageFile = "fabellas",
            description = "varius",
            size = 7963,
            price = 14.15
        ),
        Product(
            name = "Julia McCormick",
            imageFile = "tristique",
            description = "alterum",
            size = 7143,
            price = 18.19
        )
    )
    AppTheme {
        ShopScreen(
            products = products,
            onProductClick = {}
        )
    }
}

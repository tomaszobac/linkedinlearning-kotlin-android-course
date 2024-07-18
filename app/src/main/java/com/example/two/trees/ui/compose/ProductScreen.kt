package com.example.two.trees.ui.compose

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.two.trees.R
import com.example.two.trees.data.Product
import com.example.two.trees.ui.theme.AppTheme
import java.text.NumberFormat

@Composable
fun ProductScreen(
    product: Product,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    incrementQuantityClick: () -> Unit,
    decrementQuantityClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(scrollState)
            .padding(vertical = 16.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.imageFile)
                .placeholder(R.drawable.logo)
                .crossfade(true)
                .build(),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null
        )
        Text(
            product.name.uppercase(),
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            product.description,
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            fontSize = 18f.sp,
            lineHeight = 28.sp
        )
        Text(
            stringResource(id = R.string.product_size_label, product.size),
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            NumberFormat.getCurrencyInstance().format(product.price),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
        )
        Button(
            onClick = incrementQuantityClick,
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            Text(stringResource(id = R.string.add_to_cart_label))
        }
        OutlinedButton(
            onClick = decrementQuantityClick,
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(stringResource(id = R.string.remove_from_cart_label))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    AppTheme {
        ProductScreen(
            Product(
                name = "Chavez",
                imageFile = "chili_bottle",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                size = 22,
                price = 20.3
            ),
            incrementQuantityClick = {},
            decrementQuantityClick = {}
        )
    }
}

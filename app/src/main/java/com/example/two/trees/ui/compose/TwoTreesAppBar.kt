package com.example.two.trees.ui.compose

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.two.trees.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoTreesAppBar(
    modifier: Modifier = Modifier,
    @StringRes appName: Int
) {
    TopAppBar(
        title = {
            Text(stringResource(appName))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null
            )
        }
    )
}

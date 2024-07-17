package com.example.random.pics.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.two.trees.ui.theme.onPrimaryContainerDark
import com.example.two.trees.ui.theme.onPrimaryContainerLight
import com.example.two.trees.ui.theme.onPrimaryDark
import com.example.two.trees.ui.theme.onPrimaryLight
import com.example.two.trees.ui.theme.onSecondaryContainerDark
import com.example.two.trees.ui.theme.onSecondaryContainerLight
import com.example.two.trees.ui.theme.onSecondaryDark
import com.example.two.trees.ui.theme.onSecondaryLight
import com.example.two.trees.ui.theme.onTertiaryContainerDark
import com.example.two.trees.ui.theme.onTertiaryContainerLight
import com.example.two.trees.ui.theme.onTertiaryDark
import com.example.two.trees.ui.theme.onTertiaryLight
import com.example.two.trees.ui.theme.primaryContainerDark
import com.example.two.trees.ui.theme.primaryContainerLight
import com.example.two.trees.ui.theme.secondaryContainerDark
import com.example.two.trees.ui.theme.secondaryContainerLight
import com.example.two.trees.ui.theme.secondaryDark
import com.example.two.trees.ui.theme.secondaryLight
import com.example.two.trees.ui.theme.tertiaryContainerDark
import com.example.two.trees.ui.theme.tertiaryContainerLight
import com.example.two.trees.ui.theme.tertiaryDark
import com.example.two.trees.ui.theme.tertiaryLight

private val picLightScheme = lightColorScheme(
    primary = Color(0xFF9C27B0),
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight
)

private val picDarkScheme = darkColorScheme(
    primary = Color(0xFF9C27B0),
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark
)

@Composable
fun RandomPicAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> picDarkScheme
      else -> picLightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}

package com.toure.compose_design.ui.screens.fitness_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.toure.compose_design.ui.theme.Typography

internal val colorScheme = lightColorScheme(
    background = Color(0xFF041643),
    onBackground = Color.White,
    primary = Color(0xFF1352F1),
    onPrimary = Color.White,
    secondary = Color(0xFF485aa0),
    onSecondary = Color(0xFFffffff),
    surface = Color(0xFFF7F6FA),
    onSurface = Color(0xFF192126),
    secondaryContainer = Color(0xFFEAECFF),
    onSecondaryContainer = Color(0xFF192126),
    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    */
)

@Preview
@Composable
private fun LoginScreenPreview(
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
    ) {
        LoginScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview(
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
    ) {
        RegisterScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
    ) {
        HomeScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
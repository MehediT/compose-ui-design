package com.toure.compose_design.ui.screens.sleekFitnessApp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.compose_design.ui.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

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

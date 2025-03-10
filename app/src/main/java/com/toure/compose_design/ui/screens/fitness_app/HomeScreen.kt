package com.toure.compose_design.ui.screens.fitness_app

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toure.compose_design.R
import com.toure.compose_design.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                ),
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurface,
                ),
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Good Morning 🔥",
                            fontSize = 14.sp
                        )
                        Text(
                            "Alex Placeholder",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ChronometerWithControls(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight()
                )
                Spacer(Modifier.size(4.dp))
                CurrentTrainingProgress(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                )
            }
            Column (

            ){
                Text(
                    text = "Today's workout",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                )
                LazyColumn {
                }
            }
        }

    }
}

@Composable
fun CurrentTrainingProgress(modifier: Modifier = Modifier) {
    Card (
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.secondary,
        ),
        modifier = modifier,
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Training Progress",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            CircularProgressIndicator(
                progress = 0.8f,
                strokeWidth = 10.dp,
                progressColor = MaterialTheme.colorScheme.secondary,
                progressBackgroundColor = MaterialTheme.colorScheme.onSecondary,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Composable
fun CircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 20.dp,
    progressColor: Color = Color.Red,
    progressBackgroundColor: Color = Color.White,
    textColor: Color = Color.Black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sweepAngle = progress * 360f

            drawArc(
                color = progressBackgroundColor,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )

            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = "${(progress * 100).toInt()}%",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Composable
fun ChronometerWithControls(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.onSecondary,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.secondary,
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your next workout",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "00:00",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.size(16.dp))
                Row {
                    Box (
                        modifier = Modifier.weight(1f)
                    ){
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.pause_circle_icon),
                                contentDescription = null,
                                tint = Color(0xFFFABF16),
                                modifier = Modifier.matchParentSize(),
                            )
                        }
                    }
                    Box (
                        modifier = Modifier.weight(1f)
                    ){
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.stop_circle_icon),
                                contentDescription = null,
                                tint = Color(0xFFF53950),
                                modifier = Modifier.matchParentSize(),
                            )
                        }
                    }
                }
            }
        }
    }
}

fun formatTime(seconds: Long): String {
    val minutes = seconds / 60
    val sec = seconds % 60
    return String.format("%02d:%02d", minutes, sec)
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

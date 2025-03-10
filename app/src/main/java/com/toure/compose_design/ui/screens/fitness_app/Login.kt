package com.toure.compose_design.ui.screens.fitness_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toure.compose_design.R
import com.toure.compose_design.ui.theme.Typography


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            LoginHeader()
        },
    ) { innerPadding ->
        AuthenticationScreen(innerPadding)
    }
}

@Composable
private fun AuthenticationScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(32.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        AuthenticationHeader()
        AuthenticationForm(Modifier.weight(1f))
    }
}

@Composable
private fun AuthenticationForm(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(value = stringResource(R.string.email_example),
                    onValueChange = { },
                    label = { Text(stringResource(R.string.email)) })
                OutlinedTextField(value = stringResource(R.string.password_placeholder),
                    onValueChange = { },
                    label = { Text(stringResource(R.string.password)) })
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.login))
                }
                TextButton(
                    onClick = { /*TODO*/ },
                ) {
                    Text(stringResource(R.string.do_you_need))
                    Text(stringResource(R.string.help), fontWeight = FontWeight.Bold)
                }
            }
        }
        Text(
            text = stringResource(R.string.template_made_by_mehedi_toure),
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
private fun AuthenticationHeader() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row {
            Text(
                text = stringResource(R.string.login_into_your_account),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(2f)
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
        }
        Text(
            text = stringResource(R.string.let_s_build_our_health), fontSize = 16.sp, color = Color.Gray
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun LoginHeader() {
    LargeTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,

            ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.fitbit_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    stringResource(R.string.fitness_app),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },
        actions = {
            TextButton(
                onClick = { /* do something */ },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(stringResource(R.string.sign_in))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                    )
                }
            }
        },
    )
}

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
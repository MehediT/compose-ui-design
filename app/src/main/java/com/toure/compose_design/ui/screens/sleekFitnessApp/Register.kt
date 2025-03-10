package com.toure.compose_design.ui.screens.sleekFitnessApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toure.compose_design.R
import com.toure.compose_design.ui.theme.Typography


@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            RegisterHeader()
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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        AuthenticationHeader(Modifier.padding(horizontal = 16.dp))
        AuthenticationForm(Modifier.weight(1f))
    }
}

@Composable
private fun AuthenticationForm(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GoogleSignInButton()
            RegistrationForm()
        }
    }
}

@Composable
private fun GoogleSignInButton() {
    OutlinedButton(
        onClick = {}, modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.google_icons),
            tint = Color.Unspecified,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(stringResource(R.string.continue_with_google))
    }
    Box(
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(thickness = 2.dp)
        Text(
            "OR",
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                .padding(8.dp)
        )
    }
}

@Composable
private fun RegistrationForm() {
    Column {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = stringResource(R.string.example),
                    onValueChange = { },
                    label = { Text("FirstName") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = stringResource(R.string.example),
                    onValueChange = { },
                    label = { Text("LastName") },
                    modifier = Modifier.weight(1f)
                )
            }
            OutlinedTextField(
                value = stringResource(R.string.email_example),
                onValueChange = { },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.langue),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .weight(1f)
                        .size(48.dp)
                )
                OutlinedTextField(
                    value = stringResource(R.string.exemple_phone),
                    onValueChange = { },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text(stringResource(R.string.phone_number)) },
                    modifier = Modifier.weight(5f)
                )
            }
            OutlinedTextField(
                value = stringResource(R.string.password_placeholder),
                onValueChange = { },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(stringResource(R.string.password)) },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.register))
            }
        }
        TextButton(
            onClick = { /*TODO*/ },
        ) {
            Text(stringResource(R.string.do_you_need))
            Text(stringResource(R.string.help), fontWeight = FontWeight.Bold)
        }
    }

}

@Composable
private fun AuthenticationHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.welcome_create_your_account),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
        )
        Text(
            text = stringResource(R.string.greeting_register), fontSize = 16.sp, color = Color.Gray
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun RegisterHeader() {
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
                    imageVector = ImageVector.vectorResource(id = R.drawable.fitbit_24dp),
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
                    Text(stringResource(R.string.login))
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
        RegisterScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}
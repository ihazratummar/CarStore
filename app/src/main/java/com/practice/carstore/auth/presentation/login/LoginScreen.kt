package com.practice.carstore.auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.practice.carstore.R
import com.practice.carstore.auth.AuthState
import com.practice.carstore.auth.navigation.Login
import com.practice.carstore.auth.presentation.component.CustomTextField
import com.practice.carstore.core.navigation.ContentDestinations
import com.practice.carstore.core.navigation.HomeScreen
import com.practice.carstore.navigation.ContentNav

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {},
    state: LoginState,
    event: (LoginEvent) -> Unit,
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Icon(
                painter = painterResource(id = R.drawable.carstorelogo),
                contentDescription = "Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Login",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Welcome to CarStore")
            Spacer(modifier = Modifier.height(30.dp))
            CustomTextField(
                value = state.userName,
                onValueChange = { event(LoginEvent.SetUserName(it)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        tint = Color.Unspecified
                    )
                },
                placeholder = { Text(text = "Username", color = Color(0xFFA8AFB9)) },
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = state.password,
                onValueChange = { event(LoginEvent.SetPassword(it)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = "Profile",
                        tint = Color(0xFFA8AFB9)
                    )
                },
                placeholder = { Text(text = "Password", color = Color(0xFFA8AFB9)) },
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password?")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0xFF000000),
                        ambientColor = Color(0xFF000000),
                        shape = RoundedCornerShape(14.dp)
                    )
                    .height(64.dp),
                onClick = {
                    event(LoginEvent.Login)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account?", color = Color(0xFFA8AFB9))
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "Sign Up", color = Color(0xFFFF5C00),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        onSignUpClick.invoke()
                    }
                )
            }
        }
    }
}


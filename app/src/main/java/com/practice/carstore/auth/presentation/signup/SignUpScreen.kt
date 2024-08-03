package com.practice.carstore.auth.presentation.signup

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
import com.practice.carstore.auth.navigation.SignUp
import com.practice.carstore.auth.presentation.component.CustomTextField
import com.practice.carstore.core.navigation.ContentDestinations
import com.practice.carstore.core.navigation.HomeScreen

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit = {},
    state: SignUpState,
    event: (SignUpEvent) -> Unit,
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
            Spacer(modifier = Modifier.height(30.dp))
            Icon(
                painter = painterResource(id = R.drawable.carstorelogo),
                contentDescription = "Logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Find your dream car!")
            Spacer(modifier = Modifier.height(25.dp))
            CustomTextField(
                value = state.fullName,
                onValueChange = { event(SignUpEvent.SetFullName(it)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        tint = Color.Unspecified
                    )
                },
                placeholder = { Text(text = "Full name", color = Color(0xFFA8AFB9)) },
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = state.email,
                onValueChange = { event(SignUpEvent.SeEmail(it)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "Email",
                        tint = Color(0xFFA8AFB9)
                    )
                },
                placeholder = { Text(text = "Email", color = Color(0xFFA8AFB9)) },
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = state.phoneNumber,
                onValueChange = { event(SignUpEvent.SetMobile(it))},
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "Phone Number",
                        tint = Color(0xFFA8AFB9)
                    )
                },
                placeholder = { Text(text = "Phone number", color = Color(0xFFA8AFB9)) },
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(
                value = state.password,
                onValueChange = { event(SignUpEvent.Password(it)) },
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
            Spacer(modifier = Modifier.height(40.dp))
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
                    event(SignUpEvent.SignUp)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF5C00),
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color(0xFF523B2D)
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = "Sign Up",
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
                Text(text = "Already have an account?", color = Color(0xFFA8AFB9))
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "Sign In", color = Color(0xFFFF5C00),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        onSignInClick.invoke()
                    }
                )
            }
        }
    }
}


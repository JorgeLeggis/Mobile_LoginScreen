package com.example.loginscreen

import androidx.compose.material3.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController


@Composable
fun LoginScreenVisuals(navController: NavController, innerPadding: PaddingValues, modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .background(color = Color.White)
            .fillMaxSize()
    )
    {
        loginBackButton(navController = navController, modifier = Modifier)
        loginTitle(modifier = Modifier)
        loginTextFields(modifier = Modifier)
        loginButtons(navController = navController, modifier = Modifier)
    }
}

@Composable
fun loginBackButton(navController: NavController, modifier: Modifier = Modifier)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp, horizontal = 20.dp)
    )
    {
        Button(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor =  Color.Gray,
                    disabledContainerColor = Color.White
            ),
            onClick = {
                navController.navigate(route = "welcome")
            })
        {
            Text(
                "←",
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun loginTitle(modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(
                start = 50.dp,
                top = 80.dp,
                end = 50.dp,
                bottom = 50.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text = stringResource(R.string.Login_title),
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Composable
fun loginTextFields(modifier: Modifier = Modifier)
{
    var userText by remember { mutableStateOf("") }
    var passText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 40.dp)
    )
    {
        TextField(
            value = userText,
            onValueChange = { newText -> userText = newText },
            label = { Text("Usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .border(
                    width = 3.dp,
                    color = Color(82, 78, 172),
                    shape = RoundedCornerShape(15.dp)),
            singleLine = true
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(40.dp)
    )
    {
        TextField(
            value = passText,
            onValueChange = { newText -> userText = newText },
            label = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .border(
                    width = 3.dp,
                    color = Color(82, 78, 172),
                    shape = RoundedCornerShape(15.dp)),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun loginButtons(navController: NavController, modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(40.dp)
    )
    {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color(82,78,172)),
            onClick = {
                navController.navigate(route = "")
            })
        {
            Text("Log In")
        }
    }
}
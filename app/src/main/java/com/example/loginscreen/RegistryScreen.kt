package com.example.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegistryScreenVisuals(navController: NavController, innerPadding: PaddingValues,modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
    {
        registryBackButton(navController = navController, modifier = Modifier)
        registryTitle(modifier = Modifier)
        registryTextFields(modifier = Modifier)
        registryButtons(modifier = Modifier)
    }
}

@Composable
fun registryBackButton(navController: NavController, modifier: Modifier = Modifier)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(/*vertical = 40.dp, horizontal = 20.dp*/
                start = 20.dp,
                top = 40.dp,
                end = 20.dp,
                bottom = 0.dp)
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
            onClick = {})
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
fun registryTitle(modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(
                start = 50.dp,
                top = 60.dp,
                end = 50.dp,
                bottom = 50.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            stringResource(R.string.Registry_title),
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif
        )
    }
}

@Composable
fun registryTextFields(modifier: Modifier = Modifier)
{
    var userText by remember { mutableStateOf("") }

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
            label = { Text("Nombre de usuario") },
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
            .padding(
                start = 40.dp,
                top = 40.dp,
                end = 40.dp,
                bottom = 0.dp)
    )
    {
        TextField(
            value = userText,
            onValueChange = { newText -> userText = newText },
            label = { Text("Correo electrónico") },
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
            .padding(
                start = 40.dp,
                top = 40.dp,
                end = 40.dp,
                bottom = 0.dp)
    )
    {
        TextField(
            value = userText,
            onValueChange = { newText -> userText = newText },
            label = { Text("Contraseña") },
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
            value = userText,
            onValueChange = { newText -> userText = newText },
            label = { Text("Confirmar contraseña") },
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
}

@Composable
fun registryButtons(modifier: Modifier = Modifier)
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
            onClick = {})
        {
            Text("Sign Up")
        }
    }
}
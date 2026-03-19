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
import java.util.regex.Matcher

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
        //registryButtons(modifier = Modifier)
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
                top = 10.dp,
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
    var emailText by remember { mutableStateOf("") }
    var telText by remember { mutableStateOf("") }
    var passText by remember { mutableStateOf("") }
    var conPassText by remember { mutableStateOf("") }

    var userError by remember { mutableStateOf(false) }
    var mailError by remember { mutableStateOf(false) }
    var telError by remember { mutableStateOf(false) }
    var passError by remember { mutableStateOf(false) }

    //Función para validar que solo se introduzcan letras
    fun validUser(username: String): Boolean
    {
        val regex = Regex("^[a-zA-Z]+$")
        return regex.matches(username)
    }

    //Función para validar que solo se introduzcan emails
    fun validEmail(email: String): Boolean
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    //Función para validar que solo se introduzcan numero de telefono
    fun validTel(tel: String): Boolean
    {
        val regex = Regex("^[0-9]{10}$")
        return regex.matches(tel)
    }

    //Función para validar que las contraseñas sean iguales
    fun validPass(pass: String, conPass: String): Boolean
    {
        return pass == conPass
    }

    //Función para validar que todos los campos sean correctos y no esten vacios
    fun validFields(
        userText: String,
        emailText: String,
        telText: String,
        passText: String,
        conPassText: String,
        userError: Boolean,
        mailError: Boolean,
        telError: Boolean,
        passError: Boolean
    ): Boolean
    {
        return userText.isNotBlank() && emailText.isNotBlank() &&
                telText.isNotBlank() && passText.isNotBlank() &&
                conPassText.isNotBlank() && !userError && !mailError &&
                !telError && !passError && passText == conPassText
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 40.dp)
    )
    {
        TextField(
            value = userText,
            isError = userError,
            onValueChange = {
                userText = it
                userError = !validUser(username = it)
                            },
            label = { Text("Username") },
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
            value = emailText,
            isError = mailError,
            onValueChange = {
                emailText = it
                mailError = !validEmail(email = it)},
            label = { Text("Email") },
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
            value = telText,
            isError = telError,
            onValueChange = {
                telText = it
                telError = !validTel(tel = it)
                            },
            label = { Text("Teléfono") },
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
            value = passText,
            isError = passError,
            onValueChange = {
                passText = it
                passError = !validPass(passText, conPassText)
                            },
            label = { Text("Password") },
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
            value = conPassText,
            isError = passError,
            onValueChange = {
                conPassText = it
                passError = !validPass(passText, conPassText)
                            },
            label = { Text("Confirm password") },
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
            onClick = {},
            enabled = validFields(userText, emailText, telText, passText,
                conPassText, userError, mailError, telError, passError))
        {
            Text("Sign Up")
        }
    }
}
/*
@Composable
fun registryButtons(modifier: Modifier = Modifier, validFields: Boolean)
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
            onClick = {},
            enabled = validFields)
        {
            Text("Sign Up")
        }
    }
}

*/
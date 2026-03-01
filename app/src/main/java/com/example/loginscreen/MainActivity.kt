package com.example.loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.ui.theme.LoginScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //WelcomeImage(modifier = Modifier.padding(innerPadding))
                    Column(modifier = Modifier.padding(innerPadding))
                    {
                        WelcomeImage(modifier = Modifier)
                        WelcomeMsg(modifier = Modifier)
                        WelcomeBtns(modifier = Modifier)
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeImage (modifier: Modifier = Modifier)
{
        Image(
            painter = painterResource(R.drawable.home_image),
            contentDescription = "Imagen del Home cuando no se inició sesión",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
}


@Composable
fun WelcomeMsg (modifier: Modifier = Modifier)
{
    /*Column con alineamiento central y extendida al maximo para texto centrado
      con fondo blanco
     */
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 52.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Titulo "Hello"
        Text(
            stringResource(R.string.welcome),
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif)
        //Texto de presentación
        Text(stringResource(
            R.string.Welcome_msg),
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            color = Color.Gray)
    }
}

@Composable
fun WelcomeBtns (modifier: Modifier = Modifier)
{
    //Column para establecer padding simulando margen
    Column(
        Modifier
            .padding(
                start = 50.dp,
                top = 35.dp,
                end = 50.dp,
                bottom = 30.dp
            )
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        //Box y Text para simular un botón de Login
        Box(
            modifier
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color(82, 78, 172))
                .requiredHeight(60.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                "Login",
                modifier
                    .fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        }
    }
    //Segundo column para establecer padding simulando un margen
    Column(
        Modifier
            .padding(horizontal = 50.dp)
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        //Box y Text para simular un botón de Sign Up
        Box(
            modifier
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color.White)
                .border(
                    width = 3.dp,
                    color = Color(82, 78, 172),
                    shape = RoundedCornerShape(30.dp))
                .requiredHeight(60.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                "Login",
                modifier
                    .fillMaxWidth(),
                color = Color(82, 78, 172),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

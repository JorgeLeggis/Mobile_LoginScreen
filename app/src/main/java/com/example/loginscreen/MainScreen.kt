package com.example.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun mainScreenBackButton(navController: NavController, modifier: Modifier = Modifier)
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
            onClick = {navController.navigate(route = "welcome")})
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
fun mainScreenOptions(modifier: Modifier)
{
    var nameText by remember { mutableStateOf("") }
    var telText by remember { mutableStateOf("") }

    Column()
    {
        TextField(
            value = nameText,
            isError = false,
            onValueChange = {nameText},
            label = {Text("Name: Ex. Juan Peréz")},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .padding(vertical = 0.dp, horizontal = 15.dp),
            singleLine = true
        )
        TextField(
            value = telText,
            isError = false,
            onValueChange = {telText},
            label = {Text("Tel Number: Ex. 612123456789")},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .padding(15.dp),
            singleLine = true
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(82,78,172),
                contentColor =  Color.White,
                disabledContainerColor = Color.White
            ),
            onClick = {})
        {
            Text("Add contact",
                fontSize = 20.sp)
        }
    }
}
@Composable
fun mainScreenListAndOptions(modifier: Modifier) {
    val contactList = remember {
        mutableStateListOf(
            Pair("Juan Pérez", "612-123-4567")
        )
    }

    var nameText by remember { mutableStateOf("") }
    var telText by remember { mutableStateOf("") }

    Column()
    {
        TextField(
            value = nameText,
            isError = false,
            onValueChange = {nameText = it},
            label = {Text("Name: Ex. Juan Peréz")},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .padding(vertical = 0.dp, horizontal = 15.dp),
            singleLine = true
        )
        TextField(
            value = telText,
            isError = false,
            onValueChange = {telText = it},
            label = {Text("Tel Number: Ex. 612123456789")},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .padding(15.dp),
            singleLine = true
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .padding(vertical = 0.dp, horizontal = 15.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(82,78,172),
                contentColor =  Color.White,
                disabledContainerColor = Color.White
            ),
            onClick = {
                contactList.add(Pair(nameText, telText))
            })
        {
            Text("Add contact",
                fontSize = 20.sp)
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .padding(15.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(82,78,172),
                contentColor =  Color.White,
                disabledContainerColor = Color.White
            ),
            onClick = {
                nameText = ""
                telText = ""
            })
        {
            Text("Clear fields",
                fontSize = 20.sp)
        }
    }

    LazyColumn(modifier = Modifier.padding(25.dp)) {
            items(contactList)
            { contact ->
                Contact(name = contact.first, phone = contact.second)
                Spacer(modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth())
            }
    }

}


@Preview
@Composable
fun mainScreenPreview()
{
    val navController = rememberNavController()

    mainScreenListAndOptions(modifier = Modifier)
}

@Composable
fun MainScreenVisuals(navController: NavController, innerPadding: PaddingValues)
{
    Column(modifier = Modifier.fillMaxWidth())
    {
        mainScreenBackButton(modifier = Modifier, navController = navController)
        //mainScreenOptions(modifier = Modifier)
        mainScreenListAndOptions(modifier = Modifier)
    }
}
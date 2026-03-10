package com.example.loginscreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding



@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcome",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("welcome") {
                WelcomeScreenVisuals(
                    navController = navController,
                    innerPadding = innerPadding
                )
            }
            composable("login") {
                LoginScreenVisuals(
                    navController = navController,
                    innerPadding = innerPadding
                )
            }
            composable("signup") {
                RegistryScreenVisuals(
                    navController = navController,
                    innerPadding = innerPadding
                )
            }
        }
    }
}




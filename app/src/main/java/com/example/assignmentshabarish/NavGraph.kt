package com.example.assignmentshabarish

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.assignmentshabarish.ui.theme.ALogin
import com.example.assignmentshabarish.ui.theme.Login
import com.example.assignmentshabarish.ui.theme.UserLogin
import com.example.assignmentshabarish.ui.theme.WLogin

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Welcome") {


        composable(route = "Welcome") {
            WLogin(navController)
        }
        composable(route = "Admin") {
          Login(navController )
        }
        composable(route = "User") {
            UserLogin(navController)
        }
        composable(route = "SinAdmin") {
           ALogin(navController)
        }
        composable(route = "WUser") {
            UserLogin(navController)
        }


    }
}





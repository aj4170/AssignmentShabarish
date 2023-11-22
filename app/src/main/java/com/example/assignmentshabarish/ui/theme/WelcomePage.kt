package com.example.assignmentshabarish.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignmentshabarish.R

class WelcomePage()  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            AssignmentShabarishTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WLoginPreview() {
    var navController =  rememberNavController()
    WLogin(navController)
}

@Composable
fun WLogin(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bgimage),
            contentDescription = "WLogin",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                .alpha(0.4f)
                .clip(
                    CutCornerShape(
                        topStart = 10.dp,
                        topEnd = 36.dp,
                        bottomStart = 36.dp,
                        bottomEnd = 10.dp
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WLoginHeader()
            WLoginFooter(navController)
        }
    }
}

@Composable
fun WLoginFooter(navController: NavHostController) {

    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {navController.navigate("Admin")}, modifier = Modifier.fillMaxWidth()) {
        Text(text = " Admin ")

    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { navController.navigate("User") }, modifier = Modifier.fillMaxWidth()) {
        Text(text = " User ")
    }
}

@Composable
fun WLoginHeader() {
    Text(
        text = "Welcome Back",
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold
    )
    Text(
        text = "Admin / User",
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
}

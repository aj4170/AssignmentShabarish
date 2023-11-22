package com.example.assignmentshabarish.ui.theme

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignmentshabarish.R

class AdminWelcome() : ComponentActivity() {
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
fun LoginPreview() {
    var navController =  rememberNavController()
    Login(navController)
}


@Composable
fun Login(navController: NavHostController) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.bgaimage),
            contentDescription = "Login",
            // when ever the talk back is on it will read what is inside the( contentDescription = "Login")
            modifier = Modifier.fillMaxSize(),
            // it will occupy entire height and width
            //to add blur to image Modifier.fillMaxSize().blur(2.dp)
            contentScale = ContentScale.Crop)
        // contentscale make sure that the image fit the entire screen

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .alpha(0.4f)
            //it makes the background transparent (0.7f) is the 70%
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
            Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            LoginFields(username,password,
                onUsernameChange = {
                    username = it
                },
                onPasswordChange = {
                    password = it
                },
                )

            LoginFooter(navController)
        }

    }

}

@Composable
fun LoginHeader(){
    Text(text = "Welcome Admin",
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold)
    Text(text = "Sign in to continue",
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp)
}

@Composable
fun LoginFields(username: String,
                            password:String,
                            onUsernameChange:(String) -> Unit,
                            onPasswordChange:(String)->Unit){
    DemoField(
        value = username ,
        label = "Admin-name",
        placeholder = "Enter u'r email",
        onValueChange = onUsernameChange,
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }

    )

    Spacer(modifier = Modifier.height(8.dp))

    DemoField(
        value = password ,
        label = "Password",
        placeholder = "Enter u r password",
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "password")
        }
    )



}

@Composable
fun LoginFooter(navController: NavHostController){
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { navController.navigate("SinAdmin") }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Sign in")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoField(value : String,
              label: String,
              placeholder: String,
              visualTransformation: VisualTransformation = VisualTransformation.None,
              keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
              leadingIcon: @Composable (() -> Unit)? = null,
              trailingIcon: @Composable (() -> Unit)? = null,
              onValueChange : (String) -> Unit){
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder ={
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )

}






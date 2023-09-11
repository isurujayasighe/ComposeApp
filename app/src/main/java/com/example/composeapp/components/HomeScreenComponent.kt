package com.example.composeapp.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun homeScreenComponents() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        val (appNameTxt, usernameInput, passwordInput, loginBtn) = createRefs()

        val topGuideLine = createGuidelineFromTop(0.17f)
        val centerGuideLine = createGuidelineFromTop(0.35f)

        Text(
            text = "Business Card Reader App",

            modifier = Modifier
                .constrainAs(appNameTxt) {
                    top.linkTo(topGuideLine, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints

                },
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp

            ), color = Color.Gray
        )

        OutlinedTextField(value = "Username", onValueChange = {

        }, modifier = Modifier.constrainAs(usernameInput) {

            top.linkTo(centerGuideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })

        OutlinedTextField(value = "Password", onValueChange = {

        }, modifier = Modifier.constrainAs(passwordInput) {

            top.linkTo(usernameInput.bottom, margin = 8.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })

        Button(modifier = Modifier.constrainAs(loginBtn) {
                  top.linkTo(passwordInput.bottom, margin = 16.dp)
            start.linkTo(passwordInput.start)
            end.linkTo(passwordInput.end)
            width = Dimension.fillToConstraints
        }, onClick = { /*TODO*/ }) {
            Text(text = "SIGN IN")
        }


    }

}
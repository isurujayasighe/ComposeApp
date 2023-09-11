package com.example.composeapp.constraintLayout

import android.print.PrintAttributes.Margins
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composeapp.R


@Preview(showBackground = true)
@Composable
fun constraintLayout(){

    var state by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ){
        item {
            TitleComponent(title = "Simple Constraint Layout")
            SimpleConstraintLayout()
        }
        item {
            TitleComponent(title = "Guideline Constraint Layout Component")
            GuidelineConstraintLayoutComponent()
        }
    }
}

@Composable
fun SimpleConstraintLayout(){

    Card(modifier = Modifier
        .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxWidth()){
            val (title,subtitle, image,count,year,status) = createRefs()
            Text(text = "Title",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(4),
                    fontSize = 14.sp
                ), modifier = Modifier
                    .constrainAs(title){
                        start.linkTo(image.end, margin = 4.dp)
                        top.linkTo(parent.top, margin = 16.dp)
                    }
            )

            Text(text = "Subtitle",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(4),
                    fontSize = 14.sp
                ), modifier = Modifier
                    .constrainAs(subtitle){
                       start.linkTo(image.end, margin = 4.dp)
                        top.linkTo(title.bottom, margin = 8.dp)
                    }
            )

            Text(text = "5",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(4),
                    fontFamily = FontFamily.Monospace
                ), modifier = Modifier
                    .constrainAs(count){
                        end.linkTo(parent.end, margin = 8.dp)
                        top.linkTo(parent.top, margin = 8.dp)
                    }
            )

            Text(text = "2023",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(4),
                    fontFamily = FontFamily.Monospace
                ), modifier = Modifier
                    .constrainAs(year){
                        start.linkTo(image.end, margin = 4.dp)
                        top.linkTo(subtitle.bottom, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }
            )

            Text(text = "Released",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(4),
                    fontSize = 14.sp
                ), modifier = Modifier
                    .constrainAs(status){
                        end.linkTo(parent.end, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }
            )

            Column(
                modifier = Modifier

                    .width(72.dp)
                    .constrainAs(image) {
                        centerVerticallyTo(parent)
//                        centerHorizontallyTo(parent)
                        start.linkTo(parent.start, margin = 12.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(year.bottom)
                    }
            ) {
                Image(painterResource(id = R.drawable.header),contentDescription = null)
            }
        }
    }
}

@Composable
fun GuidelineConstraintLayoutComponent(){

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(120.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

        ConstraintLayout (modifier = Modifier.fillMaxWidth()) {
            val (title,subtitle,year,image) = createRefs()


        }
    }
}

@Composable
fun TitleComponent(title: String){
    Text(text = title, color = Color.Blue, modifier = Modifier.padding(10.dp))
}
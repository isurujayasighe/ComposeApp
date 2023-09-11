package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.authenticatorapp.AuthApp
import com.example.composeapp.composeNavigation.AnimalScreen
import com.example.composeapp.constraintLayout.constraintLayout
import com.example.composeapp.expenceTracker.Dashboard
import com.example.composeapp.flow.KotlinFlow
import com.example.composeapp.layoutConfig.LayoutConfigMain
import com.example.composeapp.otp.OtpScreen
import com.example.composeapp.runtimepermissions.RunTimePermissionsSingle
import com.example.composeapp.state.ModelComponent
import com.example.composeapp.state.StateComponent
import com.example.composeapp.stateFlow.StateFlowTesting
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.windowInsets.BaseWindowInsets

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            BaseWindowInsets()
//            StateFlowTesting()
            ComposeAppTheme {
//                Dashboard()
//                OtpScreen()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Theme() {
    ComposeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "My Notes", style = TextStyle(
                                    fontSize = 18.sp
                                )
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior,
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "fav icon"
                                )
                            }
                        },
                        windowInsets = WindowInsets.displayCutout,
                    )
                },
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = {
                    ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
                        Text(text = "Inc")

                    }
                }
            ) { values ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(values)
                ) {
                    items(100) {
                        Text(text = "Item $it", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun NewsStory() {
    val typography = MaterialTheme.typography
    val image = painterResource(id = R.drawable.header)

    Column(
        modifier = Modifier
            .padding(16.dp)

    ) {
        val imageModifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))

        Image(
            painter = image, contentDescription = "image for header",
            modifier = imageModifier, contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.requiredHeight(16.dp))

        Text(
            text = "A day wandering through the sandhills" +
                    "in Shark Fin Cove, and a few of the " + "sights I saw",
            style = typography.bodyLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.requiredHeight(10.dp))

        Text(text = "Davenport, California", style = typography.bodyMedium)

        Spacer(modifier = Modifier.requiredHeight(4.dp))

        Text(text = "December 2023", style = typography.bodySmall)
    }
}

@Composable
fun TitleComponent(title: String) {
    Text(text = title, color = Color.Blue, modifier = Modifier.padding(10.dp))
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
//        NewsStory()
        Column(modifier = Modifier.fillMaxWidth()) {
            /* StateComponent()
             ModelComponent()*/
//            LayoutConfigMain()
//            constraintLayout()
//            RunTimePermissionsSingle()
//            https://github.com/twissmueller/mobile-snippets/blob/main/navigation/app/src/main/java/com/example/navigation/MainActivity.kt
            AnimalScreen()
        }
    }
}
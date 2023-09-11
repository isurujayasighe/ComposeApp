package com.example.composeapp.runtimepermissions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RunTimePermissionsSingle(){

    val camaraPermissionState = rememberPermissionState(permission = android.Manifest.permission.CAMERA)

    if (camaraPermissionState.status.isGranted){
        Text(text = "Permission Granted")
    }else{
        Column {
            val textToShow = if (camaraPermissionState.status.shouldShowRationale) {
                "The camera is important for this app. Please grant the permission."
            } else {
                "Camera not available"
            }

            Text(textToShow)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { camaraPermissionState.launchPermissionRequest() }) {
                Text("Request permission")

            }
        }
    }

}
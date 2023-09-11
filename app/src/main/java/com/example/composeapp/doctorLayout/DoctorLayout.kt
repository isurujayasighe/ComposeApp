package com.example.composeapp.doctorLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.composeapp.R

@Preview(showBackground = true)
@Composable
fun mainLayout() {
    background()
}

@Composable
fun background() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (background, profileImage, notificationIcon,
            greetingMsg, askMsg, doctorImg, urgentCareImg,
            bottomSheetCard) = createRefs()

//        Guide Lines
        val topGuideLine = createGuidelineFromTop(16.dp)
        val horizontalCenterGuidLine = createGuidelineFromTop(0.45f)
        val startGuideLine = createGuidelineFromStart(16.dp)
        val endGuideLine = createGuidelineFromEnd(16.dp)

//        Barriers
        val greetingBarrier = createEndBarrier(greetingMsg, askMsg)

        val username = "Cengiz TORU"
        val greetingMassage = "Welcome ! \n$username "

        Image(painterResource(id = R.drawable.gradient_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .alpha(0.8f)
                .constrainAs(background) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(horizontalCenterGuidLine)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })

        Image(painterResource(id = R.drawable.profile), contentDescription = null,
            modifier = Modifier
                .constrainAs(profileImage) {
                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideLine)
                }
                .clip(CircleShape)
                .size(42.dp))

        Image(painterResource(id = R.drawable.notification), contentDescription = null,
            modifier = Modifier
                .constrainAs(notificationIcon) {
                    top.linkTo(topGuideLine)
                    end.linkTo(endGuideLine)
                    bottom.linkTo(profileImage.bottom)
                }
                .clip(CircleShape)
                .size(42.dp))

        Text(text = greetingMassage,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .constrainAs(greetingMsg) {
                    start.linkTo(startGuideLine)
                    top.linkTo(profileImage.bottom, margin = 32.dp)
                })

        Text(text = "How is it going Today?",
            color = Color.Gray,
            modifier = Modifier
                .constrainAs(askMsg) {
                    start.linkTo(greetingMsg.start)
                    top.linkTo(greetingMsg.bottom, margin = 16.dp)
                })

        Image(painterResource(id = R.drawable.doctor), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.constrainAs(doctorImg) {
                top.linkTo(notificationIcon.bottom, margin = 32.dp)
                start.linkTo(greetingBarrier)
                end.linkTo(notificationIcon.end)
                bottom.linkTo(horizontalCenterGuidLine)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

        Image(painterResource(id = R.drawable.urgent_care), contentDescription = null,
            modifier = Modifier.constrainAs(urgentCareImg) {
                start.linkTo(askMsg.start)
                top.linkTo(askMsg.bottom, margin = 32.dp)
                end.linkTo(askMsg.end)
            })

        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .constrainAs(bottomSheetCard) {
                    top.linkTo(horizontalCenterGuidLine, margin = (-4).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            colors = CardDefaults.cardColors(Color.White)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                val (ourServiceTxt,
                    consultationIcon, medicinesIcon, ambulanceIcon,
                    consultationText, medicinesText, ambulanceText,) = createRefs()

                val (
                    appointmentText, seeAllText,
                    appointmentItemCard,
                    appointmentDateText,
                    appointmentDateIcon, appointmentDate, appointmentOptions,
                    appointmentDivider,
                    appointmentDoctorProfileImage, appointmentDoctorName,
                    appointmentDoctorBranch
                ) = createRefs()

                Text(text = "Our Services",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .constrainAs(ourServiceTxt) {
                            start.linkTo(parent.start, margin = 8.dp)
                            top.linkTo(parent.top, margin = 8.dp)
                        }
                )

                createHorizontalChain(consultationIcon,medicinesIcon,ambulanceIcon, chainStyle = ChainStyle.Spread)

                Image(painterResource(id = R.drawable.consultation_icon), contentDescription = null,
                    modifier = Modifier
                        .constrainAs(consultationIcon){
                            top.linkTo(ourServiceTxt.bottom, margin = 16.dp)
                        }
                )

                Image(painterResource(id = R.drawable.medicines_icon), contentDescription = null,
                    modifier = Modifier
                        .constrainAs(medicinesIcon){
                            top.linkTo(consultationIcon.top)
                            bottom.linkTo(consultationIcon.bottom)
                        }
                )

                Image(painterResource(id = R.drawable.ambulance_icon), contentDescription = null,
                    modifier = Modifier
                        .constrainAs(ambulanceIcon){
                            top.linkTo(consultationIcon.top)
                            bottom.linkTo(consultationIcon.bottom)
                        }
                )

                Text(text = "Consultation",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(consultationText) {
                        top.linkTo(consultationIcon.bottom, 12.dp)
                        start.linkTo(consultationIcon.start)
                        end.linkTo(consultationIcon.end)
                    }
                )

                Text(text = "Medicines",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(medicinesText) {
                        top.linkTo(consultationText.top)
                        start.linkTo(medicinesIcon.start)
                        end.linkTo(medicinesIcon.end)
                    }
                )
                Text(text = "Ambulance",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(ambulanceText) {
                        top.linkTo(consultationText.top)
                        start.linkTo(ambulanceIcon.start)
                        end.linkTo(ambulanceIcon.end)
                    }
                )
                Text(text = "Appointment",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(appointmentText) {
                        top.linkTo(consultationText.bottom, margin = 30.dp)
                        start.linkTo(parent.start)
                    }
                )
                Text(text = "See All",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    modifier = Modifier.constrainAs(seeAllText) {
                        top.linkTo(appointmentText.top)
                        end.linkTo(parent.end)
                    }
                )
                
            }
        }

    }
}
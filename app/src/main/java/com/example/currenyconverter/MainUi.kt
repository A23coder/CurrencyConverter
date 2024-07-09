package com.example.currenyconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CcUI(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(20.dp) ,
    ) {
        Column(
            modifier
                .fillMaxSize()
                .background(Color(0xFFEEF4F7))
                .align(Alignment.Center)
                .padding(top = 50.dp)
        ) {
            Text(
                modifier = modifier.fillMaxWidth() ,
                text = stringResource(id = R.string.currency_converter) ,
                style = TextStyle(
                    textAlign = TextAlign.Center ,
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.Bold ,
                    fontStyle = FontStyle.Normal ,
                    fontFamily = FontFamily.Monospace ,
                    color = Color(0xff26278d)
                )
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp) ,
                text = stringResource(id = R.string.sloganLine) ,
                style = TextStyle(
                    textAlign = TextAlign.Center ,
                    fontSize = 16.sp ,
                    color = Color.Black ,
                    fontWeight = FontWeight.W900
                ) ,
                color = Color(0xFF747474)
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 26.dp
                ) ,
                shape = RoundedCornerShape(50.dp) ,
                modifier = modifier
                    .size(500.dp)
                    .padding(top = 100.dp) ,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White ,
                ) ,
            ) {
                Column(
                    modifier
                        .padding(20.dp)
                        .fillMaxSize() ,
                ) {
                    ConvertUi(onAmountChange = {
                        "1000"
                    })
                }
            }

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 40.dp ,
                        start = 10.dp
                    ) ,
                text = stringResource(id = R.string.exchangeRate) ,
                style = TextStyle(
                    textAlign = TextAlign.Start ,
                    fontSize = 15.sp ,
                ) ,
                color = Color(0xFF747474)
            )
            val exchangeRate = "1 INR = 85.23 USD"
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp ,
                        start = 10.dp
                    ) ,
                text = exchangeRate ,
                style = TextStyle(
                    textAlign = TextAlign.Start ,
                    fontSize = 20.sp ,
                    fontWeight = FontWeight.W500
                ) ,
                color = Color.Black
            )
        }
    }
}


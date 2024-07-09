package com.example.currenyconverter

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConvertUi(
    modifier: Modifier = Modifier ,
    currencyCode: String = "INR" ,
    amount: String = "0.0" ,
    onAmountChange: (String) -> Unit ,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        Modifier.wrapContentSize()
    ) {
        Text(
            modifier = modifier.padding(top = 10.dp , start = 10.dp , bottom = 10.dp) ,
            text = "Amount" ,
            style = TextStyle(
                fontSize = 20.sp , color = Color(0xFF444444)
            )
        )
    }
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = currencyCode , textAlign = TextAlign.Start , style = TextStyle(
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.W400 ,
                    textAlign = TextAlign.Center ,
                    color = colorResource(id = R.color.lightBlue)
                ) , modifier = Modifier
                    .fillMaxWidth(.30f)
                    .padding(10.dp)
            )
            IconButton(onClick = { expanded = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down_icon) ,
                    contentDescription = "Dropdown Arrow" ,
                    modifier = Modifier.size(150.dp)
                )
            }

            TextField(value = text ,
                onValueChange = { newVal -> text = newVal } ,
                maxLines = 1 ,
                textStyle = TextStyle(fontSize = 18.sp) ,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray ,
                    focusedIndicatorColor = Color.Transparent ,
                    unfocusedIndicatorColor = Color.Transparent ,
                    focusedTextColor = Color(0xFF292929) ,
                    unfocusedTextColor = Color(0xFF292929)
                ) ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 5.dp)
                    .clip(RoundedCornerShape(10.dp)))
        }
    }
    Column(modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Divider(
                color = Color.LightGray ,
                thickness = 1.dp ,
                modifier = Modifier.align(Alignment.Center)
            )
            Box(
                contentAlignment = Alignment.Center ,
                modifier = Modifier
                    .size(60.dp)
                    .background(color = Color(0xFF1A237E) , shape = RoundedCornerShape(50.dp))
            ) {
                Icon(
                    painterResource(id = R.drawable.swap) ,
                    contentDescription = "Swap" ,
                    tint = Color.White ,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            generateToast(context)
                        }
                )
            }
        }
    }
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = currencyCode , textAlign = TextAlign.Start , style = TextStyle(
                    fontSize = 25.sp ,
                    fontWeight = FontWeight.W400 ,
                    textAlign = TextAlign.Center ,
                    color = colorResource(id = R.color.lightBlue)
                ) , modifier = Modifier
                    .fillMaxWidth(.30f)
                    .padding(10.dp)
            )
            IconButton(onClick = { expanded = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down_icon) ,
                    contentDescription = "Dropdown Arrow" ,
                    modifier = Modifier.size(150.dp)
                )
            }

            TextField(value = text ,
                onValueChange = { newVal -> text = newVal } ,
                maxLines = 1 ,
                textStyle = TextStyle(fontSize = 18.sp) ,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray ,
                    focusedIndicatorColor = Color.Transparent ,
                    unfocusedIndicatorColor = Color.Transparent ,
                    focusedTextColor = Color(0xFF292929) ,
                    unfocusedTextColor = Color(0xFF292929)
                ) ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 5.dp)
                    .clip(RoundedCornerShape(10.dp)))
        }
    }

}

fun generateToast(context: Context) {
    Toast.makeText(context , "Currency is INR" , Toast.LENGTH_SHORT).show()
}

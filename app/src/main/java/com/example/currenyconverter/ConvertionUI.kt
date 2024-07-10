package com.example.currenyconverter

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
    val currencies = listOf(
        "INR" , "USD" , "AUD" , "EUR" , "GBP" , "JPY" , "CNY" , "CAD" , "CHF" , "NZD" , "SGD" ,
        "AUD" ,
        "EUR" ,
        "GBP" ,
        "JPY" ,
        "CNY" ,
        "CAD" ,
        "CHF" ,
        "NZD" ,
        "SGD"
    )
    var selectedOptionText by remember { mutableStateOf(currencies[0]) }

    var expanded by remember {
        mutableStateOf(false)
    }
    var text by remember {
        mutableStateOf("")
    }
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
            ExposedDropdownMenuBox(
                expanded = expanded ,
                onExpandedChange = { expanded = !expanded } ,
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(.5f) ,
                    readOnly = true ,
                    value = selectedOptionText ,
                    onValueChange = {} ,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) } ,
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = Color.White ,
                        unfocusedContainerColor = Color.White
                    ) ,
                    textStyle = TextStyle(
                        fontSize = 20.sp
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded ,
                    onDismissRequest = { expanded = false } ,
                ) {
                    currencies.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    selectionOption , style =
                                    TextStyle(
                                        fontSize = 20.sp
                                    )
                                )
                            } ,
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }
            TextField(value = text ,
                onValueChange = { text = it } ,
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
                    .height(55.dp)
                    .padding(start = 5.dp)
                    .clip(RoundedCornerShape(10.dp)))
        }
        Column(modifier.fillMaxWidth()) {
            Box(
                contentAlignment = Alignment.Center ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.align(Alignment.Center) ,
                    thickness = 1.dp ,
                    color = Color.LightGray
                )
                Box(
                    contentAlignment = Alignment.Center ,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color(0xFF1A237E) , shape = RoundedCornerShape(50.dp))
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_money) ,
                        contentDescription = "Swap" ,
                        tint = Color.White ,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
        Column(
            Modifier.wrapContentSize()
        ) {
            Text(
                modifier = modifier.padding(top = 10.dp , start = 10.dp , bottom = 10.dp) ,
                text = "Converted Amount" ,
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
                ExposedDropdownMenuBox(
                    expanded = expanded ,
                    onExpandedChange = { expanded = !expanded } ,
                ) {
                    TextField(
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(.5f) ,
                        readOnly = true ,
                        value = selectedOptionText ,
                        onValueChange = {} ,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) } ,
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            focusedContainerColor = Color.White ,
                            unfocusedContainerColor = Color.White
                        ) ,
                        textStyle = TextStyle(
                            fontSize = 20.sp
                        )
                    )
                    ExposedDropdownMenu(
                        expanded = expanded ,
                        onDismissRequest = { expanded = false } ,
                    ) {
                        currencies.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        selectionOption , style =
                                        TextStyle(
                                            fontSize = 20.sp
                                        )
                                    )
                                } ,
                                onClick = {
                                    selectedOptionText = selectionOption
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray) , contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text , style = TextStyle(
                            fontWeight = FontWeight.Bold ,
                            fontSize = 25.sp ,
                            textAlign = TextAlign.End ,
                            color = Color(0xFF292929)
                        ) , modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp)
                    )
                }
            }
        }
    }
}
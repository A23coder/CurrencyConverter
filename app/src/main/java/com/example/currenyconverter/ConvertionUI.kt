package com.example.currenyconverter

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currenyconverter.Utils.Companion.currencies
import com.example.currenyconverter.Utils.Companion.currenciesConverted
import com.example.currenyconverter.viewmodel.CurrencyViewModel

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConvertUi(
    modifier: Modifier = Modifier ,
    viewModel: CurrencyViewModel ,
) {
    var selectedOptionText by remember { mutableStateOf(currencies[1]) }
    var selectedOptionTextConverted by remember { mutableStateOf(currenciesConverted[0]) }

    var expanded by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }
    var amountText by remember { mutableStateOf("1") }
    val conversionResult by viewModel.conversionResult

    Column(modifier = Modifier.wrapContentSize()) {
        Text(
            modifier = modifier.padding(top = 10.dp , start = 10.dp , bottom = 10.dp) ,
            text = "Amount" ,
            style = TextStyle(fontSize = 20.sp , color = Color(0xFF444444))
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
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
                        .fillMaxWidth(0.5f) ,
                    readOnly = true ,
                    value = selectedOptionText ,
                    onValueChange = {} ,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) } ,
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = Color.White ,
                        unfocusedContainerColor = Color.White
                    ) ,
                    textStyle = TextStyle(
                        fontSize = 20.sp ,
                        color = colorResource(id = R.color.purple_500) ,
                        fontWeight = FontWeight.W500
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
                                    selectionOption , style = TextStyle(fontSize = 20.sp)
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
            TextField(
                value = amountText ,
                onValueChange = { amountText = it } ,
                maxLines = 1 ,
                minLines = 1 ,
                textStyle = TextStyle(
                    fontWeight = FontWeight.W600 , fontSize = 25.sp , textAlign = TextAlign.End
                ) ,
                colors = textFieldColors(
                    containerColor = Color.LightGray ,
                    focusedIndicatorColor = Color.Transparent ,
                    unfocusedIndicatorColor = Color.Transparent ,
                    focusedTextColor = Color(0xFF292929) ,
                    unfocusedTextColor = Color(0xFF292929)
                ) ,
                modifier = Modifier
                    .height(55.dp)
                    .padding(start = 5.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
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
                    val amountValue = amountText.toDoubleOrNull() ?: 0.0
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money) ,
                        contentDescription = "Swap" ,
                        tint = Color.White ,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                viewModel.currencyConverter(
                                    amountValue ,
                                    selectedOptionText ,
                                    selectedOptionTextConverted
                                )
                                CurrencyViewModel(selectedOptionText , selectedOptionTextConverted)
                            }
                    )
                }
            }
        }
        Column(modifier.wrapContentSize()) {
            Text(
                modifier = modifier.padding(top = 10.dp , start = 10.dp , bottom = 10.dp) ,
                text = "Converted Amount" ,
                style = TextStyle(fontSize = 20.sp , color = Color(0xFF444444))
            )
        }
        Column(modifier.fillMaxWidth()) {
            Row(
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                ExposedDropdownMenuBox(
                    expanded = isExpanded ,
                    onExpandedChange = { isExpanded = !isExpanded } ,
                ) {
                    TextField(
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(0.5f) ,
                        readOnly = true ,
                        value = selectedOptionTextConverted ,
                        onValueChange = {} ,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) } ,
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            focusedContainerColor = Color.White ,
                            unfocusedContainerColor = Color.White
                        ) ,
                        textStyle = TextStyle(
                            fontSize = 20.sp ,
                            color = colorResource(id = R.color.purple_500) ,
                            fontWeight = FontWeight.W500
                        )
                    )
                    ExposedDropdownMenu(
                        expanded = isExpanded ,
                        onDismissRequest = { isExpanded = false } ,
                    ) {
                        currenciesConverted.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        selectionOption , style = TextStyle(fontSize = 20.sp)
                                    )
                                } ,
                                onClick = {
                                    selectedOptionTextConverted = selectionOption
                                    isExpanded = false
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
                        .background(Color.LightGray) ,
                ) {

                    Text(
                        text = String.format("%.2f" , conversionResult) , style = TextStyle(
                            fontWeight = FontWeight.Bold ,
                            fontSize = 25.sp , textAlign = TextAlign.End ,
                            color = Color(0xFF292929) ,
                        ) , modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

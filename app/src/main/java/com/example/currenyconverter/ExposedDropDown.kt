package com.example.currenyconverter

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropDown(modifier: Modifier = Modifier) {
    val currencies = listOf(
        "INR" ,
        "USD" ,
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
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedOptionItem by remember {
        mutableStateOf(currencies[0])
    }
    LocalContext.current
    ExposedDropdownMenuBox(expanded = expanded ,
        onExpandedChange = { expanded = !expanded }) {
//        TextField(
//            readOnly = true ,
//            value = selectedOptionItem ,
//            onValueChange = { } ,
//            textStyle = TextStyle(fontSize = 25.sp) ,
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color(android.graphics.Color.MAGENTA) ,
//                focusedIndicatorColor = Color.Transparent ,
//                unfocusedIndicatorColor = Color.Transparent ,
//                focusedTextColor = Color(0xFF292929) ,
//                unfocusedTextColor = Color(0xFF292929)
//            ) ,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 5.dp)
//        )
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(.35f) ,
            readOnly = true ,
            value = selectedOptionItem ,
            onValueChange = { } ,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) } ,
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                unfocusedContainerColor = Color.LightGray
            ) ,
        )
        ExposedDropdownMenu(
            expanded = expanded ,
            onDismissRequest = { expanded = false } ,
        ) {
            currencies.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) } ,
                    onClick = {
                        selectedOptionItem = selectionOption
                        expanded = false
                    } ,
                )
            }
        }

    }
}

package com.example.currenyconverter

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MakeUi(modifier: Modifier = Modifier,text:String,context:Context) {
    Toast.makeText(context , "The amount is $text" , Toast.LENGTH_SHORT).show()
}
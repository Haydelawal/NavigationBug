package com.hayde117.navigationbug.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hayde117.navigationbug.ui.theme.NavigationBugTheme

@Composable
fun ScreenA(modifier: Modifier = Modifier, onClick : () -> Unit) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Screen A")

        Button(onClick = onClick) {
            Text("Go To Screen B Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    NavigationBugTheme {
        ScreenA(onClick = {})
    }
}
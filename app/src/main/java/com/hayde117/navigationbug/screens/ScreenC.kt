package com.hayde117.navigationbug.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.hayde117.navigationbug.ui.theme.NavigationBugTheme

@Composable
fun ScreenC(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Screen C")

        Button(onClick = {
            Toast.makeText(context, "I am at Screen C", Toast.LENGTH_SHORT).show()
        }) {
            Text("Screen C Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCPreview() {
    NavigationBugTheme {
        ScreenC()
    }
}
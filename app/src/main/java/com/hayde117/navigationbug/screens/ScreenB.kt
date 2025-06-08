package com.hayde117.navigationbug.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayde117.navigationbug.data.Person
import com.hayde117.navigationbug.ui.theme.NavigationBugTheme

@Composable
fun ScreenB(modifier: Modifier = Modifier, onClick: () -> Unit,
            person: Person) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen B")

        Spacer(modifier.height(32.dp))

        Text(text = person.toString())

        Spacer(modifier.height(32.dp))

        Button(onClick = onClick) {
            Text("Go To Screen C Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {
    NavigationBugTheme {
        val fakePerson = Person(
            id = 99,
            firstName = "John",
            middleName = "Danger",
            lastName = "Doe",
            gender = "Male",
            age = "30"
        )
        ScreenB(onClick = {}, person = fakePerson)
    }
}
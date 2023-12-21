package com.example.my

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NoteScreen( viewModel: NoteViewModel, navController: NavController, modifier: Modifier = Modifier){
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 650.dp, top = 10.dp),
        )
    {
     TextField(
         modifier = Modifier
             .fillMaxSize(),
         value = title,
         onValueChange = {title = it},
         placeholder = {
             Text(modifier = Modifier
                 .fillMaxSize(),
                 text = stringResource(id = R.string.zag),
                 textAlign = TextAlign.Center,
                 fontWeight = FontWeight.Bold,
                 fontSize = 22.sp )
         }
     )
    }
    Column(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp, bottom = 150.dp, top = 70.dp)) {
        TextField(
            modifier = Modifier
                .fillMaxSize(),
            value = text,
            onValueChange = { text = it },
            placeholder = {
                Text(
                    modifier = Modifier
                        .fillMaxSize(),
                    text = stringResource(id = R.string.other),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        )
    }
    Column(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 700.dp)){
        Button(
            modifier = Modifier
                .padding(10.dp),
            enabled = text.isNotEmpty(),
            onClick = { viewModel.addNote(title,text)
            navController.navigateUp()})
        {
            Text(modifier = Modifier
                .fillMaxSize(),
                text = stringResource(id = R.string.save),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp )
        }
    }
}
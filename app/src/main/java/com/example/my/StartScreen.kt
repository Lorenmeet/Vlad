package com.example.my


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StartScreen(viewModel: NoteViewModel, navController: NavController, modifier: Modifier = Modifier){

    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()){

        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            Text(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                text = stringResource(id = R.string.note),
            textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
            viewModel.notes.forEach{note ->
                Box(modifier = Modifier
                    .size(400.dp, 160.dp)
                    .padding(20.dp)
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(6.dp)))
                {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState()))
                    {
                        Text(
                            text = note.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = note.text,
                            fontSize = 14.sp
                        )
                        androidx.compose.material3.Button(
                            modifier = Modifier
                                .size(110.dp, 60.dp)
                                .padding(start = 0.dp, top = 20.dp, end = 0.dp, bottom = 0.dp),
                            onClick = {viewModel.removeNote(note)})
                        {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize(),
                                text = stringResource(id = R.string.delete),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp)

                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            androidx.compose.material3.Button(
                onClick = { navController.navigate("/add-note") })
            {
                Text(
                    modifier = Modifier
                        .fillMaxSize(),
                    text = stringResource(id = R.string.addNote),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
    }

}
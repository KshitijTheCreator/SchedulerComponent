package com.example.schedulercomponent.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.schedulercomponent.R
import kotlin.text.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SchedulerComponent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My Schedules")
                },
                contentColor = Color.Black,
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "BackButton"
                        )
                    }
                }
            )
        },
    ) {
        Column(modifier = Modifier.padding(5.dp)){
            DropDownUtil()
            CardComponent()
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownUtil() {
    val options = listOf("Morning", "Afternoon", "Evening")
    var isExpanded by remember { mutableStateOf(false) }

    var selectedOptionText by remember { mutableStateOf(options[0]) }


    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = !isExpanded }
    ) {
        TextField(
            value = selectedOptionText,
            modifier = Modifier
                .background(color = Color.Transparent)
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(3.dp)),
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )


        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            options.forEach { selectedText ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectedText
                        isExpanded = false
                    }
                ) {
                    Text(text = selectedText)
                }

            }
        }

    }

}

@Preview
@Composable
fun CardComponent() {
    Card(modifier = Modifier
        .width(379.dp)
        .height(200.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(6.dp)),
        shape = RoundedCornerShape(6.dp),
        elevation = 4.dp
    ) {
        Row{
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "ImageDescription",
                modifier = Modifier
                    .padding(9.dp)
                    .height(82.5.dp)
                    .width(84.dp),
            )
            Column {
                Box(modifier = Modifier.fillMaxSize()){
                    Row(modifier = Modifier
                        .height(14.25.dp)
                        .width(42.75.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Fasting",
                            style = MaterialTheme.typography.h4
                        )
                        Text(text = "44%")
                    }
                }
            }
        }
    }
}















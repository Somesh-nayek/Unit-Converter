package com.example.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}
@Composable
fun UnitConverter(){
    var inputValue by remember{ mutableStateOf("") }
    var outputValue by remember{ mutableStateOf("") }
    var inputUnit by remember{ mutableStateOf("Centimetres") }
    var outputUnit by remember{ mutableStateOf("Centimetres") }
    var iExpanded by remember{ mutableStateOf(false) }
    var oExpanded by remember{ mutableStateOf(true) }
    val conversionFactor = remember{ mutableStateOf(1.00) }
    var inputExpression=1
    var outputExpression=1

    fun conversion(){
        val inputValueDouble=inputValue.toDoubleOrNull()?:0.00
        if(inputExpression==1 && outputExpression==1){
            conversionFactor.value = 1.00
        }
        else if(inputExpression==1 && outputExpression==2){
            conversionFactor.value = 0.01
        }
        else if(inputExpression==1 && outputExpression==3){
            conversionFactor.value = 0.10
        }
        else if(inputExpression==1 && outputExpression==4){
            conversionFactor.value = 0.00001
        }
        else if(inputExpression==1 && outputExpression==5){
            conversionFactor.value = 0.0328084
        }

        else if(inputExpression==2 && outputExpression==1){
            conversionFactor.value = 100.00
        }
        else if(inputExpression==2 && outputExpression==2){
            conversionFactor.value = 1.00
        }
        else if(inputExpression==2 && outputExpression==3){
            conversionFactor.value = 10.00
        }
        else if(inputExpression==2 && outputExpression==4){
            conversionFactor.value = 0.001
        }
        else if(inputExpression==2 && outputExpression==5){
            conversionFactor.value = 3.28084
        }

        else if(inputExpression==3 && outputExpression==1){
            conversionFactor.value = 10.00
        }
        else if(inputExpression==3 && outputExpression==2){
            conversionFactor.value = 0.1
        }
        else if(inputExpression==3 && outputExpression==3){
            conversionFactor.value = 1.00
        }
        else if(inputExpression==3 && outputExpression==4){
            conversionFactor.value = 0.0001
        }
        else if(inputExpression==3 && outputExpression==5){
            conversionFactor.value =0.328084
        }

        else if(inputExpression==4 && outputExpression==1){
            conversionFactor.value = 100000.00
        }
        else if(inputExpression==4 && outputExpression==2){
            conversionFactor.value = 1000.00
        }
        else if(inputExpression==4 && outputExpression==3){
            conversionFactor.value = 10000.00
        }
        else if(inputExpression==4 && outputExpression==4){
            conversionFactor.value = 1.00
        }
        else if(inputExpression==4 && outputExpression==5){
            conversionFactor.value = 3280.84
        }

        else if(inputExpression==5 && outputExpression==1){
            conversionFactor.value = 30.49
        }
        else if(inputExpression==5 && outputExpression==2){
            conversionFactor.value = 0.3048
        }
        else if(inputExpression==5 && outputExpression==3){
            conversionFactor.value = 3.048
        }
        else if(inputExpression==5 && outputExpression==4){
            conversionFactor.value = 0.0003048
        }
        else if(inputExpression==5 && outputExpression==5){
            conversionFactor.value = 1.00
        }
        val result=inputValueDouble*(conversionFactor.value)

        outputValue=result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Unit converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {inputValue=it
                conversion()
            },
            label = { Text(text = "Enter the value")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            //input box
            Box {
                //input button
                Button(onClick = { iExpanded = !iExpanded }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                    DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                        DropdownMenuItem(text = { Text(text = "Centimetres") }, onClick = {
                            iExpanded = false
                            inputUnit = "Centimetres"
                            inputExpression = 1
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Metres") }, onClick = {
                            iExpanded = false
                            inputUnit = "Metres"
                            inputExpression = 2
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Decimetres") }, onClick = {
                            iExpanded = false
                            inputUnit = "Decimetres"
                            inputExpression = 3
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Kilometres") }, onClick = {
                            iExpanded = false
                            inputUnit = "Kilometres"
                            inputExpression = 4
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            inputExpression = 5
                            conversion()
                        }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            //output box
            Box{
                //output button
                Button(onClick = {oExpanded=!oExpanded}) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {

                        DropdownMenuItem(text = { Text(text = "Centimetres") }, onClick = {
                            oExpanded = false
                            outputUnit = "Centimetres"
                            outputExpression = 1
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Metres") }, onClick = {
                            oExpanded = false
                            outputUnit = "Metres"
                            outputExpression = 2
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Decimetres") }, onClick = {
                            oExpanded = false
                            outputUnit = "Decimetres"
                            outputExpression = 3
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Kilometres") }, onClick = {
                            oExpanded = false
                            outputUnit = "Kilometres"
                            outputExpression = 4
                            conversion()
                        })

                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            outputExpression = 5
                            conversion()
                        }
                        )

                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:$outputValue")
    }
}



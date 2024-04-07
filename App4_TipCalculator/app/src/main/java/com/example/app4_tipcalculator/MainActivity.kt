package com.example.app4_tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app4_tipcalculator.ui.theme.App4_TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App4_TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipApp()
                }
            }
        }
    }
}

@Composable
fun TipApp(){
    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0

    var tipInput by remember {
        mutableStateOf("")
    }
    val tipPercentage = tipInput.toDoubleOrNull() ?: 0.0

    var switchInput by remember {
        mutableStateOf(false)
    }

    val tip = calculateTip(amount,switchInput,tipPercentage)

    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 40.dp, bottom = 16.dp)
        )
        EditNumberField(
            leadingIcon = R.drawable.bill,
            label = stringResource(id = R.string.bill_amount),
            value = amountInput,
            onValueChange = {amountInput = it},
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            leadingIcon = R.drawable.percentage,
            label = stringResource(R.string.tip_percentage),
            value = tipInput,
            onValueChange = {tipInput = it},
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTip(checked = switchInput, onCheckedChange = { switchInput = it }, modifier = Modifier)
        Text(
            text = stringResource(R.string.tip_ammount,tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(@DrawableRes leadingIcon:Int,label:String,value: String,onValueChange : (String) -> Unit,keyboardOptions: KeyboardOptions,modifier: Modifier = Modifier){

    TextField(
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), contentDescription = null,Modifier.size(20.dp)) },
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier,
        singleLine = true,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun RoundTip(checked:Boolean,onCheckedChange: (Boolean)->Unit,modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.round_up_tip)
        )
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

private fun calculateTip(amount : Double,roundUp:Boolean,tipPercentage: Double = 15.0) : String{
    var tip = tipPercentage / 100*amount
    if (roundUp){
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App4_TipCalculatorTheme {
        TipApp()
    }
}
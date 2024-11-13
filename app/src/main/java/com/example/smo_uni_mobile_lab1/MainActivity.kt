package com.example.smo_uni_mobile_lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.smo_uni_mobile_lab1.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    lateinit private var viewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider(this).get(CountViewModel::class.java)

        setContent {
            MyTheme {
                MyContent("Abobus", viewModel)
            }
        }
    }
}

@Composable
fun MyContent(name: String, viewModel: CountViewModel) {
    val count by viewModel.count.observeAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.greeting, name),
                fontSize = 46.sp
            )
            Text(
                text = stringResource(id = R.string.count, count!!),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Button(onClick = { viewModel.increaseCount() } ) {
                Text(text = stringResource(id = R.string.increase_count))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTheme {
        MyContent("Android", CountViewModel())
    }
}
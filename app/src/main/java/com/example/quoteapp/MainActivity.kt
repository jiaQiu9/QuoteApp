package com.example.quoteapp

import android.graphics.fonts.FontStyle
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("")
                            }
                        )
                    }
                    ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ){
                        quote()
                    }

                }
            }
        }
    }
}

@Composable
fun quote(){
    fun randnum(from:Int, to:Int):Int{
        return (from..to).random();
    }
    var quotes = arrayOf("It takes courage to grow up and become who you really are. -  E.E. Cummings",
        "Your self-worth is determined by you. You don't have to depend on someone telling you who you are. - Beyoncé",
        "Nothing is impossible. The word itself says 'I'm possible! - Audrey Hepburn",
        "Keep your face always toward the sunshine, and shadows will fall behind you.- Walt Whitman",
        "Attitude is a little thing that makes a big difference. - Winston Churchill",
        "All our dreams can come true, if we have the courage to pursue them. - Walt Disney")
    var randomNumber by remember { mutableStateOf(0) }
    var temp = 0

    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,){
        Row(){
            Text(quotes[randomNumber], color= Color.Black, fontSize=20.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
        }
        Row(){
            Button(
                onClick = {
                    temp=randnum(0,quotes.size-1)
                    while (temp == randomNumber){
                        temp=randnum(0,quotes.size-1)
                    }
                    randomNumber = temp
                }
            ) {
                Text("Press")
            }
        }

    }





}




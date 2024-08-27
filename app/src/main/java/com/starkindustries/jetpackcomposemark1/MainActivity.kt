package com.starkindustries.jetpackcomposemark1
import android.graphics.ColorFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.jetpackcomposemark1.ui.theme.JetPackComposeMark1Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

// Text compose
@Composable
fun TextCompose(name: String) {
    Text(
        text = "I am $name",
        fontFamily = FontFamily.Monospace,
        fontSize = 20.sp,
        fontWeight = FontWeight.W100,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth() // Ensures the Text takes up the full width and centers its content
    )
}

// Image compose
@Composable
fun ImageCompose(){
    Image(painter = painterResource(id = R.drawable.batman),
        contentDescription = "I am Batman",
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Red),
        contentScale = ContentScale.Crop)
}

// Button compose
@Composable
fun ButtonCompose(){
    Button(onClick = {
        Log.d("Tag","I am Ironman")
    }
    , colors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = Color.Gray
    ),
        enabled = true
    ) {
        ImageCompose()
        TextCompose(name = "Ironman")
    }
}

// Textfield compose
@Composable
fun SimpleTextField() {
    val textState = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = { newText ->
            textState.value = newText
        },
        label = { Text(text = "Enter text") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
@Composable
fun TextFiledCompose(){
    val state = remember{
        mutableStateOf("")
    }
    TextField(value = state.value,
        onValueChange = {
            state.value=it
    },
        label = { Text(text = "Please enter your name.")})
}

// Preview Function
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreViewFunction(){
    TextFiledCompose()
}



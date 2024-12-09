package com.example.emma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emma.ui.theme.EmmaTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EmmaTheme {
                var currentColorIndex = remember { mutableStateOf(0) }
                val colorList = listOf(
                    Color(0xff95fe95),
                    Color(0xfffdca0f),
                    Color(0xfffea4a4),
                    Color(0xffa5dfed)
                )

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorList[currentColorIndex.value])
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures { _, dragAmount ->
                                if (dragAmount > 0) {
                                    // 向右滑
                                    if (currentColorIndex.value < colorList.size - 1) {
                                        currentColorIndex.value += 1
                                    }
                                } else if (dragAmount < 0) {
                                    // 向左滑
                                    if (currentColorIndex.value > 0) {
                                        currentColorIndex.value -= 1
                                    }
                                }
                            }
                        }
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Text(text = "2024期末上機考(資管二B黃紫凌)", modifier = Modifier.padding(16.dp))


                        val imageResId = if (isClassA()) R.drawable.class_a else R.drawable.class_b
                        Image(painter = painterResource(id = imageResId), contentDescription = "班級圖片")


                        Text(text = "遊戲持續時間 0 秒", modifier = Modifier.padding(16.dp))


                        Text(text = "您的成績 0 分", modifier = Modifier.padding(16.dp))


                        val context = LocalContext.current
                        Button(onClick = {}, modifier = Modifier.padding(16.dp)) {
                            Text(text = "結束App")
                        }
                    }
                }
            }
        }
    }
    private fun isClassA(): Boolean {
        return true //
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmmaTheme {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "2024期末上機考(資管四A楊子青)", modifier = Modifier.padding(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.class_a),
                        contentDescription = "班級圖片"
                    )
                    Text(text = "遊戲持續時間 0 秒", modifier = Modifier.padding(16.dp))
                    Text(text = "您的成績 0 分", modifier = Modifier.padding(16.dp))
                    Button(onClick = { }, modifier = Modifier.padding(16.dp)) {
                        Text(text = "結束App")
                    }
                }
            }
        }

package com.example.emma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xff95fe95)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // 顯示文字
                        Text(text = "2024期末上機考(資管四A楊子青)", modifier = Modifier.padding(16.dp))

                        // 顯示圖片，根據班級來選擇圖片
                        val imageResId = if (isClassA()) R.drawable.class_a else R.drawable.class_b
                        Image(painter = painterResource(id = imageResId), contentDescription = "班級圖片")

                        // 顯示遊戲持續時間
                        Text(text = "遊戲持續時間 0 秒", modifier = Modifier.padding(16.dp))

                        // 顯示成績
                        Text(text = "您的成績 0 分", modifier = Modifier.padding(16.dp))

                        // 結束App的按鈕
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
        // 可以根據你的需要來設置這個方法的邏輯
        return true // 假設是A班
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmmaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xff95fe95)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "2024期末上機考(資管四A楊子青)", modifier = Modifier.padding(16.dp))
                Image(painter = painterResource(id = R.drawable.class_a), contentDescription = "班級圖片")
                Text(text = "遊戲持續時間 0 秒", modifier = Modifier.padding(16.dp))
                Text(text = "您的成績 0 分", modifier = Modifier.padding(16.dp))
                Button(onClick = { /* 在此處放置結束App的邏輯 */ }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "結束App")
                }
            }
        }
    }
}
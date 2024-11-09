package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NameCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        role = "Web Application Engineer",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,role: String, modifier: Modifier = Modifier) {
    val iconImage = painterResource(R.drawable.google_icon);
    val iconImageModifier = Modifier
        .size(180.dp)
    val appThemeColor = Color(0xFFE0F7FA);
    Surface( // 背景を設定する
        modifier = Modifier.fillMaxSize(),
        color = appThemeColor
    ){
        Box( // 背景の上でコンポーネントを配置する
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column( //全体のコンポーネントを行で並べて表示する
                verticalArrangement = Arrangement.Center, //縦方向に中央寄せ
                horizontalAlignment = Alignment.CenterHorizontally, //横方向を中央で揃える
                modifier = modifier
            )
            {
                Image(//アイコンを表示
                    painter = iconImage,
                    contentDescription = null,
                    contentScale  = ContentScale.Crop,
                    modifier = iconImageModifier

                )
                Text(//名前を表示
                    text = name,
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Serif
                )
                Text(//役割を表示
                    text = role,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )
                }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(60.dp)

            ){
                Row (modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth() //Columnの幅に合わせてRowの幅を広げる
                ){
                    Text(//役割を表示
                        text = "☎",
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.width(20.dp)) //アイコンと文字の間空白
                    Text(//役割を表示
                        text = "000-0000-0000",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Right
                    )
                }

                Row (modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "📧",
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = Modifier.width(20.dp)) //アイコンと文字の間空白
                    Text(//役割を表示
                        text = "harukii1999@gmail.com",
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif
                    )
                }

            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NameCardTheme {
        Greeting(name="Haruki Sugiyama",
            role="Web Application Engineer")
    }
}
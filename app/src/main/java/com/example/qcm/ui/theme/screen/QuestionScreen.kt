package com.example.qcm.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qcm.R
import com.example.qcm.ui.theme.QCMTheme


@Composable
fun Title(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ){
        Box(

            modifier = Modifier
                .background(color = Color.Green)
                .width(300.dp)
                .border(width = 1.dp, color = Color.Black)
                .wrapContentSize(align = Alignment.Center)
                .padding(10.dp)


        ) {
            Text(
                text = "Combien de règles, selon Asiimov, doivent être implémentées dans un Android ? ",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(250.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)

            )
        }
    }

}


@Composable
fun ReponseQuadrant (){
    Column(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ){
            Card("1")
            Spacer(modifier = Modifier.width(10.dp))
            Card("2")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ){
            Card("3")
            Spacer(modifier = Modifier.width(10.dp))
            Card("4")
        }
    }
}


@Composable
fun Card( proposition : String ) {
    Button(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black),

        shape = RoundedCornerShape(0.dp),
        onClick = {

        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .height(100.dp)
                .width(100.dp)
        ) {
            Text(
                text = proposition,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
            )

        }
    }
}

@Composable
fun Reponse(text: String, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .border(width = 1.dp, color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .background(color = color)
                .height(75.dp)
                .width(250.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(
                text = text
            )
        }
    }
}


@Composable
fun Retour (){
    Row (modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
        .border(width = 1.dp, color = Color.Black, RoundedCornerShape(40.dp) )

    ){
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.CenterHorizontally),
            onClick = {}
        ){
            Image(
                painter = painterResource(R.drawable.close),
                contentDescription = "Supprimer le QCM",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
        }
    }
}


@Composable
fun QuestionRender() {
    Column {
        Header(name = "QCM sur les Androids")
        Spacer(modifier = Modifier.height(100.dp))
        Title()
        Spacer(modifier = Modifier.height(50.dp))
        ReponseQuadrant()
    }
}

@Composable
fun BonneReponse(){
    Reponse(text = "Bonne Réponse !", color = Color.Green)
}

@Composable
fun MauvaiseReponse(){
    Column {
        Reponse(text = "Mauvais Réponse", color = Color.Red)
        Spacer(modifier = Modifier.height(50.dp))
        Retour()
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuestionPreview (){
    QCMTheme {
        QuestionRender()
    }
}

@Preview (
    showBackground = true
)
@Composable
fun BonneReponsePreview (){
    QCMTheme {
        BonneReponse()
    }
}

@Preview (
    showBackground = true
)
@Composable
fun MauvaiseReponsePreview (){
    QCMTheme {
        MauvaiseReponse()
    }
}
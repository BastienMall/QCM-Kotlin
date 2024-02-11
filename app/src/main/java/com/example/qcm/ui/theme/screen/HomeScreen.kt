package com.example.qcm.ui.theme.screen

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.qcm.R
import com.example.qcm.ui.theme.QCMTheme


@Composable
fun Header(
    name : String = "QCM"

) {
    Text(
        text = name,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .background(color = Color.Red)
            .wrapContentSize(Alignment.Center)
    )
}



var qcm : MutableList<String> = mutableListOf(
    "QCM sur les plantes",
    "QCM sur les animaux",
    "QCM sur les androids"
)

@Composable
fun ListQCM(tittle: String  ){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)

    ) {


        Button(onClick = {  }) {
            Text(
                text = tittle,
                modifier = Modifier
                    .background(color = Color.Blue)
                    .height(60.dp)
                    .width(200.dp)
                    .wrapContentSize()

            )
        }


        Button(
            onClick = {  qcm.remove(tittle) },
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(width = 2.dp, color = Color.Black)
        ) {
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
fun AllPlants(qcm: MutableList<String>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item(qcm){
            ListQCM(tittle = qcm[0])
            ListQCM(tittle = qcm[1])
            ListQCM(tittle = qcm[2])
        }
    }
}








@Composable
fun HomeRender() {
    Column {
        Header()
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        AllPlants(qcm = qcm)
    }
}




@Preview(showBackground = true)
@Composable
fun HeaderPreview() {

    Header()

}

@Preview(showBackground = true)
@Composable
fun ListQCMPreview() {

    ListQCM(qcm[0])

}

@Preview(showBackground = true)
@Composable
fun Test() {

    AllPlants(qcm = qcm )

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomePagePreview() {
    QCMTheme {
        HomeRender()
    }
}
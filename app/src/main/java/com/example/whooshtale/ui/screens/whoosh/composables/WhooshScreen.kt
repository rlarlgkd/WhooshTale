package com.example.whooshtale.ui.screens.whoosh.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whooshtale.R
import com.example.whooshtale.others.NetworkObserver
import com.example.whooshtale.ui.theme.figeronaFont

@Composable
fun WhooshScreen(navController: NavController, networkStatus: NetworkObserver.Status) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(5)),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(R.drawable.ic_wand),
                contentDescription = null
            )
        }
        Text(
            text = stringResource(R.string.flick_wand),
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 30.sp,
            fontFamily = figeronaFont,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,

            )
        Spacer(modifier = Modifier.weight(1f))

    }

}


package com.example.whooshtale.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whooshtale.data.Story
import com.example.whooshtale.data.Topic

@Composable
fun TagCard(
    tags: Set<Topic>
){
    val tagStrings = tags.map {it.name}

    LazyRow(
    ){
        items(tagStrings){tagString ->
            Card(
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),

            ) {
                Text(
                    text = tagString
                )
            }
        }
    }


}
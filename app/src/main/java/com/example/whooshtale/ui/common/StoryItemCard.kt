package com.example.whooshtale.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whooshtale.data.Topic
import com.example.whooshtale.ui.theme.figeronaFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryItemCard(
    title: String,
    subjects: String,
    image: Int,
    tag: Set<Topic>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(165.dp)
            .fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                2.dp
            )
        ),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            val imageBackground = if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp)
            }
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(imageBackground)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = title,
                    modifier = Modifier
                        .padding(
                            start = 12.dp, end = 8.dp
                        )
                        .fillMaxWidth(),
                    fontStyle = MaterialTheme.typography.headlineMedium.fontStyle,
                    fontSize = 18.sp,
                    fontFamily = figeronaFont,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                Text(
                    text = subjects,
                    modifier = Modifier.padding(start = 12.dp, end = 8.dp, bottom = 2.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontStyle = MaterialTheme.typography.bodySmall.fontStyle,
                    fontFamily = figeronaFont,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                TagCard(tags = tag)
            }
        }
    }
}
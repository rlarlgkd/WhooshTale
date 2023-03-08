package com.example.whooshtale.ui.screens.library.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whooshtale.data.Story
import com.example.whooshtale.data.stories
import com.example.whooshtale.navigation.Screens
import com.example.whooshtale.others.NetworkObserver
import com.example.whooshtale.ui.theme.pacificoFont
import com.example.whooshtale.R


@Composable
fun StoryDetailScreen(
    storyId: String, navController: NavController, networkStatus: NetworkObserver.Status
){
    var story: Story? = stories.find{item -> item.StoryId == storyId.toInt()}
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            StoryDetailTopBar(storyTitle = story?.title, onBackClicked = {
                navController.navigateUp()
            }, onFavClicked = {})

            if (story?.imageResourceId != null) {

                Image(
                    painter = painterResource(id = story.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f )
                        .background(color = Color.Green)
                        .padding(0.dp)
                )
                Text(
                    text = "This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.This is some example text that takes up two thirds of the screen width.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)

                )
            }
        }
    }
}

@Composable
fun StoryDetailTopBar(    storyTitle: Int?, onBackClicked: () -> Unit,
                          onFavClicked: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier
            .padding(22.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp))
            .clickable { onBackClicked() }) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(14.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        if (storyTitle != null) {
            Text(
                text = stringResource(id = storyTitle),
                modifier = Modifier.padding(bottom = 2.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontStyle = MaterialTheme.typography.headlineMedium.fontStyle,
                fontFamily = pacificoFont,
                fontSize = 22.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier
            .padding(22.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp))
            .clickable { onFavClicked() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_nav_favorites),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(14.dp)
            )
        }
    }
}
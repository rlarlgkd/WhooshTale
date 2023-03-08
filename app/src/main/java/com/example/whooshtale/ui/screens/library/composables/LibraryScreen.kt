package com.example.whooshtale.ui.screens.library.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.whooshtale.R
import com.example.whooshtale.data.Story
import com.example.whooshtale.data.Topic
import com.example.whooshtale.data.stories
import com.example.whooshtale.data.topicList
import com.example.whooshtale.navigation.Screens
import com.example.whooshtale.ui.common.CustomTopAppBar
import com.example.whooshtale.ui.common.StoryItemCard
import com.example.whooshtale.ui.common.TagCard

@Composable
fun LibraryScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CustomTopAppBar(
            headerText = stringResource(R.string.library_header),
            icon = R.drawable.ic_nav_library
        )
        TagCard(tags = topicList)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 8.dp, end = 8.dp)
        ){
            items(stories){story ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(), contentAlignment = Alignment.Center
                ){
                    StoryItemCard(title = stringResource(id = story.title),
                        subjects = stringResource(id = story.content),
                        image = story.imageResourceId,
                        tag = story.tag
                    ) {
                        navController.navigate(Screens.StoryDetailScreen.withBookId(story.StoryId.toString()))

                    }
                }


            }
        }
    }
}
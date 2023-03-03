package com.example.whooshtale.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.whooshtale.R

enum class Topic{
    Comedy, Princess, Fairy, Animal, Dragon, Philosophy
}

val topicList = setOf<Topic>(Topic.Princess, Topic.Comedy, Topic.Philosophy,
    Topic.Dragon, Topic.Fairy, Topic.Animal
)

data class Story(
    val StoryId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    @StringRes val content: Int,
    val tag: Set<Topic>
)

val stories = listOf<Story>(
    Story(1, R.drawable.image_1,R.string.story_title_1,R.string.story_content_1,setOf(Topic.Animal, Topic.Dragon)),
    Story(2, R.drawable.image_2,R.string.story_title_2,R.string.story_content_2,setOf(Topic.Fairy, Topic.Comedy)),
    Story(3, R.drawable.image_3,R.string.story_title_3,R.string.story_content_3,setOf(Topic.Philosophy, Topic.Dragon)),
    Story(4, R.drawable.image_4,R.string.story_title_4,R.string.story_content_4,setOf(Topic.Animal, Topic.Dragon,Topic.Princess)),
    Story(5, R.drawable.image_5,R.string.story_title_5,R.string.story_content_5,setOf(Topic.Animal, Topic.Dragon, Topic.Comedy)),
    Story(6, R.drawable.image_6,R.string.story_title_6,R.string.story_content_6,setOf(Topic.Princess, Topic.Dragon)),
)
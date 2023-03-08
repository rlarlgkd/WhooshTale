package com.example.whooshtale.navigation
const val STORY_ID_ARG_KEY = "bookId"

sealed class Screens (val route: String){

    object StoryDetailScreen : Screens("story_detail_screen/{$STORY_ID_ARG_KEY}") {
        fun withBookId(id: String): String {
            return this.route.replace("{$STORY_ID_ARG_KEY}", id)
        }
    }
}
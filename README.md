# WhooshTale
WhooshTale app generates one story per day using OPENAI API.


## Usage
WhooshTale is consists of 4 different bottom bar
1. Whoosh! : This is the first tab that pops up when the app starts.
When a user click the wand icon at the middle.
2. Favorites : This is the tab where a user stores stories he likes
3. Library : This is the tab that shows all the stories came out since his subscription date
4. Settings : This is the settings tab user can change display themes, or subscribe the app



## Database
Here's the potential database for this app
<br/>
![WhooshTaleDBDiagram drawio](https://user-images.githubusercontent.com/33505398/222876739-5e2e50fd-d846-456f-87b4-b1e8ffa8de72.svg)
### User
* user_id: Unique id for user
* name : name of the user
* password : password of the user
* subscription_date : This is the date when user subscribed the app.
This attribute is nullable. Default value is null. 
If user did not subscribe the app(subscription_date == null), 
the user doesn't have access to Library and Favorites
* daily_story : Default value is false. Once the user clicks the wand from "Whoosh!" tab,
the value becomes true. When this attribute is true, the "Whoosh" tab shows the
"Story of the Day" instead of the wand. "daily_story" attribute resets to false every 24 hours.
### Favorites
Contains user id and story id. "Favorites" tab from the app shows all the stories
with the given "user_id".

### Story
* story_id : Unique id for story
* title : Title for each story. Doesn't have to be unique.
* cover_image : It's cover image for story.
* content : Each story is consist of up to 500 words
* date : Released date of the Story. If the released date is equal to current date,
the story is the "Story of the Day"
* fav_count : Represent how many people likes the story. The default value is 0.
### Topics
Each story has 1 or more topic. Topic element is consists of data type of 
"TOPIC"

### TOPIC
TOPIC is enumeration class that represents topic of stories.

## API
Currently, I am using com.example.whooshtale -> data -> Story.kt file to store
dummy data and test the app.
<br/>
Plan is to put api file in api folder, which is currently empty.
<br/>
Here is a list of potential APIs this app needs
1. List of all the stories ever since the current user's subscription date.
2. List of all the stories the current user clicked as "Favorites"
3. List of all the stories with the tags that the current user choose
4. List of all the stories with the title that the current user searched
5. Top 20 stories with most "fav_count"
6. current user's "daily_story" value in Boolean
7. Today's Story

## ISSUES
The way story is generated is by combining one lesson and one topic.
<br/>
some possible options of choosing tag for each story:
1. Simply pick the topic parameter that was used to generate a story.
* issue1 : there are 50 kinds of topic. This could increase. Therefore, it will be harder for users to scroll through tags? 
* issue2 : there is only one topic parameter for one story. This means each story can have one tag and one tag only.
2. Fine-tune the OpenAI API so that chatGPT will analyze the story and then provide up to 5 topic out of 15 topic list.
* issue1 : It is harder than way 1
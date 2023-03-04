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
<<image>>

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
### Topics
Each story have 1 or more topic. Topic element is consists of data type of 
"TOPIC"

### TOPIC
TOPIC is enumeration class that represents topic of stories.

## API


## ISSUES
The way story is generated is by combining one lesson and one topic.
<br/>
some possible options of choosing tag for each story:
1. Simply pick the topic parameter that was used to generate a story.
* issue1 : there are 50 kinds of topic. This could increase. Therefore, it will be harder for users to scroll through tags? 
* issue2 : there is only one topic parameter for one story. This means each story can have one tag and one tag only.
2. Fine-tune the OpenAI API so that chatGPT will analyze the story and then provide up to 3~5 topic out of 10~15 topic list.
* issue1 : It is harder than way 1
# IMDB Rating.Bot
[![Build Status](https://travis-ci.org/DrawersApp/Java-Bot.svg?branch=master)](https://travis-ci.org/DrawersApp/Java-Bot)

It is using Smack client to connect to Drawers. This is BOT returns Movie/Series information like plot, genre, actors,etc along with the IMDB rating. Will help to quickly decide which movie to watch next.

This BOT is powered By OMDb API (http://www.omdbapi.com/).


### Step to use.
```
1. Register on Drawer's site for bot credentials.
2. Update credentials in BotCredentials.java file.
3. Run mvn clean install package in terminal/command prompt (Maven Required).
4. Go to target and run the fat jar using java -jar (JRE Required). 
```

## Usage

```
1. Open Drawer's App and send message to Bot's Number obtained after registration.
2. Send "help" without quotes to know about usage.
3. To get movie information send "movie movie-name" eg. "movie star wars
4. To get series information send  "series series-name s#(optional) e#(optional)" eg. "series friends s01 e01"
```

##### Note: Send your query without quotes or any other special character.

### Links
[Drawers Official Website](http://wantdrawers.in/)
[Drawers Github Project](https://github.com/DrawersApp/)

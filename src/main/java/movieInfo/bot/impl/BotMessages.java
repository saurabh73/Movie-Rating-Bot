package movieInfo.bot.impl;

public interface BotMessages {
	
	final String EMPTY_BODY = "Blank Message.\nPlese send \"help\" without quotes to know usage.";
	
	final String DEFAULT_ERROR = "Something went wrong. Try again later";

	final String HELP_MESSAGE = "Hello User!"
								+ "\n1. To get movie information send \"movie movie-name\" eg. \"movie star wars\""
								+ "\n2. To get series information send  \"series series-name s#(optional) e#(optional)\" eg. \"series friends s01 e01\""
								+ "\nNote: Send your query without quotes or any other special character.";
	
	final String QUERY_NOT_FOUND = "Unsupported query.\nPlese send \"help\" without quotes to know usage.";
	

	final String SERVER_ERROR = "API not responding. Please try again later.";

	final String MOVIE_NOT_FOUND = " not found in our Movie Database. \nPlease check search term or send \"help\" to know about usage.";

	final String SERIES_NOT_FOUND = " not found in our Series Database. \nPlease check search term, season/episode number or send \"help\" to know about usage.";
	
	

}

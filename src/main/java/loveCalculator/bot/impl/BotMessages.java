package loveCalculator.bot.impl;

public interface BotMessages {
	
	final String EMPTY_BODY = "Blank Message.\nPlese send \"help\" without quotes to know usage.";
	
	final String DEFAULT_ERROR = "Something went wrong. Try again later";

	final String HELP_MESSAGE = "Hello User!"
								+ "\n1. To know about love compatibility send \"love your-name partner-name\""
								+ "\n2. To play flames send  \"flames your-name partner-name\""
								+ "\nNote: Send your query without quotes or any other special character.";
	
	final String QUERY_NOT_FOUND = "Unsupported query.\nPlese send \"help\" without quotes to know usage.";
	
	final String UNSUFFICIENT_PARAMETERS = "Names missing. Unable to caluclate love compatibilty.\nPlese send \"help\" without quotes to know usage.";
	
	final String INVALID_FIRST_NAME = "Please check your name.\nOnly english characters are supported. Remove special charachters (if any)";
	
	final String INVALID_LAST_NAME= "Please check your partner's name.\nOnly english characters are supported. Remove special charachters (if any)";

	final String SERVER_ERROR = "API not responding. Please try again later.";
	
	

}

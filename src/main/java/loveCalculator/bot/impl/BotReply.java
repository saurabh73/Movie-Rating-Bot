package loveCalculator.bot.impl;

import java.net.URLEncoder;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import loveCalculator.bot.Bot;
import loveCalculator.bot.utils.Flames;
import loveCalculator.bot.utils.LoveCalucatorApi;

/**
 * @author saurabh dutta
 * Class to generate bot reply
 *
 */
public class BotReply {
	
	private String firstName;
	private String secondName;
	private QueryType query;
	
	public Integer validateInput(String inputString){
		
		String[] userInputs = inputString.split(" ");
		final String NAME_REGEX = "^[a-zA-Z]+";
		
		if(userInputs.length>=1){
			String userQuery = userInputs[0];
			
			if(userQuery.equals(QueryType.help.name())){
				return 1;
			} else if(userQuery.equals(QueryType.love.name()) || userQuery.equals(QueryType.flames.name())) {
				if(userInputs.length<3){
					return -3;
				} else {
					this.query = userQuery.equals(QueryType.love.name())? QueryType.love : QueryType.flames;
					this.firstName = userInputs[1];
					this.secondName = userInputs[2];
					
					if(!firstName.matches(NAME_REGEX)){
						return -4;
					}
					else if(!secondName.matches(NAME_REGEX)){
						return -5;
					}	
					return 2;

				}
	
			}
			
		}
		return -1;
		
	}
	
	public static String getBotReply(String message){
		BotReply bR = new BotReply();
		Integer validationCode = bR.validateInput(message);
		switch(validationCode){
			// Valid Messages
			case 1: return BotMessages.HELP_MESSAGE;
			case 2: return bR.getResponse();
			
			//Error Messages
			case -1: return BotMessages.EMPTY_BODY;
			case -2: return BotMessages.QUERY_NOT_FOUND;
				
			case -3: return BotMessages.UNSUFFICIENT_PARAMETERS;
				
			case -4: return BotMessages.INVALID_FIRST_NAME;
			
			case -5: return BotMessages.INVALID_LAST_NAME;
			
			default : return BotMessages.DEFAULT_ERROR;

		}
	}
	
	 private String getResponse() {
		if(query.equals(QueryType.love)){
			return LoveCalucatorApi.getResult(this.firstName,this.secondName);
			
		} else if(query.equals(QueryType.flames)){
			return Flames.getResult(this.firstName,this.secondName);
		}		
		return BotMessages.DEFAULT_ERROR;
	}



}

package loveCalculator.bot.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import loveCalculator.bot.Bot;
import loveCalculator.bot.impl.BotCredentials;
import loveCalculator.bot.impl.BotMessages;

public class LoveCalucatorApi {
	
	private final static String apiURL = "https://love-calculator.p.mashape.com/getPercentage";
	
	public static String getResult(String firstName, String secondName) {
		String responseMessage = BotMessages.DEFAULT_ERROR;
		try {
			String finalUrl = apiURL+"?fname="+firstName+"&sname="+secondName;
			System.out.println(finalUrl);
			HttpResponse<JsonNode> response = Unirest.get(finalUrl)
					.header("X-Mashape-Key", BotCredentials.MASHAPE_KEY)
					.header("Accept", "application/json")
					.asJson();
			
			if(response.getStatus()==200){
				JSONObject obj= response.getBody().getObject();
				responseMessage= "Love compatiblity between "+firstName+" and "+secondName+" is "+obj.getString("percentage")+"%.\n"+obj.getString("result");
			} else {
				responseMessage = BotMessages.SERVER_ERROR;
			}
			responseMessage=URLEncoder.encode(responseMessage, "UTF-8");
			return responseMessage;
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return responseMessage;
		
	}


}

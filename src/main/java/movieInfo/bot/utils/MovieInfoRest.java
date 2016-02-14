package movieInfo.bot.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import movieInfo.bot.impl.BotMessages;
import movieInfo.bot.impl.BotReply;
import movieInfo.bot.impl.QueryType;

public class MovieInfoRest {
	
	private final static  String BASE_URL = "http://www.omdbapi.com/?plot=full&";

	public static String getResponse(BotReply bR) {
		
		try {
			String apiUrl = buildUrl(bR);
			System.out.println(apiUrl);
			HttpResponse<JsonNode> response = Unirest.get(apiUrl)
					.header("Accept", "application/json")
					.asJson();
			
			if(response.getStatus()==200){
				JSONObject obj= response.getBody().getObject();
				if(obj.getString("Response").equalsIgnoreCase("True")){
					return ResponseParser.parseResponse(obj,bR);
					
				} else{
					if(bR.getQuery().equals(QueryType.movie)){
						return bR.getTitle()+BotMessages.MOVIE_NOT_FOUND;
					} else {
						return bR.getTitle()+BotMessages.SERIES_NOT_FOUND;
					}
				}
				
				
			}
			return BotMessages.SERVER_ERROR;
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return BotMessages.DEFAULT_ERROR;
	}

	private static String buildUrl(BotReply bR) {
		StringBuffer urlBuilder = new StringBuffer(BASE_URL);
		try {
			
			urlBuilder.append("t="+URLEncoder.encode(bR.getTitle().trim(),"UTF-8"));
		
			urlBuilder.append("&");
			urlBuilder.append("type="+bR.getQuery().name());
			if(bR.getSeasonNum()!=null){
				urlBuilder.append("&");
				urlBuilder.append("Season="+bR.getSeasonNum());
			}
			if(bR.getEpisodeNumber()!=null){
				urlBuilder.append("&");
				urlBuilder.append("Episode="+bR.getEpisodeNumber());
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlBuilder.toString();
	}

}

package movieInfo.bot.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import movieInfo.bot.impl.BotReply;
import movieInfo.bot.impl.QueryType;
import movieInfo.bot.model.EpisodeInfoModel;
import movieInfo.bot.model.MovieInfoModel;
import movieInfo.bot.model.SeasonInfoModel;

public class ResponseParser {

	public static String parseResponse(JSONObject obj, BotReply bR) {
		
		StringBuffer reply = new StringBuffer("");
		
		if(bR.getSeasonNum()!=null && bR.getEpisodeNumber()==null){
			
			SeasonInfoModel seasonInfo = parseJsonToSeasonModel(obj);
			reply.append(putStringValue(seasonInfo.getTitle(),""));
			reply.append(putStringValue(seasonInfo.getSeason(),"Season"));
			reply.append("Episodes\n");
			
			for(EpisodeInfoModel infoModel:seasonInfo.getEpisode()){
				reply.append("\t"+putStringValue(infoModel.getTitle(), "Episode "+infoModel.getEpisodeNumber()));				
				reply.append("\t"+putStringValue(infoModel.getImdbRating(), "IMDB Rating"));
				reply.append("\t"+putStringValue(infoModel.getReleaseDate(), "Release Date"));
				reply.append("\n");
			}
			
		} else {
			
			MovieInfoModel movieModel = parseJsonToMovieModel(obj,bR.getQuery().equals(QueryType.series));
			
			reply.append(putStringValue(movieModel.getTitle(), ""));
			reply.append(putStringValue(movieModel.getImdbRating(), "IMDB Rating"));
			reply.append(putStringValue(movieModel.getSeason(),"Season"));
			reply.append(putStringValue(movieModel.getEpisode(),"Episode"));
			reply.append(putStringValue(movieModel.getYear(), "Year"));
			reply.append(putStringValue(movieModel.getGenre(), "Genre"));
			reply.append(putStringValue(movieModel.getLanguage(),"Language"));
			reply.append(putStringValue(movieModel.getDirector(), "Director"));
			reply.append(putStringValue(movieModel.getActors(), "Actors"));
			reply.append(putStringValue(movieModel.getPosterUrl(), "Poster URL"));
			reply.append(putStringValue(movieModel.getPlot(),"Plot"));
			
		} 

		return reply.toString();
	}
	
	private static String putStringValue(String fieldValue, String fieldTitle) {
		if(fieldValue.equalsIgnoreCase("N/A")){
			return "";
		}
		else{
			return fieldTitle.trim()+(fieldTitle.trim()!=""?": ":"")+fieldValue.trim()+"\n";
		}
	}

	private static String getStringValue(JSONObject obj,String key){
		try{
			return obj.getString(key)!=null?obj.getString(key):"N/A";
		} catch(Exception ex){
			ex.getMessage();
		}
		return "N/A";
		
	}
	
	

	private static SeasonInfoModel parseJsonToSeasonModel(JSONObject obj) {
		SeasonInfoModel seasonModel = new SeasonInfoModel();
		seasonModel.setTitle(getStringValue(obj, "Title"));
		seasonModel.setSeason(getStringValue(obj, "Season"));
		
		JSONArray episodeArray = obj.getJSONArray("Episodes");
		
		seasonModel.setEpisode(getEpisodeList(episodeArray));
		
		return seasonModel;
	}

	private static List<EpisodeInfoModel> getEpisodeList(JSONArray episodeArray) {
		List<EpisodeInfoModel> episodeList = new ArrayList<EpisodeInfoModel>(episodeArray.length());
		for(int i=0;i<episodeArray.length();i++){
			JSONObject obj = episodeArray.getJSONObject(i);
			EpisodeInfoModel model = new EpisodeInfoModel();
			model.setEpisodeNumber(getStringValue(obj, "Episode"));
			model.setTitle(getStringValue(obj, "Title"));
			model.setImdbRating(getStringValue(obj, "imdbRating"));
			model.setReleaseDate(getStringValue(obj, "Released"));
			episodeList.add(model);
			
		}
		return episodeList;
	}

	private static MovieInfoModel parseJsonToMovieModel(JSONObject obj, boolean isSeason) {
		MovieInfoModel movieModel = new MovieInfoModel();
		movieModel.setTitle(getStringValue(obj, "Title"));
		movieModel.setYear(getStringValue(obj, "Year"));
		movieModel.setActors(getStringValue(obj, "Actors"));
		movieModel.setDirector(getStringValue(obj,"Director"));
		movieModel.setGenre(getStringValue(obj, "Genre"));
		movieModel.setLanguage(getStringValue(obj, "Language"));
		movieModel.setPlot(getStringValue(obj, "Plot"));
		movieModel.setImdbRating(getStringValue(obj, "imdbRating"));
		movieModel.setPosterUrl(getStringValue(obj, "Poster"));
		if(isSeason){
			movieModel.setSeason(getStringValue(obj,"Season"));
			movieModel.setEpisode(getStringValue(obj,"Episode"));
		}
		return movieModel;
	}

	

}

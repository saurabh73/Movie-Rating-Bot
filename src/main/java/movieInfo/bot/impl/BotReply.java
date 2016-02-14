package movieInfo.bot.impl;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import movieInfo.bot.Bot;
import movieInfo.bot.utils.MovieInfoRest;

/**
 * @author Saurabh dutta
 * Class to generate bot reply
 *
 */
public class BotReply {
	
	private QueryType query;
	
	private String title;
	
	private String seasonNum;
	
	private String epsisodeNum;
	
	public BotReply() {
		this.seasonNum = null;
		this.episodeNumber = null;
	}

	public String getSeasonNum() {
		return seasonNum;
	}


	public void setSeasonNum(String seasonNum) {
		this.seasonNum = seasonNum;
	}


	public String getEpsisodeNum() {
		return epsisodeNum;
	}


	public void setEpsisodeNum(String epsisodeNum) {
		this.epsisodeNum = epsisodeNum;
	}


	public String getEpisodeNumber() {
		return episodeNumber;
	}


	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
	}


	private String episodeNumber;
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public QueryType getQuery() {
		return query;
	}


	public void setQuery(QueryType query) {
		this.query = query;
	}


	public static String getBotReply(String body) throws UnsupportedEncodingException {
			
		String queryType = body.substring(0,body.indexOf(" ")!=-1?body.indexOf(" "):body.length());
		BotReply bR = new BotReply();
		
		if(bR.parseInput(queryType,body)){
			
			if(bR.query.equals(QueryType.help)){
				return BotMessages.HELP_MESSAGE;
			}

			return URLEncoder.encode(MovieInfoRest.getResponse(bR),"UTF-8");
			
		};

		return BotMessages.QUERY_NOT_FOUND;
	}


	private boolean parseInput(String queryType, String body) {
		if(isQuerySupported(queryType)){
			String parameters = body.substring(body.indexOf(" ")+1);
			if(getQuery().equals(QueryType.help)){
				return true;
			}
			else if(getQuery().equals(QueryType.movie)){
				setTitle(parameters);
			} else {
				String inputs[] = parameters.split(" ");
				String title = "";
				
				for(String inp:inputs){
					if(inp.matches("s[0-9]+")){
						setSeasonNum(inp.substring(1));
						
					} else if(inp.matches("e[0-9]+")){
						setEpisodeNumber(inp.substring(1));
					} else{
						title+=" "+inp;
					}
				}
				setTitle(title);
			}
			return true;
		}
		return false;
		
	}

	private boolean isQuerySupported(String queryType) {
		switch (queryType) {
		case "help": 
			setQuery(QueryType.help);
			return true;
		case "movie": 
			setQuery(QueryType.movie);
		 	return true;
		case "series":
			setQuery(QueryType.series);
			return true;

		default:
			break;
		}
		return false;
	}
	
	
	



}

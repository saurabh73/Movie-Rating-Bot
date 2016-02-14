package movieInfo.bot.model;

import java.util.List;

public class SeasonInfoModel {
	
	private String title;
	private String season;
	private List<EpisodeInfoModel> episode;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public List<EpisodeInfoModel> getEpisode() {
		return episode;
	}
	public void setEpisode(List<EpisodeInfoModel> episode) {
		this.episode = episode;
	}
	
	
}

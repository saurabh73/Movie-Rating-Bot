package movieInfo.bot.model;

public class MovieInfoModel {
	
	private String title;
	private String year;
	private String genre;
	private String imdbRating;
	private String language;
	private String director;
	private String actors;
	private String plot;
	private String episode;
	private String season;
	private String posterUrl;
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public MovieInfoModel() {
		this.title="N/A";
		this.actors="N/A";
		this.director="N/A";
		this.episode="N/A";
		this.genre="N/A";
		this.imdbRating="N/A";
		this.language="N/A";
		this.plot="N/A";
		this.posterUrl="N/A";
		this.season="N/A";
		this.year="N/A";
	}

}

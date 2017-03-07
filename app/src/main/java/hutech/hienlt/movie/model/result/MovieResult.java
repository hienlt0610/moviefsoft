package hutech.hienlt.movie.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class MovieResult {

	@SerializedName("overview")
	@Expose
	private String overview;

	@SerializedName("original_language")
	@Expose
	private String originalLanguage;

	@SerializedName("original_title")
	@Expose
	private String originalTitle;

	@SerializedName("video")
	@Expose
	private boolean video;

	@SerializedName("title")
	@Expose
	private String title;

	@SerializedName("genre_ids")
	@Expose
	private List<Integer> genreIds;

	@SerializedName("poster_path")
	@Expose
	private String posterPath;

	@SerializedName("backdrop_path")
	@Expose
	private String backdropPath;

	@SerializedName("release_date")
	@Expose
	private Date releaseDate;

	@SerializedName("popularity")
	@Expose
	private double popularity;

	@SerializedName("vote_average")
	@Expose
	private double voteAverage;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("adult")
	@Expose
	private boolean adult;

	@SerializedName("vote_count")
	@Expose
	private int voteCount;

	private boolean isFavorite;

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setGenreIds(List<Integer> genreIds){
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setFavorite(boolean favorite){
		this.isFavorite = favorite;
	}

	public boolean isFavorite(){
		return isFavorite;
	}

}
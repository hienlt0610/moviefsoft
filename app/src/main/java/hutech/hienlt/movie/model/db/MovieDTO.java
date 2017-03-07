package hutech.hienlt.movie.model.db;


import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

import java.util.Date;

import hutech.hienlt.movie.model.result.MovieResult;

/**
 * Created by HienLT9 on 3/6/2017.
 */


@Table(name = "favorite")
public class MovieDTO extends SugarRecord {
    @Column(name = "overview")
    public String overview;

    @Column(name = "title")
    public String title;

    @Column(name = "poster_path")
    public String posterPath;

    @Column(name = "release_date")
    public Date releaseDate;

    @Column(name = "vote_average")
    public double voteAverage;

    @Column(name = "_id", unique = true)
    public int id;

    @Column(name = "adult")
    public boolean adult;

    public MovieDTO() {
    }

    public MovieDTO(MovieResult result) {
        this.overview = result.getOverview();
        this.title = result.getTitle();
        this.posterPath = result.getPosterPath();
        this.releaseDate = result.getReleaseDate();
        this.voteAverage = result.getVoteAverage();
        this.id = result.getId();
        this.adult = result.isAdult();
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getMovieId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}

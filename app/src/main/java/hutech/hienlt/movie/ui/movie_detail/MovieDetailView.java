package hutech.hienlt.movie.ui.movie_detail;

import net.grandcentrix.thirtyinch.TiView;

import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.model.result.CastCrewListResult;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public interface MovieDetailView extends TiView {
    public void showMovieDetail(MovieResult movie);

    public void showCasts(CastCrewListResult result);
}

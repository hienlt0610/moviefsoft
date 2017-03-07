package hutech.hienlt.movie.ui.movie;

import net.grandcentrix.thirtyinch.TiView;

import hutech.hienlt.movie.model.result.MovieResultPage;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public interface MovieView extends TiView {
    public void showPopularMovie(MovieResultPage result);
    public void loadMore(MovieResultPage result);
}

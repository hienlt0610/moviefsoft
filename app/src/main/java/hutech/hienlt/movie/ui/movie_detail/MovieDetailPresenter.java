package hutech.hienlt.movie.ui.movie_detail;

import net.grandcentrix.thirtyinch.TiPresenter;

import hutech.hienlt.movie.common.Config;
import hutech.hienlt.movie.common.RestApi;
import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.model.result.CastCrewListResult;
import hutech.hienlt.movie.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class MovieDetailPresenter extends TiPresenter<MovieDetailView> {

    public void showDetail(int movieId){
        ApiService service = RestApi.getInstance().getRetrofit().create(ApiService.class);
        service.getDetail(movieId, Config.API_KEY).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                if(response.isSuccessful())
                    getView().showMovieDetail(response.body());
                else
                    Timber.e(response.message());
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
                Timber.e(t);
                t.printStackTrace();
            }
        });
    }

    public void showListCast(int movieId){
        ApiService service = RestApi.getInstance().getRetrofit().create(ApiService.class);
        service.getCastCrewOfMovie(movieId, Config.API_KEY).enqueue(new Callback<CastCrewListResult>() {
            @Override
            public void onResponse(Call<CastCrewListResult> call, Response<CastCrewListResult> response) {
                if(response.isSuccessful())
                    getView().showCasts(response.body());
                else
                    Timber.e(response.message());
            }

            @Override
            public void onFailure(Call<CastCrewListResult> call, Throwable t) {
                Timber.e(t);
                t.printStackTrace();
            }
        });
    }
}

package hutech.hienlt.movie.ui.movie;

import android.util.Log;

import net.grandcentrix.thirtyinch.TiPresenter;

import java.io.IOException;

import hutech.hienlt.movie.common.Config;
import hutech.hienlt.movie.common.RestApi;
import hutech.hienlt.movie.model.result.MovieResultPage;
import hutech.hienlt.movie.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public class MoviePresenter extends TiPresenter<MovieView> {

    public void showPopularMovie(int page){
        ApiService apiService = RestApi.getInstance().getRetrofit().create(ApiService.class);
        apiService.getPopularMovie(page, Config.API_KEY).enqueue(new Callback<MovieResultPage>() {
            @Override
            public void onResponse(Call<MovieResultPage> call, Response<MovieResultPage> response) {
                if(response.isSuccessful())
                    getView().showPopularMovie(response.body());
                else
                    try {
                        Log.d("hienlt0610", "error: "+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<MovieResultPage> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showMoreMovie(int page){
        ApiService apiService = RestApi.getInstance().getRetrofit().create(ApiService.class);
        apiService.getPopularMovie(page, Config.API_KEY).enqueue(new Callback<MovieResultPage>() {
            @Override
            public void onResponse(Call<MovieResultPage> call, Response<MovieResultPage> response) {
                if(response.isSuccessful())
                    getView().loadMore(response.body());
                else
                    try {
                        //Log.d("hienlt0610", "error: "+response.errorBody().string());
                        Timber.e(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<MovieResultPage> call, Throwable t) {
                Timber.e(t);
                t.printStackTrace();
            }
        });
    }
}

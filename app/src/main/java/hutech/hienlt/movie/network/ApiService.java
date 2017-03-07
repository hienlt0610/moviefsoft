package hutech.hienlt.movie.network;

import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.model.result.CastCrewListResult;
import hutech.hienlt.movie.model.result.MovieResultPage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public interface ApiService {

    @GET("movie/popular")
    Call<MovieResultPage> getPopularMovie(@Query("page") int page, @Query("api_key")String apiKey);

    @GET("movie/{movieId}")
    Call<MovieResult> getDetail(@Path("movieId") int movieId, @Query("api_key")String apiKey);

    @GET("movie/{movieId}/credits")
    Call<CastCrewListResult> getCastCrewOfMovie(@Path("movieId") int movieId, @Query("api_key")String apiKey);
}

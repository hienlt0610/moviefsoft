package hutech.hienlt.movie.common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HienLT9 on 3/2/2017.
 */
public class RestApi {
    private static volatile RestApi _instance;
    private Retrofit retrofit;

    public static RestApi getInstance() {
        if (_instance == null) {
            synchronized (RestApi.class) {
                //double checking Singleton instance
                if (_instance == null) {
                    _instance = new RestApi();
                }
            }
        }
        return _instance;
    }

    private RestApi() {
        buildRetrofit();
    }

    private void buildRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}

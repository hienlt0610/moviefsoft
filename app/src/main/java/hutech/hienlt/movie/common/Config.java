package hutech.hienlt.movie.common;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class Config {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String BASE_IMG_URL = "https://image.tmdb.org/t/p";
    public static final String API_KEY = "e7631ffcb8e766993e5ec0c1f4245f93";

    public static String getImageUrl(String path){
        return BASE_IMG_URL+"/w500"+path;
    }
}

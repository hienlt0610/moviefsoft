package hutech.hienlt.movie.common;

import android.app.Application;

import com.orm.SugarContext;

import timber.log.Timber;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        SugarContext.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}

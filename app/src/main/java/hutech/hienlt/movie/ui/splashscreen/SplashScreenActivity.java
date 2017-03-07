package hutech.hienlt.movie.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import hutech.hienlt.movie.R;
import hutech.hienlt.movie.common.BaseActivity;
import hutech.hienlt.movie.ui.home.MainActivity;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class SplashScreenActivity extends BaseActivity implements Runnable {

    private Handler handler;
    private int timeNavigation = 1000;

    @Override
    public int getResLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        handler.postDelayed(this,timeNavigation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(handler != null){
            handler.removeCallbacks(this);
        }
    }

    @Override
    public void run() {
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        SplashScreenActivity.this.finish();
    }
}

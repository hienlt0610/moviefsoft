package hutech.hienlt.movie.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.mikepenz.iconics.context.IconicsContextWrapper;

import net.grandcentrix.thirtyinch.TiActivity;
import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.TiView;

import butterknife.ButterKnife;
import hutech.hienlt.movie.R;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public abstract class BaseMvpActivity<P extends TiPresenter<V>, V extends TiView> extends TiActivity<P , V> {
    private Toolbar toolbar;
    public abstract int getResLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayoutId());
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            if(getSupportActionBar() != null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    protected Toolbar getToolbar(){
        return toolbar;
    }

    protected void showHomeAsUp(boolean enable){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        }
    }

    protected void setTitle(String title){
        if(title == null || title.length() == 0) return;
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }
}

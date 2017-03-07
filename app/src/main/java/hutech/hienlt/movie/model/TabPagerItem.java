package hutech.hienlt.movie.model;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

/**
 * Created by HienLT9 on 3/3/2017.
 */

public class TabPagerItem {
    private String title;
    private Fragment fragment;
    private Drawable icon;

    public TabPagerItem(Fragment fragment, String title, Drawable icon) {
        this.fragment = fragment;
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}

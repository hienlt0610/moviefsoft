package hutech.hienlt.movie.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import hutech.hienlt.movie.R;
import hutech.hienlt.movie.adapter.HomePagerAdapter;
import hutech.hienlt.movie.common.BaseActivity;
import hutech.hienlt.movie.event.ChangeListStyleEvent;
import hutech.hienlt.movie.model.TabPagerItem;
import hutech.hienlt.movie.ui.movie.MovieFragment;
import hutech.hienlt.movie.util.SystemUtils;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    private HomePagerAdapter adapter;
    private Drawer drawer;


    @Override
    public int getResLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewPagerTab();
        setupNavigationDrawer();
    }

    private void setupNavigationDrawer() {
        View customView = LayoutInflater.from(this).inflate(R.layout.drawer_layout,null);
        customView.setPadding(0, SystemUtils.getStatusBarHeight(this),0,0);
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getToolbar())
                .withCustomView(customView)
                .withDisplayBelowStatusBar(true)
                .withTranslucentStatusBar(false)
                .build();
    }

    private void initViewPagerTab() {
        adapter = new HomePagerAdapter(this, getSupportFragmentManager());

        adapter.addPage(new TabPagerItem(new MovieFragment(),getString(R.string.tab_movies), new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_home).color(Color.WHITE)));
        adapter.addPage(new TabPagerItem(new MovieFragment(),getString(R.string.tab_favorite), new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_favorite).color(Color.WHITE)));
        adapter.addPage(new TabPagerItem(new MovieFragment(),getString(R.string.tab_settings), new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_settings).color(Color.WHITE)));
        adapter.addPage(new TabPagerItem(new MovieFragment(),getString(R.string.tab_about), new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_info).color(Color.WHITE)));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        T a = T.class.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.menu_change_layout);
        item.setIcon(new IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_view_list).actionBar().color(Color.WHITE));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_change_layout:
                EventBus.getDefault().post(new ChangeListStyleEvent());
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen())
        {
            drawer.closeDrawer();
            return;
        }
        super.onBackPressed();
    }
}

package hutech.hienlt.movie.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;

import com.mikepenz.iconics.typeface.IIcon;

import java.util.ArrayList;
import java.util.List;

import hutech.hienlt.movie.model.TabPagerItem;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class HomePagerAdapter extends FragmentPagerAdapter{

    private Context context;
    private List<Fragment> fragmentList;
    private List<String> tabNameList;
    private List<IIcon> tabIconList;
    private List<TabPagerItem> tabPagerItems;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        fragmentList = new ArrayList<>();
        tabNameList = new ArrayList<>();
        tabIconList = new ArrayList<>();
        tabPagerItems = new ArrayList<>();
    }

    public void addPage(String tabName, IIcon icon, Fragment fragment){
        if(tabName == null || TextUtils.isEmpty(tabName) || icon == null || fragment == null) return;
        tabNameList.add(tabName);
        tabIconList.add(icon);
        fragmentList.add(fragment);
    }

    public void addPage(TabPagerItem item){
        tabPagerItems.add(item);
    }

    @Override
    public int getCount() {
        return tabPagerItems.size();
    }

    @Override
    public Fragment getItem(int position) {
        return tabPagerItems.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabPagerItems.get(position).getTitle();
    }

    public void applyTabLayout(TabLayout tabLayout){
        for(int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(tabPagerItems.get(i).getIcon());
        }
    }
}

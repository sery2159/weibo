package com.feige.weibo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import com.feige.weibo.R;
import com.feige.weibo.widget.TabLayoutCustomerTab;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 *
 * 主界面Viewpager适配器
 *
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentsList;
    private Context mContext;
    public MainFragmentPagerAdapter(Context context,FragmentManager fm,List<Fragment> list)
    {
        super(fm);
        fragmentsList = list;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    //自定义View实现TabLayout底栏
    public View getPageView(int position)
    {
        TabLayoutCustomerTab tab = new TabLayoutCustomerTab(mContext);
        switch (position)
        {
            case 0:
                tab.setDate(R.drawable.ic_home_black_24dp,R.string.app_home);
                break;
            case 1:
                tab.setDate(R.drawable.ic_explore_black_24dp,R.string.app_find);
                break;
            case 2:
                tab.setDate(R.drawable.ic_account_circle_black_24dp,R.string.app_mine);
                break;
        }
        return tab;
    }
}

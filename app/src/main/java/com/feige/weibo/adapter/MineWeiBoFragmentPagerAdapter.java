package com.feige.weibo.adapter;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28.
 *
 * 我的界面中ViewPager适配器
 */

public class MineWeiBoFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private Context mContext;
    private FragmentManager fm;

    public MineWeiBoFragmentPagerAdapter(FragmentManager fm, Context mContext,List<Fragment> fragmentList,
                                         List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
        this.mContext = mContext;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

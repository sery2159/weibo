package com.feige.weibo.base;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.feige.weibo.R;
import com.feige.weibo.adapter.MainFragmentPagerAdapter;
import com.feige.weibo.find.FindFragment;
import com.feige.weibo.home.HomeFragment;
import com.feige.weibo.mine.MineFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private ViewPager mainViewpage;
    private TabLayout mainTablayout;

    private MainFragmentPagerAdapter mainAdapter;

    private FragmentManager fm;
    private List<Fragment> fragmentsList;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;

    public enum FGM_ENUM{
        HomeFragment,  //首页
        FindFragment,   //发现
        MineFragment    //我
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

        seupToolbar();
        setupViewPager();
        setupTabLayout();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        mainViewpage = (ViewPager) findViewById(R.id.main_viewpage);
        mainTablayout = (TabLayout) findViewById(R.id.main_tablayout);
    }

    /**
     * 监听事件
     */
    private void initEvent() {
        mainTablayout.setOnTabSelectedListener(this);
    }

    /**
     * 设置toolbar
     */
    private void seupToolbar() {
       // StatusBarUtil.setTranslucent(this);
    }

    private void setupViewPager() {

        fm = getSupportFragmentManager();

        if(null == fragmentsList)
        {
            fragmentsList = new ArrayList<>();
        }
        if(null == homeFragment)
        {
            homeFragment = HomeFragment.newInsance();
            fragmentsList.add(homeFragment);
        }
        if(null == findFragment)
        {
            findFragment = FindFragment.newInstance();
            fragmentsList.add(findFragment);
        }
        if(null == mineFragment)
        {
            mineFragment = MineFragment.newInstance();
            fragmentsList.add(mineFragment);
        }
        mainAdapter = new MainFragmentPagerAdapter(this,fm,fragmentsList);
        mainViewpage.setAdapter(mainAdapter);

    }

    /**
     * 设置TabLayout
     */
    private void setupTabLayout() {
        mainTablayout.setupWithViewPager(mainViewpage);

        for(int i=0;i<3;i++)
        {
            View v = mainAdapter.getPageView(i);
            mainTablayout.getTabAt(i).setCustomView(v);
        }

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

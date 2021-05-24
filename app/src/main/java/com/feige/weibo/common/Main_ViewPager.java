package com.feige.weibo.common;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.feige.weibo.MainActivity;
import com.feige.weibo.find.FindFragment;
import com.feige.weibo.mine.MineFragment;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by Administrator on 2016/9/28.
 */

public class Main_ViewPager extends ViewPager {
    private FragmentManager fm;
    private MineFragment mineFragment;
    private Context mContext;
    private MainActivity activity;
    public Main_ViewPager(Context context) {
        super(context);
        mContext = context;
        activity = (MainActivity)mContext;
    }

    public Main_ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        activity = (MainActivity)mContext;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        fm = activity.getSupportFragmentManager();
//        List<Fragment> list = fm.getFragments();
//        for(int i =0;i< list.size();i++)
//        {
//            if(list.get(i) instanceof  MineFragment)
//            {
//                mineFragment = (MineFragment)list.get(i);
//                if(mineFragment.isHidden())
//                {
//                    return true;
//                }
//
//            }
//        }
//
//        return false;
//    }


}

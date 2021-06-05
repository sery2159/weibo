package com.feige.weibo.mine;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feige.weibo.MainActivity;
import com.feige.weibo.R;
import com.feige.weibo.adapter.MineWeiBoFragmentPagerAdapter;
import com.sina.weibo.sdk.auth.AuthInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    private ImageView mToolbarCenterIcon;
    private ImageView mToolbarRightIcon;
    private TextView mToolbarTitle;
    private Toolbar mLayoutToolbar;
    private TextView mTextWords;
    private ImageView mImageMyPhoto;
    private TextView mTextPhoto;
    private ImageView mImageFocus;
    private TextView mTextFollow;
    private View mView4;
    private ImageView mImageFans;
    private TextView mTextFans;
    private ImageView mImageUser;
    private TabLayout mTablayoutInMine;
    private ViewPager mViewpageInMine;

    private List<Fragment> fragmentList;
    private List<String> titleList;
    private MineWeiBoFragmentPagerAdapter adapter;

    private Context mContext;
    private MainActivity activity;
    private FragmentManager fm;
    private static final String TAG = "MineFragment";



    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        activity = (MainActivity)context;
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(root);
        setupViewPager();
        setupTabLayout();
        Log.d(TAG, "onCreateView: ");

        
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    private void initView(View root) {
        mToolbarCenterIcon = (ImageView) root.findViewById(R.id.toolbar_center_icon);
        mToolbarRightIcon = (ImageView) root.findViewById(R.id.toolbar_right_icon);
        mToolbarTitle = (TextView) root.findViewById(R.id.toolbar_title);
        mLayoutToolbar = (Toolbar) root.findViewById(R.id.layout_toolbar);
        mTextWords = (TextView) root.findViewById(R.id.text_words);
        mImageMyPhoto = (ImageView) root.findViewById(R.id.imageMyPhoto);
        mTextPhoto = (TextView) root.findViewById(R.id.textPhoto);
        mImageFocus = (ImageView) root.findViewById(R.id.image_focus);
        mTextFollow = (TextView) root.findViewById(R.id.text_follow);
        mView4 = (View) root.findViewById(R.id.view4);
        mImageFans = (ImageView) root.findViewById(R.id.image_fans);
        mTextFans = (TextView) root.findViewById(R.id.text_fans);
        mImageUser = (ImageView) root.findViewById(R.id.image_user);
        mTablayoutInMine = (TabLayout) root.findViewById(R.id.tablayout_in_mine);
        mViewpageInMine = (ViewPager) root.findViewById(R.id.viewpage_in_mine);
    }

    /**
     * 配置Tablayout
     */
    private void setupTabLayout() {
        mTablayoutInMine.setupWithViewPager(mViewpageInMine);
    }

    /**
     * 配置ViewPager
     */

    private void setupViewPager() {
        fm = activity.getSupportFragmentManager();
        if(null == titleList)
        {
            titleList = new ArrayList<>();
            titleList.add(getString(R.string.app_name_ch));
            titleList.add(getString(R.string.app_comments));
            titleList.add(getString(R.string.app_at));
            titleList.add(getString(R.string.app_collect));

        }
        if(null == fragmentList)
        {
            fragmentList = new ArrayList<>();
            for(int i=0;i<4;i++)
             {
                  WeiboPageFragment fragments = WeiboPageFragment.newInstance();
                  fragmentList.add(fragments);
              }
        }
        adapter = new MineWeiBoFragmentPagerAdapter(fm,mContext,fragmentList,titleList);
        mViewpageInMine.setAdapter(adapter);
    }
}

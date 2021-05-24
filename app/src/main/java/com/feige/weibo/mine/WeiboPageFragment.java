package com.feige.weibo.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feige.weibo.R;

/**
 * 展示我的全部微博，我的评论，@我的以及我收藏的
 */
public class WeiboPageFragment extends Fragment {


    public static  WeiboPageFragment newInstance(){
       return new WeiboPageFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weibo_page, container, false);
    }

}

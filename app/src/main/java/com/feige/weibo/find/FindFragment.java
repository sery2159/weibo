package com.feige.weibo.find;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feige.weibo.R;

/**
 * 发现页
 */
public class FindFragment extends Fragment {


    public static FindFragment newInstance(){
        return  new FindFragment();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_find, container, false);
        return root;
    }

}

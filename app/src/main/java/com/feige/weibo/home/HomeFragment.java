package com.feige.weibo.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.feige.weibo.R;

/**
 * 首页
 */
public class HomeFragment extends Fragment {


    private ImageView mToolbarCenterIcon;
    private ImageView mToolbarRightIcon;
    private TextView mToolbarTitle;
    private Toolbar mLayoutToolbar;
    private EditText mLayoutSearch;
    private RecyclerView mHomeRecyclerview;
    private SwipeRefreshLayout mHomeSwiperefreshlayout;

    public static HomeFragment newInsance() {
        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initView(root);

        setupToolbar();
        setupSwipeRefreshLayout();
        setupRecyclerLayout();
        return root;
    }



    private void initView(View root) {
        mToolbarCenterIcon = (ImageView) root.findViewById(R.id.toolbar_center_icon);
        mToolbarRightIcon = (ImageView) root.findViewById(R.id.toolbar_right_icon);
        mToolbarTitle = (TextView) root.findViewById(R.id.toolbar_title);
        mLayoutToolbar = (Toolbar) root.findViewById(R.id.layout_toolbar);
        mLayoutSearch = (EditText) root.findViewById(R.id.layout_search);
        mHomeRecyclerview = (RecyclerView) root.findViewById(R.id.home_recyclerview);
        mHomeSwiperefreshlayout = (SwipeRefreshLayout) root.findViewById(R.id.home_swiperefreshlayout);
    }

    /**
     * 设置Toolbar
     */
    private void setupToolbar() {
        mToolbarRightIcon.setImageResource(R.drawable.ic_create_black_24dp);

    }

    /**
     * 设置RecyclerLayout
     */
    private void setupRecyclerLayout() {

    }

    /**
     * 设置SwipeRefreshLayout
     */
    private void setupSwipeRefreshLayout() {
        mHomeSwiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        mHomeSwiperefreshlayout.setProgressViewOffset(true,200,400);
    }

    private void submit() {
//        // validate
//        String search = layout_search.getText().toString().trim();
//        if (TextUtils.isEmpty(search)) {
//            Toast.makeText(getContext(), "search不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // TODO validate success, do something
//

    }
}

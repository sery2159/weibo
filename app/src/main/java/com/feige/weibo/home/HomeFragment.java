package com.feige.weibo.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.feige.weibo.base.MainActivity;
import com.feige.weibo.R;
import com.feige.weibo.adapter.WeiBoItemRecyclerViewAdapter;
import com.feige.weibo.beans.Status;
import com.feige.weibo.util.TipsUtil;

import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends Fragment implements HomeFragmentContract.View,SwipeRefreshLayout.OnRefreshListener{


    private ImageView mToolbarCenterIcon;
    private ImageView mToolbarRightIcon;
    private TextView mToolbarTitle;
    private Toolbar mLayoutToolbar;
    private EditText mLayoutSearch;
    private RecyclerView mHomeRecyclerview;
    private SwipeRefreshLayout mHomeSwiperefreshlayout;
    private Context mContext;
    private MainActivity activity;
    private List<Status> weiboItemList;

    private HomeFragmentContract.Presenter mPresenter;

    public static HomeFragment newInsance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext  = context;
        activity = (MainActivity)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initView(root);

        setupToolbar();
        setupSwipeRefreshLayout();
        setupRecyclerLayout();

        //初始化Presenter
        new HomeFragmentPresenter(mContext,weiboItemList);
        //自动刷新
        onRefresh();

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

    private void initEvent()
    {
        mHomeSwiperefreshlayout.setOnRefreshListener(this);
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
        WeiBoItemRecyclerViewAdapter weiboAdapter = new WeiBoItemRecyclerViewAdapter(weiboItemList,mContext);
        mHomeRecyclerview.setAdapter(weiboAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mHomeRecyclerview.setLayoutManager(layoutManager);
    }

    /**
     * 设置SwipeRefreshLayout
     */
    private void setupSwipeRefreshLayout() {
        mHomeSwiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        mHomeSwiperefreshlayout.setProgressViewOffset(true,200,400);
    }

    /**
     * 刷新时执行的操作
     */
    @Override
    public void onRefresh() {
        mPresenter.loadingWeiBo();


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

    @Override
    public void shwoProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String toast) {
        TipsUtil.Toast(mContext,toast);

    }

    @Override
    public void loadCompleted(List<Status> weiboList) {

    }

    @Override
    public void loadFailed(String failedInfo) {

    }

    @Override
    public void setPresenter(HomeFragmentContract.Presenter presenter) {
            this.mPresenter  = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContext = null;
    }


}

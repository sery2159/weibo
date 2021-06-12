package com.feige.weibo.home;

import android.content.Context;
import com.feige.weibo.beans.Status;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter  {
    private Context mContext;
    private List<Status> weiboList;
    private HomeFragmentContract.View  view;

    public HomeFragmentPresenter(Context mContext, List<Status> weiboList) {
        this.mContext = mContext;
        this.weiboList = weiboList;

        view.setPresenter(this);
    }

    @Override
    public void loadingWeiBo() {





    }

    @Override
    public void start() {

    }
}

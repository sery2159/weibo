package com.feige.weibo.home;

import com.feige.weibo.base.BasePresenter;
import com.feige.weibo.base.BaseView;
import com.feige.weibo.beans.Status;

import java.net.InterfaceAddress;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */

public interface HomeFragmentContract {

    interface View extends BaseView<Presenter>
    {
        void shwoProgress();
        void hideProgress();
        void showToast(String toast);
        void loadCompleted(List<Status> weiboList);
        void loadFailed(String failedInfo);
        //void showDialog()
    }

    interface Presenter extends BasePresenter
    {
        void loadingWeiBo();
    }


}

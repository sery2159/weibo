package com.feige.weibo.base;

import android.app.Application;

import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.cache.DBCacheStore;


/**
 * Created by Administrator on 2016/10/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        NoHttp.initialize(this,
                new NoHttp.Config().setCacheStore(new DBCacheStore(this).setEnable(true))
                        .setNetworkExecutor(new OkHttpNetworkExecutor()));
    }
}

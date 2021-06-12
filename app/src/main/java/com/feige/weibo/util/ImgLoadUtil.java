package com.feige.weibo.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.feige.weibo.R;

/**
 * 图片下载工具类
 * Created by feige on 2016/10/17.
 */

public  class ImgLoadUtil {


    /**
     * 加载非GIF图片
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void  loadImg(Context mContext, String url, ImageView imageView)
    {

        Glide.with(mContext).load(url).asBitmap().error(R.drawable.ic_error).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 加载GIF图片
     * @param mContext
     * @param url
     * @param imageView
     */

    public static void loadGIF(Context mContext, String url, ImageView imageView)
    {
        Glide.with(mContext).load(url).asGif().error(R.drawable.ic_error).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 清理内存和缓存
     * @param context
     */
    public static void clearMemoryAndCache(Context context)
    {
        Glide.get(context).clearDiskCache();
        Glide.get(context).clearMemory();
    }

}

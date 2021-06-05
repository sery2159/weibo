package com.feige.weibo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2009/1/1.
 */

public class TipsUtil {
    public static void Toast(Context context,String tips)
    {
        Toast.makeText(context,tips, Toast.LENGTH_SHORT).show();
    }
}

package com.feige.weibo.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.feige.weibo.R;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/9/28.
 *
 * 主界面底栏图标和文字的自定义控件
 */

public class TabLayoutCustomerTab extends FrameLayout{

    private View tabView;
    private TextView tabTitle;
    private ImageView tabIcon;
    private Context mContext;
    public TabLayoutCustomerTab(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        tabView = LayoutInflater.from(mContext).inflate(R.layout.layout_tablayout_tab_style,this);
        tabIcon  = (ImageView) tabView.findViewById(R.id.tab_icon);
        tabTitle = (TextView)tabView.findViewById(R.id.tab_tag);
    }

    public void setDate(int iconId,int title) {
        tabIcon.setImageResource(iconId);
        tabTitle.setText(getResources().getText(title));
    }
}

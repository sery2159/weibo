package com.feige.weibo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.feige.weibo.R;
import com.feige.weibo.beans.Status;
import com.feige.weibo.beans.User;
import com.feige.weibo.util.ImgLoadUtil;

import java.util.List;

/**
 * Created by Administrator on 2009/1/1.
 * home中RecyclerView适配器
 */

public class WeiBoItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Status> weiboItemList;
    private Context mContext;
    private boolean showFooter;
    private int TYPE_NORMAL = 0X00;
    private int TYPE_FOOTER = 0X01;

    public WeiBoItemRecyclerViewAdapter(List<Status> weiboItemList, Context context) {
        this.weiboItemList = weiboItemList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_NORMAL) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_weibo_item, null);
            return new ItemNormalViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_recyclerview_progress, null);
            return new ItemFooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof ItemFooterViewHolder)
        {
            ItemFooterViewHolder footerVH  = (ItemFooterViewHolder)holder;
            footerVH.text_footer_descirble.setText(R.string.tips_loading);
        }else {
            Status weiboItem = weiboItemList.get(position);
            User weiboWriter  = weiboItem.getUser();

            ItemNormalViewHolder normalVH = (ItemNormalViewHolder) holder;
            //加载头像
            ImgLoadUtil.loadImg(mContext,weiboWriter.avatar_large,normalVH.mWbImgPhoto);
           //设置作者
            normalVH.mWbTextWriter.setText(weiboWriter.getName());
            //创建时间
            normalVH.mWbTextTime.setText(weiboItem.getCreated_at());
            //微博来源
            normalVH.mWbTextFrom.setText(weiboItem.getSource());
            normalVH.mWbTextContent.setText(weiboItem.getText()+"@@"+weiboItem.getRetweeted_status().getText());
            normalVH.mWbTextRelay.setText(weiboItem.getReposts_count());
            normalVH.mWbTextComment.setText(weiboItem.getComments_count());
            normalVH.mWbTextPrase.setText(weiboItem.getAttitudes_count());
        }
    }

    @Override
    public int getItemCount() {
        if (showFooter) {
            return weiboItemList.size() + 1;
        }
        return weiboItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (showFooter && position == weiboItemList.size() - 1)
            return TYPE_FOOTER;
        return TYPE_NORMAL;
    }


    public static class ItemFooterViewHolder extends RecyclerView.ViewHolder {
        public TextView text_footer_descirble;
        public ProgressBar progress_footer;

        public ItemFooterViewHolder(View itemView) {
            super(itemView);
            text_footer_descirble = (TextView) itemView.findViewById(R.id.layout_recyclerview_descirble);
            progress_footer = (ProgressBar) itemView.findViewById(R.id.layout_recyclerview_progress);
        }
    }

    public static class ItemNormalViewHolder extends RecyclerView.ViewHolder {
        public ImageView mWbImgPhoto;
        public TextView mWbTextWriter;
        public TextView mWbTextFrom;
        public TextView mWbTextTime;
        public TextView mWbTextContent;
        public TextView mWbTextRelay;
        public TextView mWbTextComment;
        public TextView mWbTextPrase;


        public ItemNormalViewHolder(View rootView) {
            super(rootView);
                this.mWbImgPhoto = (ImageView) rootView.findViewById(R.id.wb_img_photo);
                this.mWbTextWriter = (TextView) rootView.findViewById(R.id.wb_text_writer);
                this.mWbTextFrom = (TextView) rootView.findViewById(R.id.wb_text_from);
                this.mWbTextTime = (TextView) rootView.findViewById(R.id.wb_text_time);
                this.mWbTextContent = (TextView) rootView.findViewById(R.id.wb_text_content);
                this.mWbTextRelay = (TextView) rootView.findViewById(R.id.wb_text_relay);
                this.mWbTextComment = (TextView) rootView.findViewById(R.id.wb_text_comment);
                this.mWbTextPrase = (TextView) rootView.findViewById(R.id.wb_text_prase);
        }
    }
}

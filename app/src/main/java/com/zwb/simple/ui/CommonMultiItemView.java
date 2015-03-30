package com.zwb.simple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * MultiItem的组件，适用于布局一样的多个Item的情况，像是设置里面的布局
 * Created by wenbiao_zheng on 2015/1/5.
 *
 * @author wenbiao_zheng
 */
public class CommonMultiItemView extends LinearLayout {

    public CommonMultiItemView(BaseMultiViewHolder holder, Context context, int layoutId, int arrayId) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.view_multi_item, this);
        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.ll_item_parent);
        holder.init(context, viewGroup, layoutId, arrayId);
    }

    public CommonMultiItemView(BaseMultiViewHolder holder, Context context, AttributeSet attrs, int layoutId, int arrayId) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_multi_item, this);
        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.ll_item_parent);
        holder.init(context, viewGroup, layoutId, arrayId);
    }

    @SuppressLint("NewApi")
    public CommonMultiItemView(BaseMultiViewHolder holder, Context context, AttributeSet attrs, int defStyleAttr, int layoutId, int arrayId) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.view_multi_item, this);
        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.ll_item_parent);
        holder.init(context, viewGroup, layoutId, arrayId);
    }

    @SuppressLint("NewApi")
    public CommonMultiItemView(BaseMultiViewHolder holder, Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int layoutId, int arrayId) {
        super(context, attrs, defStyleAttr, defStyleRes);

        LayoutInflater.from(context).inflate(R.layout.view_multi_item, this);
        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.ll_item_parent);
        holder.init(context, viewGroup, layoutId, arrayId);
    }
}

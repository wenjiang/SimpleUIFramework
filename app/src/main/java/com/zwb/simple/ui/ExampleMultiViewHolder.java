package com.zwb.simple.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zwb.simple.utils.LogUtil;

/**
 * Created by pc on 2015/3/30.
 */
public class ExampleMultiViewHolder extends BaseMultiViewHolder {
    private Context context;

    @Override
    public void init(Context context, ViewGroup viewGroup, int layoutId, int arrayId) {
        this.context = context;
        String[] methodName = new String[]{"search", "setting"};
        Resources resources = context.getResources();
        TypedArray typedArray = resources.obtainTypedArray(arrayId);
        TypedArray idArray = resources.obtainTypedArray(typedArray.getResourceId(0, -1));
        TypedArray iconArray = resources.obtainTypedArray(typedArray.getResourceId(1, -1));
        TypedArray titleArray = resources.obtainTypedArray(typedArray.getResourceId(2, -1));

        try {
            int size = iconArray.length();
            for (int i = 0; i < size; i++) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_setting, null);
                ImageView icon = (ImageView) view.findViewById(R.id.iv_icon);
                int iconId = iconArray.getResourceId(i, -1);
                icon.setBackgroundResource(iconId);
                bindMethod(this, iconId, methodName[i]);
                TextView titleLeftText = (TextView) view.findViewById(R.id.tv_content);
                titleLeftText.setText(titleArray.getString(i));
                viewGroup.addView(view);
                setItemClick(this, view, iconId);
            }
        } catch (Exception e) {
            LogUtil.e(e.toString());
        } finally {
            typedArray.recycle();
            idArray.recycle();
            iconArray.recycle();
            titleArray.recycle();
        }
    }

    public void search() {
        Toast.makeText(context, "搜索", Toast.LENGTH_LONG).show();
    }

    public void setting() {
        Toast.makeText(context, "设置", Toast.LENGTH_LONG).show();
    }
}

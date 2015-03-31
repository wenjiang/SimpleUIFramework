package com.zwb.simple.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zwb.simple.utils.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的MultiItem的ViewHolder，用于布局一样，但个别组件不一样，像是图标等的View，常见于各种设置页面
 * Created by wenbiao_zheng on 2015/1/6.
 *
 * @author wenbiao_zheng
 */
public abstract class BaseMultiViewHolder {

    private Map<Object, Method> methodMap;

    public BaseMultiViewHolder() {
        methodMap = new HashMap<Object, Method>();
    }

    public abstract void init(Context context, ViewGroup viewGroup, int layoutId, int arrayId);

    /**
     * 绑定方法
     *
     * @param object     声明方法的类的对象
     * @param id         方法对应的key值，一般是唯一标识的id
     * @param methodName 方法名
     */
    protected void bindMethod(final Object object, int id, String methodName) {
        Class[] methodParam = null;
        Method method = null;
        try {
            method = object.getClass().getMethod(methodName, methodParam);
        } catch (NoSuchMethodException e) {
            LogUtil.e(e.toString());
        }

        methodMap.put(id, method);
    }

    /**
     * Item的点击事件的绑定
     *
     * @param object 声明点击事件的类对象
     * @param view   要绑定点击事件的组件
     * @param id     Method对应的key，一般都是唯一标识的key
     * @throws Exception
     */
    public void setItemClick(final Object object, View view, final int id) throws Exception {
        if (methodMap == null) {
            throw new Exception("Please invoke super() in constructor");
        }

        if (methodMap.size() == 0) {
            throw new Exception("Please bind method by invoking bindMethod");
        }

        final Object[] invokeParam = null;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Method method = null;
                try {
                    method = methodMap.get(id);
                    method.invoke(object, invokeParam);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setItemMargin(Resources resources, View view, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (leftMargin != 0) {
            params.leftMargin = resources.getDimensionPixelOffset(leftMargin);
        }

        if (topMargin != 0) {
            params.topMargin = resources.getDimensionPixelSize(topMargin);
        }

        if (rightMargin != 0) {
            params.rightMargin = resources.getDimensionPixelSize(rightMargin);
        }

        if (bottomMargin != 0) {
            params.bottomMargin = resources.getDimensionPixelSize(bottomMargin);
        }
        view.setLayoutParams(params);
    }
}

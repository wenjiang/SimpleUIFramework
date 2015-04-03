package com.zwb.simple.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.IllegalAccessException;
import java.lang.NoSuchMethodException;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 状态单选的组件，所谓的状态单选，指的是一组组件，状态变化是一样的，其中一种状态同一时间只有一个组件才有，
 * 类似Tab选项切换，字体样式的更改
 * Created by pc on 2015/3/30.
 */
public class SelectorDrawable {
    private List<View> views;
    private Context context;
    private int selectState;
    private int noSelectState;
    private String methodName;
    private View.OnClickListener onClickListener;

    public SelectorDrawable(Context context) {
        this.views = new ArrayList<View>();
        this.context = context;
    }

    /**
     * 设置颜色
     *
     * @param selectState   选中的状态
     * @param noSelectState 没有选中的状态
     */
    public void setColors(int selectState, int noSelectState) {
        this.selectState = selectState;
        this.noSelectState = noSelectState;
    }

    /**
     * 绑定View的方法
     *
     * @param methodName View绑定的方法名
     * @param viewArr    被绑定的一组View
     */
    public void bindView(String methodName, View... viewArr) {
        this.methodName = methodName;
        for (View view : viewArr) {
            views.add(view);
        }
    }

    /**
     * 绑定View的方法
     *
     * @param methodName View绑定的方法名
     * @param idArr      被绑定的一组View的id
     */
    public void bindView(String methodName, int... idArr) {
        this.methodName = methodName;
        for (int id : idArr) {
            View view = ((Activity) context).findViewById(id);
            views.add(view);
        }
    }

    /**
     * 设置点击事件
     *
     * @param listener 点击事件
     */
    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = listener;
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }

    /**
     * 设置点击事件
     *
     * @param position 被设置的view的位置
     * @param listener 点击事件
     */
    public void setOnClickListener(int position, View.OnClickListener listener) {
        views.get(position).setOnClickListener(listener);
    }

    /**
     * 改变View的状态
     *
     * @param position 被改变的View的位置
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void changeViewOn(int position) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        View view = views.get(position);
        for (View v : views) {
            if (methodName.equals("setTextColor")) {
                if (v.getId() == view.getId()) {
                    ((TextView) v).setTextColor(context.getResources().getColor(selectState));
                } else {
                    ((TextView) v).setTextColor(context.getResources().getColor(noSelectState));
                }
            }

            if (methodName.equals("setBackgroundColor")) {
                if (v.getId() == view.getId()) {
                    v.setBackgroundColor(context.getResources().getColor(selectState));
                } else {
                    v.setBackgroundColor(context.getResources().getColor(noSelectState));
                }
            }

            if (methodName.equals("setBackgroundResource")) {
                if (v.getId() == view.getId()) {
                    v.setBackgroundResource(selectState);
                } else {
                    v.setBackgroundResource(noSelectState);
                }
            }
        }
    }

    /**
     * 改变View的状态
     *
     * @param view 被改变的View
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void changeViewOn(View view) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (View v : views) {
            if (methodName.equals("setTextColor")) {
                if (v.getId() == view.getId()) {
                    ((TextView) v).setTextColor(context.getResources().getColor(selectState));
                } else {
                    ((TextView) v).setTextColor(context.getResources().getColor(noSelectState));
                }
            }

            if (methodName.equals("setBackgroundColor")) {
                if (v.getId() == view.getId()) {
                    v.setBackgroundColor(context.getResources().getColor(selectState));
                } else {
                    v.setBackgroundColor(context.getResources().getColor(noSelectState));
                }
            }

            if (methodName.equals("setBackgroundResource")) {
                if (v.getId() == view.getId()) {
                    v.setBackgroundResource(selectState);
                } else {
                    view.setBackgroundResource(noSelectState);
                }
            }
        }
    }

    /**
     * 设置启动
     */
    public void setup() {
        if (onClickListener == null) {
            for (View view : views) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            changeViewOn(v);
                        } catch (NoSuchMethodException e) {
                            Log.e("SelectorDrawable", e.toString());
                        } catch (InvocationTargetException e) {
                            Log.e("SelectorDrawable", e.toString());
                        } catch (IllegalAccessException e) {
                            Log.e("SelectorDrawable", e.toString());
                        }
                    }
                });
            }
        }
    }
}

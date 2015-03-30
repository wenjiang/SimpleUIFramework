package com.zwb.simple.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.IllegalAccessException;import java.lang.NoSuchMethodException;import java.lang.Override;import java.lang.String;import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
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

    public void setColors(int selectState, int noSelectState) {
        this.selectState = selectState;
        this.noSelectState = noSelectState;
    }

    public void bindView(String methodName, View... viewArr) {
        this.methodName = methodName;
        for (View view : viewArr) {
            views.add(view);
        }
    }

    public void bindView(String methodName, int... idArr) {
        this.methodName = methodName;
        for (int id : idArr) {
            View view = ((Activity) context).findViewById(id);
            views.add(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = listener;
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }

    public void setOnClickListener(int position, View.OnClickListener listener) {
        views.get(position).setOnClickListener(listener);
    }

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

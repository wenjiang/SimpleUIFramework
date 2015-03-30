package com.zwb.simple.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.zwb.simple.ui.CommonMultiItemView;
import com.zwb.simple.ui.ExampleMultiViewHolder;
import com.zwb.simple.ui.R;

/**
 * Created by pc on 2015/3/30.
 */
public class MultiViewExampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        CommonMultiItemView itemView = new CommonMultiItemView(new ExampleMultiViewHolder(), this, R.layout.item_setting, R.array.array_setting);
        LinearLayout layout = (LinearLayout) findViewById(R.id.ll_parent);
        layout.addView(itemView);
    }
}

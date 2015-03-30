package com.zwb.simple.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.zwb.simple.ui.R;
import com.zwb.simple.ui.SelectorDrawable;

/**
 * Created by pc on 2015/3/30.
 */
public class SelectorExampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        final SelectorDrawable selectorDrawable = new SelectorDrawable(this);
        selectorDrawable.bindView("setTextColor", R.id.btn1, R.id.btn2);
        selectorDrawable.setColors(R.color.white, R.color.half_transparent_white);
        selectorDrawable.setup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.zwb.simple.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.zwb.simple.ui.R;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button selectorBtn = (Button) findViewById(R.id.btn_selector);
        Button multiBtn = (Button) findViewById(R.id.btn_multi);

        selectorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectorExampleActivity.class);
                startActivity(intent);
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MultiViewExampleActivity.class);
                startActivity(intent);
            }
        });
    }
}

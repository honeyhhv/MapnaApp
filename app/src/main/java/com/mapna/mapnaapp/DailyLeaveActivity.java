package com.mapna.mapnaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rey.material.widget.ImageView;

public class DailyLeaveActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_leave);
        BindViews();
    }

    private void BindViews() {
        imgback=(ImageView)findViewById(R.id.imgBack);
        imgback.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {  case R.id.imgBack:
            {
                finish();onBackPressed();
                break;
            }
        }
    }
}

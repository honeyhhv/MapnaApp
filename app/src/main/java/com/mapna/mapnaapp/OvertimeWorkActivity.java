package com.mapna.mapnaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rey.material.widget.ImageView;

public class OvertimeWorkActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overtime_work);


        BindViews();
    }

    private void BindViews() {
        imgBack=(ImageView)findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);
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

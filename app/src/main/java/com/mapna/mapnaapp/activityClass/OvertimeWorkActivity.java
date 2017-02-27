package com.mapna.mapnaapp.activityClass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mapna.mapnaapp.R;
import com.rey.material.widget.ImageView;

public class OvertimeWorkActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBack;
    private Spinner spBuilding,spFloor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overtime_work);


        BindViews();
        setSpinner();
    }

    private void setSpinner() {

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> BuildingAdapter = ArrayAdapter
                .createFromResource(this, R.array.bulding_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> FloorAdapter = ArrayAdapter
                .createFromResource(this, R.array.floor_array,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        BuildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FloorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spBuilding.setAdapter(BuildingAdapter);
        spFloor.setAdapter(FloorAdapter);
    }

    private void BindViews() {
        imgBack=(ImageView)findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);
        spBuilding=(Spinner)findViewById(R.id.building_spinner);
        spFloor=(Spinner)findViewById(R.id.floor_spinner);
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgBack: {
                finish();
                onBackPressed();
                break;
            }
        }
    }
}

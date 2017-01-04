package com.mapna.mapnaapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.mapna.mapnaapp.utils.DatePickerDailog;
import com.mapna.mapnaapp.R;
import android.util.Log;
import com.mapna.mapnaapp.utils.DatePickerDailog;
import com.mapna.mapnaapp.utils.JalaliCalendar;


public class MainActivity extends AppCompatActivity {
    Button btn_date;
    JalaliCalendar dateandtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_date=(Button)findViewById(R.id.button);

       btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDailog dp = new DatePickerDailog(MainActivity.this,
                        dateandtime, new DatePickerDailog.DatePickerListner() {

                    // @SuppressLint("SimpleDateFormat")
                    @Override
                    public void OnDoneButton(Dialog datedialog, String c) {
                        datedialog.dismiss();

                        btn_date.setText(c.toString());
                        Log.e("Tarikh:   ", c.toString());
                    }

                    @Override
                    public void OnCancelButton(Dialog datedialog) {
                        // TODO Auto-generated method stub
                        datedialog.dismiss();
                    }
                });
                dp.show();



            }
        });
    }
}

package com.mapna.mapnaapp.customViews;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.tools.PublicMethods;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

/**
 * Created by variani_h on 1/4/2017.
 */

public class PersianTimePickerView extends LinearLayout implements View.OnClickListener  , TimePickerDialog.OnTimeSetListener{
    private PublicMethods pm;
    private TextView lblName;
    private EditText txtInput;
    private Context mContext;

    private static final String TIMEPICKER = "TimePickerDialog";
    public void Initialize(Context context)
    {
        mContext=context;
        pm=new PublicMethods(context);
        lblName= (TextView)findViewById(R.id.lblName);
        txtInput=(EditText)findViewById(R.id.txtInput);
        ImageButton imgPickTime=(ImageButton)findViewById(R.id.imgPickTime);
        imgPickTime.setOnClickListener(this);
    }
    public PersianTimePickerView(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.persian_time_picker_view, this);

        Initialize(context);
    }

    public PersianTimePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.persian_time_picker_view, this);

        Initialize(context);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PersianTimePickerView);
        String strLabelText = a.getString(R.styleable.PersianTimePickerView_LabelText);
        int intLabelWidth = a.getDimensionPixelSize(R.styleable.PersianTimePickerView_LabelWidth,50 );
        int intTextWidth = a.getDimensionPixelSize(R.styleable.PersianTimePickerView_TextWidth,100 );
        int intFontSize = a.getDimensionPixelSize(R.styleable.PersianTimePickerView_FontSize,14 );
        boolean boolEnabled= a.getBoolean(R.styleable.PersianTimePickerView_TextEnabled,false );


        setCaption(strLabelText);
        lblName.setWidth(intLabelWidth);
        lblName.setTypeface(pm.getMapnaTypeFace());
        lblName.setTextSize(TypedValue.COMPLEX_UNIT_DIP ,intFontSize);
        txtInput.setWidth(intTextWidth);
        txtInput.setTypeface(pm.getMapnaTypeFace());
        txtInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP,intFontSize );
        txtInput.setEnabled(boolEnabled);

        a.recycle();
    }

    private void setCaption(String caption) {
        lblName.setText(caption);
    }
    public String getTime()
    {
        if (String.valueOf(txtInput.getText())!=null)
        {return txtInput.getText().toString();}
        else {return null;}

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgPickTime:
            {
                PersianCalendar now = new PersianCalendar();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        this,
                        now.get(PersianCalendar.HOUR_OF_DAY),
                        now.get(PersianCalendar.MINUTE),
                        true
                );
                tpd.setThemeDark(true);
                Activity act=(Activity)mContext;
                tpd.show(act.getFragmentManager(), TIMEPICKER);
                break;
            }
        }

    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String time = hourString+":"+minuteString;
        txtInput.setText(time);
        txtInput.setEnabled(true);
    }
}

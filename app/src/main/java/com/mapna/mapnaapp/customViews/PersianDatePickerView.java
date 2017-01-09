package com.mapna.mapnaapp.customViews;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

/**
 * Created by variani_h on 1/3/2017.
 */

public class PersianDatePickerView extends LinearLayout implements View.OnClickListener  , DatePickerDialog.OnDateSetListener{
    private PublicMethods pm;
    private TextView lblName;
    private EditText txtInput;
    private Context mContext;
    private static final String DATEPICKER = "DatePickerDialog";

    public void Initialize(Context context)
    {
        mContext=context;
        pm=new PublicMethods(context);
        lblName= (TextView)findViewById(R.id.lblName);
        txtInput=(EditText)findViewById(R.id.txtInput);
        ImageButton imgPickDate=(ImageButton)findViewById(R.id.imgPickDate);
        imgPickDate.setOnClickListener(this);
    }
    public PersianDatePickerView(Context context) {

        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.persian_date_picker_view, this);

        Initialize(context);
    }

    public PersianDatePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.persian_date_picker_view, this);

        Initialize(context);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PersianDatePickerView);
        String strLabelText = a.getString(R.styleable.PersianDatePickerView_LabelText);
        int intLabelWidth = a.getDimensionPixelSize(R.styleable.PersianDatePickerView_LabelWidth,50 );
        int intTextWidth = a.getDimensionPixelSize(R.styleable.PersianDatePickerView_TextWidth,100 );
        int intFontSize = a.getDimensionPixelSize(R.styleable.PersianDatePickerView_FontSize,14 );
        boolean boolEnabled= a.getBoolean(R.styleable.PersianDatePickerView_TextEnabled,false );


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

    public void setCaption(String caption) {

        lblName.setText(caption);
    }
    public String getDate()
    {
        if (String.valueOf(txtInput.getText())!=null)
        {return txtInput.getText().toString();}
        else {return null;}

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgPickDate:
            {
                PersianCalendar now = new PersianCalendar();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        this,
                        now.getPersianYear(),
                        now.getPersianMonth(),
                        now.getPersianDay()
                );
                dpd.setThemeDark(true);

                Activity act=(Activity)mContext;

                dpd.show(act.getFragmentManager(), DATEPICKER);
                break;
            }
        }

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String day,month;
        if (String.valueOf(dayOfMonth).length()<2)
            day="0"+String.valueOf(dayOfMonth);
        else day=String.valueOf(dayOfMonth);

        if (String.valueOf(monthOfYear+1).length()<2)
            month="0"+String.valueOf(monthOfYear+1);
        else month=String.valueOf(monthOfYear+1);


       txtInput.setText(year+"/"+month+"/"+ day);

    }
}

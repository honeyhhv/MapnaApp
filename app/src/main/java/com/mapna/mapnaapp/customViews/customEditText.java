package com.mapna.mapnaapp.customViews;

import android.content.Context;
import android.util.AttributeSet;

import com.mapna.mapnaapp.R;
import com.rey.material.widget.EditText;

import com.mapna.mapnaapp.tools.PublicMethods;

/**
 * Created by variani_h on 11/5/2016.
 */

public class customEditText extends EditText {
    PublicMethods pm ;
    public customEditText(Context context) {
        super(context);
        pm=new PublicMethods(context);

        this.setTypeface(pm.getMapnaTypeFace());
        this.applyStyle(R.style.customTextStyle);


    }

    public customEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm=new PublicMethods(context);

        this.setTypeface(pm.getMapnaTypeFace());
        this.applyStyle(R.style.customTextStyle);


    }
}

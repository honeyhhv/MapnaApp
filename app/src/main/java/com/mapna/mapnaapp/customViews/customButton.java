package com.mapna.mapnaapp.customViews;

import android.content.Context;
import android.util.AttributeSet;

import com.mapna.mapnaapp.R;
import com.rey.material.widget.Button;

import com.mapna.mapnaapp.tools.PublicMethods;

/**
 * Created by variani_h on 11/5/2016.
 */

public class customButton extends Button {
    PublicMethods pm ;
    public customButton(Context context) {
        super(context);
        pm=new PublicMethods(context);

        this.setTypeface(pm.getMapnaTypeFace());
        this.applyStyle(R.style.customButtonStyle);

    }

    public customButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        pm=new PublicMethods(context);

        this.setTypeface(pm.getMapnaTypeFace());
        this.applyStyle(R.style.customButtonStyle);


    }
}

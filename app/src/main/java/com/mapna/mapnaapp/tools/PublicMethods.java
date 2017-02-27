package com.mapna.mapnaapp.tools;

import android.content.Context;
import android.graphics.Typeface;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.models.Period;
import com.mapna.mapnaapp.models.RequestType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by variani_h on 11/7/2016.
 */

public class PublicMethods {
    private Context context;
    public static  String FCM_URL ="https://fcm.googleapis.com/fcm/send";
    public static String Login_URL="http://webapi.mapnagroup.com/MapnaWebApi/api/user/get/?";//dn=mapna.com&un=variani_h&pw=Honey@mapna";
    public static String Request_TYPE_URL="http://webapi.mapnagroup.com/MapnaWebApi/api/HrRequest/get/?";//pd=8&np=45270&tq=6;
    public PublicMethods(Context mContext) {
        this.context=mContext;
    }
    public Typeface getHomaTypeFace()
    {
        Typeface homa= Typeface.createFromAsset(context.getAssets(),"homa.ttf");

        return homa;
    }
    public Typeface getNazaninTypeFace()
    {
        Typeface nazanin= Typeface.createFromAsset(context.getAssets(),"bnazanin.ttf");

        return nazanin;
    }
    public Typeface getMapnaTypeFace()
    {
        Typeface mapna= Typeface.createFromAsset(context.getAssets(), "mapna.ttf");

        return mapna;
    }
    public void ToastShort(String text)
    {
        Toast.makeText(context, text,Toast.LENGTH_SHORT).show();
    }
    public void ToastLong(String text)
    {
        Toast.makeText(context, text,Toast.LENGTH_LONG).show();
    }

    public void setShared(String key, String content) {
        PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putString(key, content).apply();
    }

    public String getShared(String key) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(key, null);
    }

    public List<RequestType> getAllRequestType()
    {
        RequestType obj1=new RequestType("2",context.getString(R.string.title_hourly_leave));
        RequestType obj2=new RequestType("6",context.getString(R.string.title_Hourly_mission));
        RequestType obj3=new RequestType("LA",context.getString(R.string.title_Daily_leave));
        //RequestType obj4=new RequestType("CRDL3",context.getString(R.string.title_Daily_Sick));
        //RequestType obj5=new RequestType("CRDL4",context.getString(R.string.title_Daily_urgent));


        List<RequestType> arrTypes=new ArrayList<RequestType>();
        arrTypes.add(obj1);
        arrTypes.add(obj2);
        arrTypes.add(obj3);
        //arrTypes.add(obj4);
        //arrTypes.add(obj5);

        return arrTypes;
    }
    public List<Period> getAllPeriods()
    {
        Period prj1=new Period(1,context.getString(R.string.months_farvardin));
        Period prj2=new Period(2,context.getString(R.string.months_ordibehesht));
        Period prj3=new Period(3,context.getString(R.string.months_khordad));
        Period prj4=new Period(4,context.getString(R.string.months_tir));
        Period prj5=new Period(5,context.getString(R.string.months_mordad));
        Period prj6=new Period(6,context.getString(R.string.months_shahrivar));
        Period prj7=new Period(7,context.getString(R.string.months_mehr));
        Period prj8=new Period(8,context.getString(R.string.months_aban));
        Period prj9=new Period(9,context.getString(R.string.months_azar));
        Period prj10=new Period(10,context.getString(R.string.months_dey));
        Period prj11=new Period(11,context.getString(R.string.months_bahman));
        Period prj12=new Period(12,context.getString(R.string.months_esfand));

        List<Period> arrMonths=new ArrayList<Period>();
        arrMonths.add(prj1);
        arrMonths.add(prj2);
        arrMonths.add(prj3);
        arrMonths.add(prj4);
        arrMonths.add(prj5);
        arrMonths.add(prj6);
        arrMonths.add(prj7);
        arrMonths.add(prj8);
        arrMonths.add(prj9);
        arrMonths.add(prj10);
        arrMonths.add(prj11);
        arrMonths.add(prj12);

        return arrMonths;
     }
}

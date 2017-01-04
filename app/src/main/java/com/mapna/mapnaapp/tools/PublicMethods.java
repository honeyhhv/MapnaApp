package com.mapna.mapnaapp.tools;

import android.content.Context;
import android.graphics.Typeface;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by variani_h on 11/7/2016.
 */

public class PublicMethods {
    private Context context;
    public static  String FCM_URL ="https://fcm.googleapis.com/fcm/send";
    public static String Login_URL="http://webapi.mapnagroup.com/MapnaWebApi/api/user/get/?";//dn=mapna.com&un=variani_h&pw=Honey@mapna";
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
}

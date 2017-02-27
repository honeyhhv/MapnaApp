package com.mapna.mapnaapp.activityClass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.tools.PublicMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.util.TextUtils;


public class SplashScreenActivity extends AppCompatActivity {
    PublicMethods pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        pm =new PublicMethods(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.d("AsyncCall", "SplashScreenActivity:run");

                if (pm.getShared(getString(R.string.Username))!=null) {
                    if (HasExpired()) {
                            /*LoginUser(pm.getShared(getString(R.string.Domain)), pm.getShared(getString(R.string.Username)),
                                    pm.getShared(getString(R.string.Password)));*/

                        Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(main_intent);
                        finish();
                    }
                    else {
                        Intent main_intent = new Intent(SplashScreenActivity.this, DrawerActivity.class);
                        startActivity(main_intent);
                        finish();
                    }
                }
                else {
                    Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(main_intent);
                    finish();
                }
            }
        },1000);
    }
    private boolean HasExpired() {

        Log.d("AsyncCall", "SplashScreenActivity:HasExpired");
        if (!TextUtils.isEmpty(pm.getShared(getString(R.string.ExpiredDate))))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd",Locale.US);
            try {
                Date expDate = sdf.parse(pm.getShared(getString(R.string.ExpiredDate)));
                return new Date().after(expDate);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return true;

            }
        }
        return true;
    }

    /* public void LoginUser(final String domain, final String username , final String password) {

         AsyncHttpClient client = new AsyncHttpClient();


         String strUrl = PublicMethods.Login_URL + "dn=" + domain + ".com&un=" + username + "&pw=" + password;

         //TODO: remove below after test
         //strUrl="http://webapi.mapnagroup.com/MapnaWebApi/api/user/get/?dn=mapna.com&un=variani_h&pw=";
         Log.d("AsyncCall", strUrl);
             client.get(strUrl, new AsyncHttpResponseHandler() {
                 @Override
                 public void onStart() {
                     super.onStart();
                 }

                 @Override
                 public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                     try {
                         String strJson = new String(responseBody, "UTF-8");
                         Log.d("AsyncCall", strJson);
                         if (!TextUtils.isEmpty(strJson)) {

                             pm.setShared(getString(R.string.Username),username);
                             pm.setShared(getString(R.string.Password),password);
                             pm.setShared(getString(R.string.Domain),domain);

                             loginJsonParser(strJson);

                             Log.d("AsyncCall", "after if");
                         }
                         else {
                             pm.ToastLong(getString(R.string.error_login));
                             Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                             startActivity(main_intent);
                             finish();
                         }
                     } catch (UnsupportedEncodingException e) {
                         e.printStackTrace();
                         pm.ToastLong(getString(R.string.error_Server));

                         Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                         startActivity(main_intent);
                         finish();

                     }

                 }

                 @Override
                 public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                     pm.ToastLong(getString(R.string.error_Server));
                     Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                     startActivity(main_intent);
                     finish();

                 }
             });
         }

     private void loginJsonParser(String strJson) {
         try{
             JSONObject allObj= new JSONObject(strJson);
             String strPersonelId= allObj.getString("PersonelId");
             String strFirstname= allObj.getString("Firstname");
             String strLastname  = allObj.getString("Lastname");
             String strCompany= allObj.getString("Company");
             String strManagement= allObj.getString("Management");
             String strDepartment= allObj.getString("Department");
             String strTitle= allObj.getString("Title");
             String strExpiredDate= allObj.getString("ExpiredDate");

             pm.setShared(getString(R.string.PersonelId),strPersonelId);
             pm.setShared(getString(R.string.Firstname),strFirstname);
             pm.setShared(getString(R.string.Lastname),strLastname);
             pm.setShared(getString(R.string.Company),strCompany);
             pm.setShared(getString(R.string.Management),strManagement);
             pm.setShared(getString(R.string.Department),strDepartment);
             pm.setShared(getString(R.string.Title),strTitle);
             pm.setShared(getString(R.string.ExpiredDate),strExpiredDate);


             //TODO:save image path & expired date
             //setImage(strTemp, strText);

             Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
             startActivity(intent);
         }
         catch (Exception e) {

             Log.d("AsyncCall", "loginJsonParser Exception : " + e.getMessage());
             pm.ToastLong(getString(R.string.error_Server));
             Intent main_intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
             startActivity(main_intent);
             finish();


         }
     }
     */

}

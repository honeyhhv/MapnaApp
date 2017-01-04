package com.mapna.mapnaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;

import com.mapna.mapnaapp.customViews.customLoginText;
import com.mapna.mapnaapp.customViews.customProgressbar;
import com.mapna.mapnaapp.tools.PublicMethods;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

   customProgressbar progressbar;
    customLoginText txtUser;
    customLoginText txtPass;
    PublicMethods pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindingViews();

            findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (!TextUtils.isEmpty(txtUser.getText().toString().trim()) &&
                            !TextUtils.isEmpty(txtPass.getText().toString().trim())) {
                        //for test is commented

                       // txtUser.setText("mapna\\"+txtUser.getText().toString().trim());
                        LoginUser("mapna\\"+txtUser.getText().toString().trim(), txtPass.getText().toString().trim());
                        //Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                        //startActivity(intent);
                    }

                }
            });

    }

    private void bindingViews() {

        pm=new PublicMethods(LoginActivity.this);
        txtUser=(customLoginText)findViewById(R.id.txt_user);
        txtPass=(customLoginText)findViewById(R.id.txt_password);
        progressbar =(customProgressbar) findViewById(R.id.progressbar);
    }

    public void LoginUser(String username ,String password) {

        AsyncHttpClient client = new AsyncHttpClient();
        if (username.indexOf('\\') <0) {

            pm.ToastLong(getString(R.string.error_login));

        }
        else {
            final String  dm = username.substring(0, username.indexOf('\\'));

            String un = username.substring(username.indexOf('\\') + 1, username.length());

            String strUrl = PublicMethods.Login_URL + "dn=" + dm + ".com&un=" + un + "&pw=" + password;

            //TODO: remove below after test
            //strUrl="http://webapi.mapnagroup.com/MapnaWebApi/api/user/get/?dn=mapna.com&un=variani_h&pw=";
            Log.d("AsyncCall", strUrl);

            client.get(strUrl, new AsyncHttpResponseHandler() {
                @Override
                public void onStart() {
                    super.onStart();
                    progressbar.setVisibility(View.VISIBLE);

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    progressbar.setVisibility(View.INVISIBLE);

                    try {
                        String strJson = new String(responseBody, "UTF-8");
                        Log.d("AsyncCall", strJson);
                        if (!TextUtils.isEmpty(strJson)) {

                            pm.setShared(getString(R.string.Username),txtUser.getText().toString().trim());
                            pm.setShared(getString(R.string.Password),txtPass.getText().toString().trim());
                            pm.setShared(getString(R.string.Domain),dm);

                            loginJsonParser(strJson);

                            Log.d("AsyncCall", "after if");
                        }
                        else {
                            pm.ToastLong(getString(R.string.error_login));
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        pm.ToastLong(getString(R.string.error_Server));

                    }

                }


                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    progressbar.setVisibility(View.INVISIBLE);
                    pm.ToastLong(getString(R.string.error_Server));

                }
            });
        }

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
            this.finish();
            startActivity(intent);

        }
        catch (Exception e) {

            Log.d("AsyncCall", "loginJsonParser Exception : " + e.getMessage());
            pm.ToastLong(getString(R.string.error_Server));


        }
    }
}

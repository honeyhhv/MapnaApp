package com.mapna.mapnaapp.services;

import android.preference.PreferenceManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.tools.PublicMethods;

import static com.loopj.android.http.AsyncHttpClient.log;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private PublicMethods pm;
    public MyFirebaseInstanceIdService() {

        log.d("FCM_token"," constructor");

    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        pm=new PublicMethods(getApplicationContext());
        String token= FirebaseInstanceId.getInstance().getToken();

        //for add a member to a group
        //FirebaseMessaging.getInstance().subscribeToTopic("News");
        pm.setShared(getString(R.string.FcmToken),token);

        log.d("FCM_token","onTokenRefresh:" + token);

        //TODO : send this token to server plus username, for next real use
        //sendRegistrationToServer(token);

    }
}

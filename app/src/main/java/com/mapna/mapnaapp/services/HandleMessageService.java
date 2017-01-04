package com.mapna.mapnaapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mapna.mapnaapp.tools.PublicMethods;


public class HandleMessageService extends FirebaseMessagingService {
    PublicMethods pm;
    public HandleMessageService() {
    }

    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        pm = new PublicMethods(getApplicationContext());
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {

                pm.ToastLong(remoteMessage.getNotification().getTitle());
                pm.ToastLong(remoteMessage.getNotification().getBody());
            }
        });
    }
}

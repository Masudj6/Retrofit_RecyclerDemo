package com.example.masud.retrofit_and_recycler_demo.firebase;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.masud.retrofit_and_recycler_demo.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessegingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotificaiton(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody() );

    }

    public void showNotificaiton(String title,String message){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this, "Mynotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }
}

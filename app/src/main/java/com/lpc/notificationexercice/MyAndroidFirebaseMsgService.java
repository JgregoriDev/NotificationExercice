package com.lpc.notificationexercice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.ArrayMap;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by lpc on 19/04/17.
 */

public class MyAndroidFirebaseMsgService extends FirebaseMessagingService {
    ArrayMap<String,String> campsMissatge;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        campsMissatge = new ArrayMap<>();
        campsMissatge = (ArrayMap<String, String>) remoteMessage.getData();
        createNotification(remoteMessage.getNotification().getBody());
    }

    private void createNotification(String messagebody) {
        Intent intent=new Intent(this,ResultActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        for (String key:campsMissatge.keySet()){
            intent.putExtra(key,campsMissatge.get(key));
        }
        PendingIntent resultIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri notificationSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotificationBuilder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(resultIntent)
                .setContentTitle(messagebody)
                .setAutoCancel(true)
                .setSound(notificationSoundUri)
                .setContentIntent(resultIntent);
        NotificationManager notificationManager=
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,mNotificationBuilder.build());
    }
}

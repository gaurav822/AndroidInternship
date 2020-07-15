package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {

        //Any Notification the following things are mandatory
        /* - small icon
        * - Title
        * * - Description
         */

        /*
        There are three imp components

        *- NotificationManager (This can issue a notification or cancel a notification)
        * - NotificationChannel (Without this we cannot send a notification on oreo or above)
        * - NotificationCompat.Builder (To build the notification) */

                 NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                 if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

                        //We have to create a notification channel
                     NotificationChannel nc = new NotificationChannel("srminterns","SRM NOTIFICATIONS",NotificationManager.IMPORTANCE_HIGH);
                     nm.createNotificationChannel(nc);

                 }

                // we have to normally write notification code.

                NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"srminterns");
                builder.setSmallIcon(R.drawable.umbrella);
                builder.setContentTitle("Sample Notification");
                builder.setContentText("This is the description of the notification");
                builder.setAutoCancel(true);

                /* Pending Intent
                *  - It is the description of the operation to be performed
                *  - can be created using the following methods
                *       -getActivity() - if you want to open an activity with pending Intent
                *       -getService()  - if you want to strat a service with Pending Intent
                *       -getBroadcast() - if you want to send a broadcast with Pending Intent
                *
                * Requires 4 Arguments
                *           -context
                *           -Pending Intent ID (Can be any Integer)
                *           -Intent(Action that you want to perform)
                *           - FLAG (This flag will tell the existing pending Intent about what to do if there
                *               is a new Pending Intent (Arrival) */

                PendingIntent pi = PendingIntent.getActivity(this,12,new Intent(this, MainActivity.class)
                        ,PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setContentIntent(pi);

                /*
                * Step1: is to convert any image format that you want to display into a Bitmap image format
                * Step2: is to create bigPicture style before you issue the notification.
                *
                *
                *
                *
                * */

                Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.kathmandu);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
                nm.notify(42,builder.build());
    }
}
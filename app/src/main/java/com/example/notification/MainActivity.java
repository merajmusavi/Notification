package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button BigPic = findViewById(R.id.bigPicShow);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        BigPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), "myapp")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory
                                .decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("fsasfasfd")
                        .setContentText("sadfsefewfwsfewswfc")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_flag_of_argentina)))
                        .build();

                notificationManager.notify(2, notification);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                Notification notification = new NotificationCompat.Builder(getApplicationContext(), "myapp")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory
                                .decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentTitle("fsasfasfd")
                        .setContentText("sadfsefewfwsfewswfc")
                        .setContentIntent(pendingIntent)
                        .build();

                notificationManager.notify(1, notification);
            }

        });
    }
}
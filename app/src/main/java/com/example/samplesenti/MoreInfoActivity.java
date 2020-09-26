package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MoreInfoActivity extends AppCompatActivity {

    NotificationManager manager;

    private static String CHANNEL_ID = "channel1";
    private static String CHANNEL_NAME = "Channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        Button button = (Button)findViewById(R.id.btn_vibrate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                showNoti();
            }
        });
    }


    public void showNoti(){
        NotificationCompat.Builder builder = null;
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //버전 오레오 이상일 경우
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            manager.createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            );
            builder = new NotificationCompat.Builder(this,CHANNEL_ID);

            //하위 버전일 경우
        }else{ builder = new NotificationCompat.Builder(this);
        }

        Intent notiIntent = new Intent(this, ScoreActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, notiIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //알림창 제목
        builder.setContentTitle("후기 작성");
        //알림창 메시지
        builder.setContentText("호스트에 대한 후기를 작성하시겠습니까?");
        //알림창 아이콘
        builder.setSmallIcon(android.R.drawable.ic_menu_view);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        //알림창 실행
        manager.notify(1,notification);
    }
}
package com.example.lgd.platformlist;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by lgd on 2017-05-28.
 */

public class turn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.turn);

        Intent intent = getIntent();

        ImageView imageView = (ImageView) findViewById(R.id.imegeView2);

        TextView info = (TextView) findViewById(R.id.info);

        imageView.setImageResource(R.drawable.draw);
        info.setText(intent.getExtras().getString("waitcar") + "\n"
                + intent.getExtras().getString("waittime") + "\n"
                + intent.getExtras().getString("arrivallocation") + "\n"
                + intent.getExtras().getString("arrivaltime") + "\n");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                popup();
            }
        };

        Timer timer = new Timer();

        timer.schedule(timerTask, 1000);
    }

    public void popup(){
        Intent popup = new Intent(this, turn_popup.class);
        startActivity(popup);
    }

}

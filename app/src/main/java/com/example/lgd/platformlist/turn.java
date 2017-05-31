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
    Button next;
    Button back;
    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.turn);

        Intent intent = getIntent();

        ImageView imageView = (ImageView) findViewById(R.id.imegeView2);

        TextView info = (TextView) findViewById(R.id.info);

        imageView.setImageResource(R.drawable.draw);
        info.setText( "대기차량 " + intent.getExtras().getInt("waitcar") + " 대\n"
                + "대기시간 " + intent.getExtras().getInt("waittime") + " 분\n"
                + "도착거리 " + intent.getExtras().getDouble("arrivallocation") + " km\n"
                + "도착시간 " + intent.getExtras().getInt("arrivaltime") + " 분\n");

        next = (Button)findViewById(R.id.nextbtn);
        back = (Button)findViewById(R.id.backbtn);
        main = (Button)findViewById(R.id.mainbtn);

        Intent popup = new Intent(this, turn_popup.class);
        startActivity(popup);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

package com.example.lgd.platformlist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DialogTitle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lgd on 2017-05-29.
 */

public class turn_popup extends AppCompatActivity {
    public static Activity turn_popup;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.turn_popup);

        turn_popup = turn_popup.this;

        final Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.popuptext);

        Button choice = (Button)findViewById(R.id.choice);
        Button cancel = (Button)findViewById(R.id.cancel);
        final Intent intent1 = new Intent(this, realtime.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                finish();
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        return;
    }
}

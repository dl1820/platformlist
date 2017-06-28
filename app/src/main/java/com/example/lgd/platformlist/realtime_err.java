package com.example.lgd.platformlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by LGD on 2017-06-28.
 */

public class realtime_err extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtime_err);
        requestWindowFeature(Window.FEATURE_NO_TITLE);



        Button btn = (Button)findViewById(R.id.realtime_arr_cancle);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

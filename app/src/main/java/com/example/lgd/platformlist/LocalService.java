package com.example.lgd.platformlist;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

public class LocalService extends Service {
    String a1[] = {"10","10","5.4","4"};
    String a2[] = {"5","50","5.7","6"};
    String a3[] = {"4","30","3.2","5"};
    String a4[] = {"3","40","9.0","3"};
    String a5[] = {"2","44","8.7","9"};

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder{
        LocalService getService(){
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Service 객체와 (화면단 Activity 사이에서)
        // 통신(데이터를 주고받을) 때 사용하는 메소드
        return mBinder;
    }

    public String[] getData(int i){
        String data[] = new String[5];
        switch (i){
            case 0:
                data = a1;
                break;
            case 1:
                data = a2;
                break;
            case 2:
                data = a3;
                break;
            case 3:
                data = a4;
                break;
            case 4:
                data = a5;
                break;
        }
        return  data;
    }

}


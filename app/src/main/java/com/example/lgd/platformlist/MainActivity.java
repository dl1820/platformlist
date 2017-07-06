package com.example.lgd.platformlist;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    ArrayList<ListViewItem> lvii;
    LocalService service;
    boolean mBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        lvii = new ArrayList<ListViewItem>();
        ListViewItem listViewItem;

        String a1[] = {"10","10","5.4","4"};
        String a2[] = {"5","50","5.7","6"};
        String a3[] = {"4","30","3.2","5"};
        String a4[] = {"3","40","9.0","3"};
        String a5[] = {"2","44","8.7","9"};

        String data[][] = {a1,a2,a3,a4,a5};

        for (int i = 0; i < 5; i++){
            //String data[] = service.getData(i);
            listViewItem = new ListViewItem(R.drawable.draw, data[i][0] , data[i][1] , data[i][2], data[i][3]);
            lvii.add(listViewItem);
        }

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.listview_item, lvii);

        final ListView listView;
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Intent intent = new Intent(this, LocalService.class);
        bindService(intent, mConnection ,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(mBound){
            unbindService(mConnection);
            mBound = false;
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder mService) {
            LocalService.LocalBinder binder = (LocalService.LocalBinder)mService;
            service = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    public class ListViewAdapter extends BaseAdapter {
        // 어뎁터에 추가된 데이터를 저장하기 위해서
        Context con;
        LayoutInflater inflater;
        ArrayList<ListViewItem> lvi;
        int layout;

        public ListViewAdapter(Context context, int alayout, ArrayList<ListViewItem> lvii){
            con = context;
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            lvi = lvii;
            layout = alayout;
        }

        // 어뎁터에 사용되는 데이터의 개수를 리턴(필수)
        @Override
        public int getCount() {
            return lvi.size();
        }

        @Override
        public Object getItem(int position) {
            return lvi.get(position);
        }

        // 지정한 위치에 있는 데이터 리턴(필수)
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 포지션에 위치한 데이터를 출력하는 뷰를 리턴(필수)
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final int pos = position;

            if (convertView == null){
                convertView = inflater.inflate(layout, parent, false);
            }
            // listview_item 레이아웃을 인플레이트하여 convertView 참조 획득
            ImageView iconImageView = (ImageView)convertView.findViewById(R.id.imegeView1);
            TextView waitcarTextView = (TextView)convertView.findViewById(R.id.waitcar);
            TextView waittimeTextView = (TextView)convertView.findViewById(R.id.waittime);
            TextView arrivallocationTextView = (TextView)convertView.findViewById(R.id.arrivallocation);
            TextView arrivaltimeTextView = (TextView)convertView.findViewById(R.id.arrivaltime);



            // 데이터 반영
            iconImageView.setImageResource(lvi.get(position).iconDrawable);
            waitcarTextView.setText("대기차량 " + lvi.get(position).waitcar + "대");
            waittimeTextView.setText("대기시간 " + lvi.get(position).waittime + "대");
            arrivallocationTextView.setText("도착거리 " + lvi.get(position).arrivallocation + "km");
            arrivaltimeTextView.setText("도착시간 " + lvi.get(position).arrivaltime + "분");

            if (layout == R.layout.listview_item){
                Button button = (Button)convertView.findViewById(R.id.button2);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), turn.class);
                        //intent.putExtra("iv", lvi.get(position).iconDrawable);
                        intent.putExtra("waitcar", lvi.get(position).waitcar);
                        intent.putExtra("waittime", lvi.get(position).waittime);
                        intent.putExtra("arrivallocation", lvi.get(position).arrivallocation);
                        intent.putExtra("arrivaltime", lvi.get(position).arrivaltime);

                        Log.v("asd", "Position : " + position);
                        startActivity(intent);
                    }
                });
            }



            return convertView;
        }
    }
}

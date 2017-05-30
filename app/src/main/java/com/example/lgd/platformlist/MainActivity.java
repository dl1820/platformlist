package com.example.lgd.platformlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        lvii = new ArrayList<ListViewItem>();
        ListViewItem listViewItem;

        int wc[] = {10,5,4,3,2};
        int wt[] = {10,50,30,40,44};
        double al[] = {5.4 , 6.7 , 3.2 , 9.0, 8.7};
        int at[] = {4,6,5,3,9};

        for (int i = 0; i < 5; i++){
            listViewItem = new ListViewItem(R.drawable.draw, "대기차량 " + wc[i] + "대","대기시간 " + wt[i] + "분","도착거리 " + al[i] + "km","도착시간 " + at[i] + "분");
            lvii.add(listViewItem);
        }

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.listview_item, lvii);

        final ListView listView;
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

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
            waitcarTextView.setText(lvi.get(position).waitcar);
            waittimeTextView.setText(lvi.get(position).waittime);
            arrivallocationTextView.setText(lvi.get(position).arrivallocation);
            arrivaltimeTextView.setText(lvi.get(position).arrivaltime);

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

package com.example.lgd.platformlist;

import android.graphics.drawable.Drawable;
import android.widget.ListView;

/**
 * Created by lgd on 2017-05-09.
 */
class ListViewItem {
    int iconDrawable;
    String waitcar;
    String waittime;
    String arrivallocation;
    String arrivaltime;

    ListViewItem(int idb, String wc, String wt, String al, String at){
        iconDrawable = idb;
        waitcar = wc;
        waittime = wt;
        arrivallocation = al;
        arrivaltime = at;
    }
}

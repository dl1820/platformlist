package com.example.lgd.platformlist;

import android.graphics.drawable.Drawable;
import android.widget.ListView;

/**
 * Created by lgd on 2017-05-09.
 */
class ListViewItem {
    int iconDrawable;
    int waitcar;
    int waittime;
    double arrivallocation;
    int arrivaltime;

    ListViewItem(int idb, int wc, int wt, double al, int at){
        iconDrawable = idb;
        waitcar = wc;
        waittime = wt;
        arrivallocation = al;
        arrivaltime = at;
    }
}

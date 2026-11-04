package com.example.lab_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AvionAdapter extends BaseAdapter {

    private List<Avion> avione = null;
    private Context ctx;
    private int resursaLayout;

    public AvionAdapter(List<Avion> avione, Context ctx, int resursaLayout) {
        this.avione = avione;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return avione.size();
    }

    @Override
    public Object getItem(int position) {
        return avione.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout,parent,false);

        //TextView txt1 = v.findViewById(...);

         return v;
    }
}

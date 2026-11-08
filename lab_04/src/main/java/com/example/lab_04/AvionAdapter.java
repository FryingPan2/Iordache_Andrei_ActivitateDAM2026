package com.example.lab_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class AvionAdapter extends BaseAdapter {

    private List<Avion> avione = null;
    private Context ctx;
    private int resursaLayout;

    public AvionAdapter(List<Avion> avione, Context ctx) {
        this.avione = avione;
        this.ctx = ctx;
        //this.resursaLayout = resursaLayout;
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
        View v = inflater.inflate(R.layout.item_layout,parent,false);

        TextView txt1 = v.findViewById(R.id.txt1);
        TextView txt2 = v.findViewById(R.id.txt2);
        TextView txt3 = v.findViewById(R.id.txt3);
        TextView txt4 = v.findViewById(R.id.txt4);
        TextView txt5 = v.findViewById(R.id.txt5);
        TextView txt6 = v.findViewById(R.id.txt6);
        RatingBar rt = v.findViewById(R.id.rt);

        Avion av = (Avion) getItem(position);

        txt1.setText(av.getId());
        txt2.setText(av.getModel());
        txt3.setText(av.getManufacturer());
        txt4.setText(Integer.toString(av.getFlightHours()));
        txt5.setText(Float.toString(av.getValue()));
        txt6.setText(av.getTipAvion());

        rt.setRating(av.getStareTehnica());
         return v;
    }
}

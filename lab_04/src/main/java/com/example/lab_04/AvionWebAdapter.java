package com.example.lab_04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AvionWebAdapter extends BaseAdapter {

    private List<ImagesDomain> avioneWeb = null;
    private Context ctx;
    private int resursaLayout;

    public AvionWebAdapter(List<ImagesDomain> avioneWeb, Context ctx) {
        this.avioneWeb = avioneWeb;
        this.ctx = ctx;
        //this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return avioneWeb.size();
    }

    @Override
    public Object getItem(int position) {
        return avioneWeb.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.item_web_layout,parent,false);

        ImageView Img1 = v.findViewById(R.id.imageV);
        TextView txt = v.findViewById(R.id.imageTxt);

        ImagesDomain av = (ImagesDomain) getItem(position);

        Img1.setImageBitmap(av.getImage());
        txt.setText(av.getTextAfisat());

        View.OnClickListener listener = vw ->{
            Intent it = new Intent(ctx,)
        }
        return v;
    }
}

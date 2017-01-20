package com.m.j.project.josephmay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joseph on 20/01/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Chat> DBdata;

    public CustomAdapter(Context c, ArrayList<Chat> DBdata) {
        this.c = c;
        this.DBdata = DBdata;
    }

    @Override
    public int getCount() {
        return DBdata.size();
    }

    @Override
    public Object getItem(int position) {
        return DBdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }
        TextView temp= (TextView) convertView.findViewById(R.id.temp);
        TextView humi= (TextView) convertView.findViewById(R.id.humi);
        final Chat s= (Chat) this.getItem(position);
        temp.setText(s.getTemp());
        humi.setText(s.getHumi());
        return convertView;
    }
}

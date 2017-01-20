package com.m.j.project.josephmay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by myadmin on 20/01/2017.
 */

public class Adapter extends ArrayAdapter<Chat> {
    public Adapter(Context context, ArrayList<Chat> chat) {
        super(context, 0, chat);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Chat chat = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items, parent, false);
        }
        // Lookup view for data population
        TextView Temp = (TextView) convertView.findViewById(R.id.Temp);
        TextView Humi = (TextView) convertView.findViewById(R.id.Humi);
        // Populate the data into the template view using the data object
        Temp.setText(chat.getTemp());
        Humi.setText(chat.getHumi());
        // Return the completed view to render on screen
        return convertView;
    }
}
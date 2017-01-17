package com.m.j.project.josephmay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference fDatabase;
    ListView listview;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        listview.setAdapter(adapter);


        fDatabase = FirebaseDatabase.getInstance().getReference();


        fDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    String temp = (String) messageSnapshot.child("temp").getValue();
                    String humi = (String) messageSnapshot.child("humi").getValue();
                    String status = (String) messageSnapshot.child("status").getValue();
                    adapter.add(humi + " " + temp + " " + status);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
/*
        }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot) {
                adapter.clear();
                String value = dataSnapshot.getChildren();
                list.add(value);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        });
    }
}
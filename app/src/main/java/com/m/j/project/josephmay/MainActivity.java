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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference fDatabase;
    ListView listview;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        listview.setAdapter(adapter);


        fDatabase = FirebaseDatabase.getInstance().getReference();


        fDatabase.child("messages").child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.child("messages").getValue(String.class);
                adapter.add((String)dataSnapshot.child("messages").getValue());
                list.add(value);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                adapter.clear();
                adapter.add((String)dataSnapshot.child("messages").getValue());
                String value = dataSnapshot.child("messages").getValue(String.class);
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
        });
    }
}

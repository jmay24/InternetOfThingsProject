package com.m.j.project.josephmay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Joseph on 21/02/2017.
 */



public class Humidity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseListAdapter mAdapter;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humi);

        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        } else {
            mUserId = mFirebaseUser.getUid();

            // Set up ListView
            final ListView listView = (ListView) findViewById(R.id.listview);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            listView.setAdapter(adapter);


            mAdapter = new FirebaseListAdapter<DatabaseGetter>(this, DatabaseGetter.class,
                    android.R.layout.two_line_list_item, mDatabase) {
                @Override
                protected void populateView(View view, DatabaseGetter DBentry, int position) {
                    ((TextView) view.findViewById(android.R.id.text1)).setText("System Humidity: " + DBentry.getHumi() + "%");
                }
            };
            listView.setAdapter(mAdapter);
        }


    }
    private void loadLogInView() {
        Intent intent = new Intent(this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
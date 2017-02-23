package com.m.j.project.josephmay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by Joseph on 21/02/2017.
 */

public class Settings extends AppCompatActivity {

    private static final String TAG = "System_Info";
    private FirebaseAuth mFirebaseAuth;
    private FirebaseListAdapter mAdapter;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



        Button subscribeButton = (Button) findViewById(R.id.button);
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // [START subscribe_topics]
                FirebaseMessaging.getInstance().subscribeToTopic("push");
                // [END subscribe_topics]

                // Log and toast
                String msg = ("success");
                Log.d(TAG, msg);
                Toast.makeText(Settings.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

            mUserId = mFirebaseUser.getUid();

            // Set up ListView
            final ListView listView = (ListView) findViewById(R.id.listview);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            listView.setAdapter(adapter);

            //DatabaseGetter item = new DatabaseGetter(23, 23,66, true);
            //mDatabase.child("Item").setValue(item); // Values can be written

            mAdapter = new FirebaseListAdapter<DatabaseGetter>(this, DatabaseGetter.class,
                    android.R.layout.two_line_list_item, mDatabase) {
                @Override
                protected void populateView(View view, DatabaseGetter DBentry, int position) {
                    ((TextView) view.findViewById(android.R.id.text1)).setText("System Serial Number: " + DBentry.getSerial());
                }
            };
            listView.setAdapter(mAdapter);
        }


    }

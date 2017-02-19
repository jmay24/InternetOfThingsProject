package com.m.j.project.josephmay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseListAdapter mAdapter;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;
    protected Button systemInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        } else {
            mUserId = mFirebaseUser.getUid();

            systemInfo = (Button) findViewById(R.id.infoButton);
            systemInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, System_Info.class);
                    startActivity(intent);
                }
            });

            // Set up ListView
            final ListView listView = (ListView) findViewById(R.id.listview);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            listView.setAdapter(adapter);

            //DatabaseGetter item = new DatabaseGetter(23, 23, true);
            //mDatabase.child("Item").setValue(item); // Values can be written

            mAdapter = new FirebaseListAdapter<DatabaseGetter>(this, DatabaseGetter.class,
                    android.R.layout.two_line_list_item, mDatabase) {
                @Override
                protected void populateView(View view, DatabaseGetter DBentry, int position) {
                    ((TextView) view.findViewById(android.R.id.text1)).setText("System Temp: " + DBentry.getTemp() + "c");
                    ((TextView) view.findViewById(android.R.id.text2)).setText("System Stable: " + DBentry.getStatus());
                }
            };
            listView.setAdapter(mAdapter);
        }

/*
            // Use Firebase to populate the list.
            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    adapter.add(String.valueOf((Float) dataSnapshot.child("temp").getValue()));
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    adapter.clear();
                    adapter.add(String.valueOf((Float) dataSnapshot.child("temp").getValue()));

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    adapter.remove((String) dataSnapshot.getValue());
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });*/
          /*  // Delete items when clicked
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mDatabase.child("users").child(mUserId).child("items")
                            .orderByChild("title")
                            .equalTo((String) listView.getItemAtPosition(position))
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.hasChildren()) {
                                        DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                        firstChild.getRef().removeValue();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                }
            });*/
        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
       // mAdapter.cleanup();
    }

    private void loadLogInView() {
        Intent intent = new Intent(this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, LogInActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public static class ContentHolder extends RecyclerView.ViewHolder { // view holder for recycler
        private final TextView mTempField;
        private final TextView mHumiField;

        public ContentHolder(View itemView) {
            super(itemView);
            mTempField = (TextView) itemView.findViewById(android.R.id.text1);
            mHumiField = (TextView) itemView.findViewById(android.R.id.text2);
        }

        public void setTemp(String temp) {
            mTempField.setText(temp);
        }

        public void setHumi(String humi) {
            mHumiField.setText(humi);
        }
    }
}
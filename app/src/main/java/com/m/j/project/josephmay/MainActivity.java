package com.m.j.project.josephmay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference ref;
    ListView listview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final ListView listview = (ListView) findViewById(R.id.listview);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        Chat msg = new Chat(23 , 66);
        ref.push().setValue(msg);


        //DatabaseReference chatRef = ref.child("chatMessage");
        //Query recentMessages = chatRef.limitToLast(5);

        final FirebaseListAdapter<Chat> mAdapter = new FirebaseListAdapter<Chat>(this, Chat.class, android.R.layout.two_line_list_item, ref) {
            @Override
            protected void populateView(View view, Chat chatMessage, int position) {

                ((TextView) view.findViewById(android.R.id.text1)).setText("Temp: " + String.valueOf(chatMessage.getTemp()));
                ((TextView) view.findViewById(android.R.id.text2)).setText("Humitity: " + String.valueOf(chatMessage.getHumi()));

            }
        };

        listview.setAdapter(mAdapter);


        ref.limitToLast(1).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {

            for (DataSnapshot msgSnapshot: snapshot.getChildren()) {
                Chat msg = msgSnapshot.getValue(Chat.class);
                Log.i("Chat", msg.getName()+": " +msg.getMessage());
            }
        }
        @Override
        public void onCancelled(DatabaseError firebaseError) {
            Log.e("Chat", "The read failed: " + firebaseError.getMessage());
        }
    });
    }
}







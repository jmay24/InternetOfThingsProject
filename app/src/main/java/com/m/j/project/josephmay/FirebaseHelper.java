package com.m.j.project.josephmay;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Joseph on 20/01/2017.
 */

public class FirebaseHelper {

    DatabaseReference db;
    ArrayList<Chat> DBData = new ArrayList<>();
    boolean saved;

    public FirebaseHelper (DatabaseReference db){
        this.db = db;
    }

    public void fetchData(DataSnapshot dataSnapshot){
        DBData.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren() ){
            Chat chats = ds.getValue(Chat.class);
            DBData.add(chats);
        }

    }

    public ArrayList<Chat> retrieve(){

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

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


        return DBData;
    }



}

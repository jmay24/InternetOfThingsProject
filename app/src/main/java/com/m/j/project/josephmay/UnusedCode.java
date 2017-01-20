package com.m.j.project.josephmay;

/**
 * Created by myadmin on 20/01/2017.
 */

public class UnusedCode {



    /*
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

        fDatabase.child("jmproject-2f5e3").child("").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

/*
        fDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {

                    adapter.clear();
                   // DatabaseGetter value = messageSnapshot.getValue(DatabaseGetter.class);
                    String temp = (String) messageSnapshot.child("fHumi").getValue();
                    String humi = (String) messageSnapshot.child("fStatus").getValue();
                    String status = (String) messageSnapshot.child("fTemp").getValue();
                    adapter.add(temp + humi + status);
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
}

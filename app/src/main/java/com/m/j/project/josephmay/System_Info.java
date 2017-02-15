package com.m.j.project.josephmay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by Joseph on 15/02/2017.
 */

public class System_Info extends AppCompatActivity {

    private static final String TAG = "System_Info";

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
                Toast.makeText(System_Info.this, msg, Toast.LENGTH_SHORT).show();
            }
        });



    }
}

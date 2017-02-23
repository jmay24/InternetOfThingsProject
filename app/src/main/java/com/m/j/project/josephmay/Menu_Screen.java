package com.m.j.project.josephmay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by Joseph on 19/02/2017.
 */

public class Menu_Screen extends AppCompatActivity {

    private static final String TAG = "Menu_Screen";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // [START subscribe_topics]
        FirebaseMessaging.getInstance().subscribeToTopic("push");
        // [END subscribe_topics]

        // Log and toast
        String msg = ("Connected to Device");
        Log.d(TAG, msg);
        Toast.makeText(Menu_Screen.this, msg, Toast.LENGTH_SHORT).show();

        ImageButton humi = (ImageButton) findViewById(R.id.humiButton);
        humi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Screen.this, Humidity.class);
                startActivity(intent);
            }
        });

        ImageButton temp = (ImageButton) findViewById(R.id.tempButton);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Screen.this, Temperature.class);
                startActivity(intent);
            }
        });

        ImageButton settings = (ImageButton) findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Screen.this, Settings.class);
                startActivity(intent);
            }
        });

        ImageButton vibration = (ImageButton) findViewById(R.id.vibrationButton);
        vibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Screen.this, Vibration.class);
                startActivity(intent);
            }
        });

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
}

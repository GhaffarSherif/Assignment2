package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);

        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
        // DISPLAY MESSAGE THAT IS DELAYED

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent("com.example.cstuser.assignment2.PickInvestorAct");
                startActivity(i);
            }
        }, 3000);

    }
}

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
                startActivityForResult(i, 1);
            }
        }, 3000);
    }

    //Code for returning results through data from Activity 2
    public void onActivityResult(int requestCode, int resultCode, Intent data)   {
        if ((requestCode == 1) && (resultCode == RESULT_OK))    {
            Toast.makeText(this,data.getData().toString(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No investors chosen, bye!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

}


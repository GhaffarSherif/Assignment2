package com.example.cstuser.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by sherif on 2016-03-12.
 */
public class PickInvestorAct extends Activity implements View.OnClickListener {
    Button returnButton;
    Button exitButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickinvestorui);


        returnButton = (Button) this.findViewById(R.id.returnButton);
        exitButton = (Button) this.findViewById(R.id.exitButton);

        returnButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == returnButton.getId()) {

        }
        if (v.getId() == exitButton.getId()){
            finish();
        }
    }
}


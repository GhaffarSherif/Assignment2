package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PickInvestorAct extends Activity implements View.OnClickListener, InvestorInterface {
    Button returnButton;
    Button exitButton;
    CheckBox tonyCheckBox;
    CheckBox mariaCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickinvestorui);


        returnButton = (Button) this.findViewById(R.id.returnButton);
        exitButton = (Button) this.findViewById(R.id.exitButton);
        tonyCheckBox = (CheckBox) this.findViewById(R.id.tonyCheckBox);
        mariaCheckBox =(CheckBox) this.findViewById(R.id.mariaCheckBox);

        returnButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == returnButton.getId()) {
            Intent data = new Intent();

            if(tonyCheckBox.isChecked() && !mariaCheckBox.isChecked()){
                data.setData(Uri.parse(TONY));
            }
            else if (mariaCheckBox.isChecked() && !tonyCheckBox.isChecked()){
                data.setData(Uri.parse(MARIA));
            }
            else if(tonyCheckBox.isChecked() && mariaCheckBox.isChecked()) {
                data.setData(Uri.parse(TONY_AND_MARIA));
            }
            else{
                finish();
            }
            setResult(RESULT_OK, data);
            finish();
        }
        if (v.getId() == exitButton.getId()){
            finish();
        }
    }
}


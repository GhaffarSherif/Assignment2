package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * Created by sherif on 2016-03-12.
 */
public class PickCompTransAct extends Activity implements View.OnClickListener {
    Intent thisIntent;
    TextView investorName;
    RadioButton company1;
    RadioButton company2;
    RadioButton company3;
    RadioButton buy;
    RadioButton sell;
    RadioButton portfolio;
    Button exitButton;
    Button doTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickcomptransui);

        thisIntent = getIntent();
        investorName = (TextView) this.findViewById(R.id.investorName);
        company1 = (RadioButton) this.findViewById(R.id.company1);
        company2 = (RadioButton) this.findViewById(R.id.company2);
        company3 = (RadioButton) this.findViewById(R.id.company3);
        buy = (RadioButton) this.findViewById(R.id.buy);
        sell = (RadioButton) this.findViewById(R.id.sell);
        portfolio = (RadioButton) this.findViewById(R.id.portfolio);
        exitButton = (Button) this.findViewById(R.id.exitButton);
        doTransaction = (Button) this.findViewById(R.id.doTransaction);

        investorName.setText(thisIntent.getStringExtra("chosenInvestor"));

        exitButton.setOnClickListener(this);
        doTransaction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == exitButton.getId()){
            finish();
        }
        else if(v.getId() == doTransaction.getId()){
            Intent i = new Intent("portfolio.DoTransAct");
            startActivityForResult(i, 1);
        }
    }
}


package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;

import portfolio.DoTransAct;
import portfolio.InvestorPortfolio;


/**
 * Created by sherif on 2016-03-12.
 */
public class PickCompTransAct extends Activity implements View.OnClickListener {
    Intent thisIntent;
    Intent i;

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
        DoTransAct.portfolio = new InvestorPortfolio(thisIntent.getStringExtra("chosenInvestor"));

        exitButton.setOnClickListener(this);
        doTransaction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == exitButton.getId()){
            finish();
        }
        else if(v.getId() == doTransaction.getId()){
            addExtras();
            startActivityForResult(i, 1);
        }
    }

    private void addExtras(){
        i = new Intent("portfolio.DoTransAct");

        i.putExtra("investorName", thisIntent.getStringExtra("chosenInvestor"));

        if(company1.isChecked()){
            i.putExtra("chosenCompany", "1");
        }
        else if(company2.isChecked()){
            i.putExtra("chosenCompany", "2");
        }
        else if(company3.isChecked()){
            i.putExtra("chosenCompany", "3");
        }

        if(buy.isChecked()){
            i.putExtra("transactionType", "B");
        }
        else if(sell.isChecked()){
            i.putExtra("transactionType", "S");
        }
        else if(portfolio.isChecked()){
            i.putExtra("transactionType", "P");
        }
    }
}


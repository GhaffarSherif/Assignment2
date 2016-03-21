package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import portfolio.DoTransAct;
import portfolio.InvestorPortfolio;


public class PickCompTransAct extends Activity implements View.OnClickListener, InvestorInterface {
    Intent i;
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
        company1.setOnClickListener(this);
        company2 = (RadioButton) this.findViewById(R.id.company2);
        company2.setOnClickListener(this);
        company3 = (RadioButton) this.findViewById(R.id.company3);
        company3.setOnClickListener(this);

        buy = (RadioButton) this.findViewById(R.id.buy);
        sell = (RadioButton) this.findViewById(R.id.sell);
        portfolio = (RadioButton) this.findViewById(R.id.portfolio);

        makeUnclickable();


        exitButton = (Button) this.findViewById(R.id.exitButton);
        doTransaction = (Button) this.findViewById(R.id.doTransaction);

        investorName.setText(thisIntent.getStringExtra(CHOSEN_INVESTOR));

        if(!thisIntent.getBooleanExtra(PORTFOLIO_CREATED, false))
            DoTransAct.portfolio = new InvestorPortfolio(thisIntent.getStringExtra(CHOSEN_INVESTOR));

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
        else if(v.getId() == company1.getId()){
            buy.setClickable(true);
            sell.setClickable(true);
        }
        else if(v.getId() == company2.getId()){
            buy.setClickable(true);
            sell.setClickable(true);
        }
        else if(v.getId() == company3.getId()){
            buy.setClickable(true);
            sell.setClickable(true);
        }
    }

    private void addExtras(){
        i = new Intent("portfolio.DoTransAct");

        i.putExtra(INVESTOR_NAME, thisIntent.getStringExtra(CHOSEN_INVESTOR));

        if(company1.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY1);
        else if(company2.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY2);
        else if(company3.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY3);
        else
            i.putExtra(CHOSEN_COMPANY, NO_COMPANY);

        if(buy.isChecked())
            i.putExtra(TRANSACTION_TYPE, BUY_LETTER);
        else if(sell.isChecked())
            i.putExtra(TRANSACTION_TYPE, SELL_LETTER);
        else if(portfolio.isChecked())
            i.putExtra(TRANSACTION_TYPE, PORTFOLIO_LETTER);
    }

    private void makeUnclickable() {
        if (!company1.isChecked() || !company2.isChecked() || !company3.isChecked()){
            buy.setClickable(false);
            sell.setClickable(false);
        }
    }
}


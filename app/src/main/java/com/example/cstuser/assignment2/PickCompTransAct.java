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

/**
 * This class will allow a user to select a company and a transaction type. Additionally, the user
 * can choose to only view their portfolio, in which case a company is not required to be selected.
 */
public class PickCompTransAct extends Activity implements View.OnClickListener, InvestorInterface {
    Intent i; //The intent to be sent to DoTransAct.java
    Intent thisIntent; //The intent passed to this program

    //Various elements found in the UI
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

        //Initializing the fields
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

        exitButton = (Button) this.findViewById(R.id.exitButton);
        doTransaction = (Button) this.findViewById(R.id.doTransaction);

        investorName.setText(thisIntent.getStringExtra(CHOSEN_INVESTOR));

        if(!thisIntent.getBooleanExtra(PORTFOLIO_CREATED, false))
            DoTransAct.portfolio = new InvestorPortfolio(thisIntent.getStringExtra(CHOSEN_INVESTOR));

        exitButton.setOnClickListener(this);
        doTransaction.setOnClickListener(this);
    }

    //OnClick listeners for the exit button and do transaction button
    @Override
    public void onClick(View v) {
        if (v.getId() == exitButton.getId()){
            finish();
        }
        else if(v.getId() == doTransaction.getId()){
            if(portfolio.isChecked()) {
                addExtras();
                startActivityForResult(i, 1);
            }
            else if(buy.isChecked() || sell.isChecked()){
                if(company1.isChecked() || company2.isChecked() || company3.isChecked()){
                    addExtras();
                    startActivityForResult(i, 1);
                }
            }
        }
    }

    /**
     * Initializes the Intent i and adds the necessary extras to it
     */
    private void addExtras(){
        i = new Intent("portfolio.DoTransAct");

        //Adds the investor's name as an extra
        i.putExtra(INVESTOR_NAME, thisIntent.getStringExtra(CHOSEN_INVESTOR));

        //Adds the company's name as an extra. Puts the NO_COMPANY constant if no company is selected
        if(company1.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY1);
        else if(company2.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY2);
        else if(company3.isChecked())
            i.putExtra(CHOSEN_COMPANY, COMPANY3);
        else
            i.putExtra(CHOSEN_COMPANY, NO_COMPANY);

        //Adds the transaction type as an extra
        if(buy.isChecked())
            i.putExtra(TRANSACTION_TYPE, BUY_LETTER);
        else if(sell.isChecked())
            i.putExtra(TRANSACTION_TYPE, SELL_LETTER);
        else if(portfolio.isChecked())
            i.putExtra(TRANSACTION_TYPE, PORTFOLIO_LETTER);
    }
}


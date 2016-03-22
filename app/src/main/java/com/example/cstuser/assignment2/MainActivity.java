package com.example.cstuser.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class contains the methods to run the Main user interface
 */
public class MainActivity extends Activity implements View.OnClickListener, InvestorInterface {
    // Widgets we will use in this class from the mainui.xml
    Button exitButton;
    Button continueButton;
    TextView labelTextView;
    TextView investorsTextView;

    String chosenInvestor; // Name of investor that is chosen

    @Override
    protected void onCreate(Bundle savedInstanceState) { // When class is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);

        // Initializing Buttons and listeners for them
        exitButton = (Button) this.findViewById(R.id.exitButton);
        continueButton = (Button) this.findViewById(R.id.continueButton);
        labelTextView = (TextView) this.findViewById(R.id.labelTextView);
        investorsTextView = (TextView) this.findViewById(R.id.investorsTextView);

        exitButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);

        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() { // New activity start is delayed
            @Override
            public void run() {
                Intent i = new Intent("com.example.cstuser.assignment2.PickInvestorAct");
                startActivityForResult(i, 1);
            }
        }, 3000);
    }

    /**
     * When PickCompTransAct return a value, it will land in this method
     * @param requestCode Code for when sending data
     * @param resultCode Code for when receiving data
     * @param data The data that will hold the investor name
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data)   {
        if ((requestCode == 1) && (resultCode == RESULT_OK)) { //AFTER INVESTORS ARE CHOSEN AND RETURN TO MAINACTIVITY
            showWidgets(); // Make widgets visible
            Toast.makeText(this,data.getData().toString(), Toast.LENGTH_SHORT).show(); //ONLY FOR TESTING
            chosenInvestor = data.getData().toString();
            investorsTextView.setText(chosenInvestor);
        }
        else {
            Toast.makeText(this, "Bye!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) { // OnClick listeners for exit and continue buttons
        if (v.getId() == exitButton.getId()){
            finish();
        }
        else if (v.getId() == continueButton.getId()){
            Intent i = new Intent("com.example.cstuser.assignment2.PickCompTransAct");

            Bundle investor = new Bundle();
            investor.putString(CHOSEN_INVESTOR, chosenInvestor);
            i.putExtras(investor);
            startActivityForResult(i, 1);
        }
    }

    /**
     * This method will change the visibility of the widgets that are on the screen which will be used when we return to mainactivty
     */
    private void showWidgets(){
        exitButton.setVisibility(View.VISIBLE);
        continueButton.setVisibility(View.VISIBLE);
        labelTextView.setVisibility(View.VISIBLE);
    }
}
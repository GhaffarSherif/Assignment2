package portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cstuser.assignment2.InvestorInterface;
import com.example.cstuser.assignment2.R;

public class DoTransAct extends Activity implements View.OnClickListener, InvestorInterface {
    Intent thisIntent;
    String transactionType;

    TextView portfolioDisplay;
    TextView companyName;
    TextView currentStocks;
    TextView availableCash;

    EditText price;
    EditText quantity;
    Button performTransaction;

    public static InvestorPortfolio portfolio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotransui);

        thisIntent = getIntent();
        transactionType = thisIntent.getStringExtra(TRANSACTION_TYPE);

        portfolioDisplay = (TextView) this.findViewById(R.id.portfolioDisplay);
        companyName = (TextView) this.findViewById(R.id.companyName);
        companyName.setText(thisIntent.getStringExtra(CHOSEN_COMPANY));
        currentStocks = (TextView) this.findViewById(R.id.currentStocks);

        setCurrentStocks();

        availableCash = (TextView) this.findViewById(R.id.availableCash);
        availableCash.setText(availableCash.getText().toString() + " " + portfolio.cashAvailable);

        price = (EditText) this.findViewById(R.id.price);
        quantity = (EditText) this.findViewById(R.id.quantity);
        performTransaction = (Button) this.findViewById(R.id.performTransaction);
        performTransaction.setOnClickListener(this);

        portfolioDisplay.setText(portfolio.getPortfolioTransactions());

        setUpButtons();
    }

    public void onClick(View v){
        if(v.getId() == performTransaction.getId()){
            int enteredPrice = Integer.parseInt(price.getText().toString());
            if(enteredPrice >= 1 && enteredPrice <= 10){
                if(transactionType.equals("B")){
                    int enteredQuantity = Integer.parseInt(quantity.getText().toString());
                    if(enteredQuantity > 0) {
                        if (enteredQuantity * enteredPrice <= portfolio.cashAvailable) {
                            portfolio.buyStocks(companyName.getText().toString(), enteredQuantity, enteredPrice);
                            alertMessage();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Insufficient funds!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Invalid quantity!", Toast.LENGTH_SHORT).show();
                }
                else if(transactionType.equals("S")){
                    portfolio.sellStocks(companyName.getText().toString(), enteredPrice);
                    alertMessage();
                }
            }
            else
                Toast.makeText(getApplicationContext(), "Invalid price!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Adds current amount of stocks for a given company.
     */
    private void setCurrentStocks(){
        String selectedCompany = companyName.getText().toString();
        String currentStocksText = currentStocks.getText().toString() + " ";

        if(selectedCompany.equals(COMPANY1))
            currentStocks.setText(currentStocksText + portfolio.company1Stocks);
        else if(selectedCompany.equals(COMPANY2))
            currentStocks.setText(currentStocksText + portfolio.company2Stocks);
        else if(selectedCompany.equals(COMPANY3))
            currentStocks.setText(currentStocksText + portfolio.company3Stocks);
    }

    /**
     * Hides/Unhides buttons as necessary.
     */
    private void setUpButtons(){
        if(transactionType.equals(BUY_LETTER)){
            price.setVisibility(View.VISIBLE);
            quantity.setVisibility(View.VISIBLE);
        }
        else if(transactionType.equals(SELL_LETTER)){
            price.setVisibility(View.VISIBLE);
        }
        else if(transactionType.equals(PORTFOLIO_LETTER)){
            price.setVisibility(View.INVISIBLE);
            performTransaction.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Creates and displays a confirmation message to check if the user would like to enter more values.
     */
    private void alertMessage() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent i = new Intent("com.example.cstuser.assignment2.PickCompTransAct");
                        i.putExtra(INVESTOR_NAME, thisIntent.getStringExtra(INVESTOR_NAME));
                        i.putExtra(PORTFOLIO_CREATED, true);
                        startActivity(i);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        finish();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to perform another transaction?")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}

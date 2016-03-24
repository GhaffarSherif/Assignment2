package portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cstuser.assignment2.InvestorInterface;
import com.example.cstuser.assignment2.R;

public class DoTransAct extends Activity implements View.OnClickListener, InvestorInterface {
    Intent thisIntent; //The intent passed to this program
    String transactionType; //String containing the transaction type

    //Various elements found in the UI
    TextView portfolioDisplay;
    TextView companyName;
    TextView currentStocks;
    TextView availableCash;

    EditText price;
    EditText quantity;
    Button performTransaction;

    //TableLayout asdf;

    public static InvestorPortfolio portfolio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotransui);

        //Initialize the fields
        thisIntent = getIntent();
        transactionType = thisIntent.getStringExtra(TRANSACTION_TYPE);

        //portfolioDisplay = (TextView) this.findViewById(R.id.portfolioDisplay);

        /* I THINK I FIGURED THIS SHIT OUT :D
        asdf = (TableLayout) this.findViewById(R.id.tableLayout);
        TableRow asdfRow = (TableRow) asdf.getChildAt(0);
        int childCount = asdf.getChildCount();
        asdf.addView(asdfRow, childCount-2);
        */

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
            if(!price.getText().toString().isEmpty()) { //Verify that something was entered for the price
                double enteredPrice = Double.parseDouble(price.getText().toString());
                if (enteredPrice >= PRICE_LOWER_LIMIT && enteredPrice <= PRICE_UPPER_LIMIT) { //Verify that the price is within the limits
                    if (transactionType.equals("B")) {
                        if(!quantity.getText().toString().isEmpty()) { //Verify that something was entered for the quantity
                            int enteredQuantity = Integer.parseInt(quantity.getText().toString());
                            if (enteredQuantity > 0) { //Verify that the quantity in a non-negative, non-zero number
                                if (enteredQuantity*enteredPrice <= portfolio.cashAvailable) { //Verify that the investor has enough money for the purchase
                                    portfolio.buyStocks(companyName.getText().toString(), enteredQuantity, enteredPrice);
                                    alertMessage();
                                }
                                else
                                    Toast.makeText(getApplicationContext(), "Insufficient funds!", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(getApplicationContext(), "Invalid quantity!", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Please enter a quantity!", Toast.LENGTH_SHORT).show();
                    }
                    else if (transactionType.equals("S")) {
                        portfolio.sellStocks(companyName.getText().toString(), enteredPrice);
                        alertMessage();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "Invalid price!", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Please enter a price!", Toast.LENGTH_SHORT).show();
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
                        i.putExtra(CHOSEN_INVESTOR, thisIntent.getStringExtra(CHOSEN_INVESTOR));
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

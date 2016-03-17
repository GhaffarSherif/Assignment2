package portfolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cstuser.assignment2.R;

/**
 * Created by sherif on 2016-03-17.
 */
public class DoTransAct extends Activity {
    Intent thisIntent;
    TextView portfolioDisplay;

    public static InvestorPortfolio portfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dotransui);

        thisIntent = getIntent();
        portfolioDisplay = (TextView) this.findViewById(R.id.portfolioDisplay);

        if(thisIntent.getStringExtra("transactionType").equals("P")){
            portfolioDisplay.setText(portfolio.getPortfolioTransactions());
        }
    }

    //IN ONCLICK VALIDATE PRICE!!!
    //AND VALIDATE COST OF PURCHASE!!!
}

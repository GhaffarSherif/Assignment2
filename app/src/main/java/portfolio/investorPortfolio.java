package portfolio;

import java.util.ArrayList;
/**
 * Created by sherif on 2016-03-17.
 */
public class investorPortfolio {
    String investorName;
    String company;
    int transactionNumber;
    int cashAvailable;
    int company1Stocks;
    int company2Stocks;
    int company3Stocks;
    int company1UnitPrice;
    int company2UnitPrice;
    int company3UnitPrice;
    char transactionType;

    String transactionOutput="";

    public investorPortfolio(String name){
        if (name.equals("tony")){


        }
        else if (name.equals("maria")){

        }
        else if (name.equals("tony&maria")){

        }

    }
    // Return all the transactions for this portfolio
    public String getPortfolioTransactions(){
        return transactionOutput;
    }

    // setup portfolio for tony
    private void setTonyPortfolio(){
        cashAvailable = 1000;
        investorName = "tony";
        //Trasaction 1
        transactionNumber = 1;
        company = "Company 1";
        transactionType = 'B';
        company1Stocks = 80;
        company1UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company1Stocks, company1UnitPrice);

        //Transaction 2
        transactionNumber = 2;
        company = "Company 2";
        transactionType = 'B';
        company2Stocks= 50;
        company2UnitPrice = 9;
        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);


    }
    //setup portfolio for maria
    private void setMariaPortfolio(){
        cashAvailable = 2000;
        investorName = "maria";

        //Trasaction 1
        transactionNumber = 1;
        company = "Company 2";
        transactionType = 'B';
        company2Stocks = 50;
        company2UnitPrice = 9;

        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);

        //Transaction 2
        transactionNumber = 2;
        company = "Company 3";
        transactionType = 'B';
        company3Stocks= 70;
        company3UnitPrice = 5;
        createRow(transactionNumber, company, transactionType, company3Stocks, company3UnitPrice);
    }
    //Set up portfolio of maria and tony combined
    private void setBothPortfolio(){
        cashAvailable = 3000;
        investorName = "tony&maria";

        //Trasaction 1
        transactionNumber = 1;
        company = "Company 1";
        transactionType = 'B';
        company1Stocks = 80;
        company1UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company1Stocks, company1UnitPrice);

        //Transaction2
        transactionNumber = 2;
        company = "Company 2";
        transactionType = 'B';
        company2Stocks = 100;
        company2UnitPrice = 9;

        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);

        //Transaction3
        transactionNumber = 3;
        company = "Company 3";
        transactionType = 'B';
        company3Stocks = 70;
        company3UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company3Stocks, company3UnitPrice);

    }

    //Creates row for each transaction and appends to transactionOutput
    private String createRow(int transactionNumber, String company, char transactionType, int quantity, int unitPrice){
        transactionOutput += transactionNumber + "\t" + company + "\t" + transactionType + "\t" + quantity + "\t" +  quantity*unitPrice + "\n";
        return transactionNumber + "\t" + company + "\t" + transactionType + "\t" + quantity + "\t" +  quantity*unitPrice; //quantity*unitPrice is TOTAL
    }

}

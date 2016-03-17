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
            setTonyPortfolio();
        }
        else if (name.equals("maria")){
            setMariaPortfolio();
        }
        else if (name.equals("tony&maria")){
            setBothPortfolio();
        }

    }
    public void sellStocks(String company, int sellPrice){ // sell all stocks
        int amount; //amount made ater stocks are sold
        if (company.equals("Company 1")){
            amount = company1Stocks*sellPrice;
            company1Stocks =0;
            cashAvailable+= amount;
            transactionType = 'S';
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company1Stocks, sellPrice);
        }
        else if (company.equals("Company 2")){
            amount = company2Stocks*sellPrice;
            company2Stocks =0;
            cashAvailable+= amount;
            transactionType = 'S';
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company2Stocks, sellPrice);
        }
        else{
            amount = company3Stocks*sellPrice;
            company3Stocks =0;
            cashAvailable+= amount;
            transactionType = 'S';
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company3Stocks, sellPrice);
        }
    }
    public void buyStocks(String Company, int amount){

    }

    // Return all the transactions for this portfolio
    public String getPortfolioTransactions(){
        return transactionOutput;
    }

    // setup portfolio for tony
    private void setTonyPortfolio(){

        investorName = "tony";
        cashAvailable = 1000;
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

        investorName = "maria";
        cashAvailable = 2000;

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

        investorName = "tony&maria";
        cashAvailable = 3000;

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

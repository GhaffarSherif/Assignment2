package portfolio;

import com.example.cstuser.assignment2.InvestorInterface;

public class InvestorPortfolio implements InvestorInterface {
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
    String transactionType;

    String transactionOutput = PORTFOLIO_HEADER;

    public InvestorPortfolio(String name){
        if (name.equals(TONY)){
            setTonyPortfolio();
        }
        else if (name.equals(MARIA)){
            setMariaPortfolio();
        }
        else if (name.equals(TONY_AND_MARIA)){
            setBothPortfolio();
        }
    }
    public void sellStocks(String company, int sellPrice){ // sell all stocks
        int amount; //Amount made after stocks are sold
        if (company.equals(COMPANY1)){
            amount = company1Stocks*sellPrice;
            company1Stocks = 0;
            cashAvailable+= amount;
            transactionType = SELL_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company1Stocks, sellPrice);
        }
        else if (company.equals(COMPANY2)){
            amount = company2Stocks*sellPrice;
            company2Stocks = 0;
            cashAvailable += amount;
            transactionType = SELL_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company2Stocks, sellPrice);
        }
        else{
            amount = company3Stocks*sellPrice;
            company3Stocks = 0;
            cashAvailable += amount;
            transactionType = SELL_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company3Stocks, sellPrice);
        }
    }

    //TO DO
    public void buyStocks(String company, int stocksAmount, int buyPrice){
        int amount;
        if (company.equals(COMPANY1)){
            amount = company1Stocks*buyPrice;
            company3Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company3Stocks, buyPrice);
        }
        else if (company.equals(COMPANY2)) {
            amount = company2Stocks*buyPrice;
            company2Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company2Stocks, buyPrice);
        }
        else {
            amount = company3Stocks*buyPrice;
            company3Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, company3Stocks, buyPrice);
        }
    }

    //Return all the transactions for this portfolio
    public String getPortfolioTransactions(){
        return transactionOutput;
    }

    //Setup portfolio for tony
    private void setTonyPortfolio(){

        investorName = TONY;
        cashAvailable = 1000;

        //Transaction 1
        transactionNumber = 1;
        company = COMPANY1;
        transactionType = BUY_LETTER;
        company1Stocks = 80;
        company1UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company1Stocks, company1UnitPrice);

        //Transaction 2
        transactionNumber = 2;
        company = COMPANY2;
        transactionType = BUY_LETTER;
        company2Stocks= 50;
        company2UnitPrice = 9;
        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);
    }

    //Setup portfolio for maria
    private void setMariaPortfolio(){

        investorName = MARIA;
        cashAvailable = 2000;

        //Transaction 1
        transactionNumber = 1;
        company = COMPANY2;
        transactionType = BUY_LETTER;
        company2Stocks = 50;
        company2UnitPrice = 9;

        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);

        //Transaction 2
        transactionNumber = 2;
        company = COMPANY3;
        transactionType = BUY_LETTER;
        company3Stocks= 70;
        company3UnitPrice = 5;
        createRow(transactionNumber, company, transactionType, company3Stocks, company3UnitPrice);
    }

    //Set up portfolio of maria and tony combined
    private void setBothPortfolio(){

        investorName = TONY_AND_MARIA;
        cashAvailable = 3000;

        //Transaction 1
        transactionNumber = 1;
        company = COMPANY1;
        transactionType = BUY_LETTER;
        company1Stocks = 80;
        company1UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company1Stocks, company1UnitPrice);

        //Transaction2
        transactionNumber = 2;
        company = COMPANY2;
        transactionType = BUY_LETTER;
        company2Stocks = 100;
        company2UnitPrice = 9;

        createRow(transactionNumber, company, transactionType, company2Stocks, company2UnitPrice);

        //Transaction3
        transactionNumber = 3;
        company = COMPANY3;
        transactionType = BUY_LETTER;
        company3Stocks = 70;
        company3UnitPrice = 5;

        createRow(transactionNumber, company, transactionType, company3Stocks, company3UnitPrice);
    }

    //Creates row for each transaction and appends to transactionOutput
    private void createRow(int transactionNumber, String company, String transactionType, int quantity, int unitPrice){
        transactionOutput += String.format("%-19s", transactionNumber) + String.format("%-17s", company) + String.format("%-17s", transactionType) + String.format("%9s", quantity) +  String.format("%8s", quantity*unitPrice) + "\n";
    }
}
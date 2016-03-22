package portfolio;

import com.example.cstuser.assignment2.InvestorInterface;

/**
 * This class will create an individual portfolio that will keep track of stocks, price and cash for an investor
 */
public class InvestorPortfolio implements InvestorInterface {
    // The following are data members necissary to keep track of the stocks of different companies and their price
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

    String transactionOutput = PORTFOLIO_HEADER; //Header for the output

    /**
     * Constructor that creates a portolio or either Tony, Maria or both
     * @param name carries that name of the investor to copy their portfolio
     */
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

    /**
     * This method will sell ALL stocks of a selected company
     * @param company The company name that we want to sell stocks from
     * @param sellPrice The price from 1-10 to sell these stocks
     */
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

    /**
     * Buy stocks from selected company for a certain price
     * @param company name of company we want to buy from
     * @param stocksAmount the amount of stocks we want to buy
     * @param buyPrice the price we want to pay per stock
     */
    public void buyStocks(String company, int stocksAmount, int buyPrice){
        int amount;
        if (company.equals(COMPANY1)){
            amount = stocksAmount*buyPrice;
            company1Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, stocksAmount, buyPrice);
        }
        else if (company.equals(COMPANY2)) {
            amount = stocksAmount*buyPrice;
            company2Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, stocksAmount, buyPrice);
        }
        else {
            amount = stocksAmount*buyPrice;
            company3Stocks += stocksAmount;
            cashAvailable -= amount;
            transactionType = BUY_LETTER;
            transactionNumber++;
            createRow(transactionNumber, company, transactionType, stocksAmount, buyPrice);
        }
    }

    /**
     * Return all the transactions for this portfolio
     * @return Return all the transactions for this portfolio
     */
    public String getPortfolioTransactions(){
        return transactionOutput;
    }

    /**
     * Setting up the portfolo according to Tony's inital table
     */
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

    /**
     * Setting up the portfolo according to Maria's inital table
     */
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

    /**
     * * Setting up the portfolo according to Ton and Maria's  inital tables combined
     */
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

    /**
     * Creates row for each transaction and appends to transactionOutput
     * @param transactionNumber the transaction number
     * @param company the company name
     * @param transactionType the type of transaction (either B, S or P)
     * @param quantity number of stocks bought or sold
     * @param unitPrice Price per stock bought or sold
     */
    private void createRow(int transactionNumber, String company, String transactionType, int quantity, int unitPrice){
        transactionOutput += String.format("%-19s", transactionNumber) + String.format("%-13s", company) + String.format("%-17s", transactionType) + String.format("%9s", quantity) +  String.format("%8s", quantity*unitPrice) + "\n";
    }
}
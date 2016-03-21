package com.example.cstuser.assignment2;

public interface InvestorInterface {
    public String PORTFOLIO_HEADER = String.format("%-19s", "Transaction Number") + String.format("%-17s", "Company Name") + String.format("%-17s", "Transaction Type") + String.format("%9s", "Quantity") +  String.format("%8s", "Total") + "\n\n";

    public String TONY = "Tony";
    public String MARIA = "Maria";
    public String TONY_AND_MARIA = "Tony & Maria";

    public String COMPANY1 = "Company 1";
    public String COMPANY2 = "Company 2";
    public String COMPANY3 = "Company 3";
    public String NO_COMPANY = "No company selected";

    public String CHOSEN_COMPANY = "chosenCompany";
    public String CHOSEN_INVESTOR = "chosenInvestor";
    public String INVESTOR_NAME = "investorName";
    public String TRANSACTION_TYPE = "transactionType";
    public String PORTFOLIO_CREATED = "portfolioIsCreated";

    public String BUY_LETTER = "B";
    public String SELL_LETTER = "S";
    public String PORTFOLIO_LETTER = "P";
}

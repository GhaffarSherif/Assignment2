package com.example.cstuser.assignment2;

public interface InvestorInterface {
    String PORTFOLIO_HEADER = String.format("%-19s", "Transaction Number") + String.format("%-13s", "Company Name") + String.format("%-17s", "Transaction Type") + String.format("%9s", "Quantity") +  String.format("%8s", "Total") + "\n\n";

    String TONY = "Tony";
    String MARIA = "Maria";
    String TONY_AND_MARIA = "Tony & Maria";

    String COMPANY1 = "Company 1";
    String COMPANY2 = "Company 2";
    String COMPANY3 = "Company 3";
    String NO_COMPANY = "No company selected";

    String CHOSEN_COMPANY = "chosenCompany";
    String CHOSEN_INVESTOR = "chosenInvestor";
    String INVESTOR_NAME = "investorName";
    String TRANSACTION_TYPE = "transactionType";
    String PORTFOLIO_CREATED = "portfolioIsCreated";

    String BUY_LETTER = "B";
    String SELL_LETTER = "S";
    String PORTFOLIO_LETTER = "P";
}

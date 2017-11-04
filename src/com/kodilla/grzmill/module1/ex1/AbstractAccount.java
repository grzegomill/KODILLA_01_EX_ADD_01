package com.kodilla.grzmill.module1.ex1;

abstract class  AbstractAccount implements  Account{
    protected String accountName;
    protected double accountBalance;

     AbstractAccount(String accountName, double accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

}

package com.kodilla.grzmill.module1.ex1;

interface Bank {
    void doCardOperationOnAccount(String accountName, CardOperation operation, double atmCommission);

    public double getATMCommisssion();
}

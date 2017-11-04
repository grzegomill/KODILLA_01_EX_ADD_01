package com.kodilla.grzmill.module1.ex1;

public class DepositOperation implements CardOperation {
    private double amount;

    public DepositOperation(double amount) {
        this.amount = amount;
    }
    @Override
    public double getOperationValue() {
        return this.amount;
    }
}

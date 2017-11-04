package com.kodilla.grzmill.module1.ex1;

public class WithdrawOpeation implements CardOperation {
    private double amount;

    public WithdrawOpeation(double amount) {
        this.amount = amount;
    }

    @Override
    public double getOperationValue() {
        return this.amount;
    }


}

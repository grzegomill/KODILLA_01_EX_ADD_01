package com.kodilla.grzmill.module1.ex1;

class CreditAccount extends AbstractAccount {

    double accountCredit;

    public CreditAccount(String accountName, double accountBalance, double accountCredit) {
        super(accountName, accountBalance);
        this.accountCredit = accountCredit;
    }

    @Override
    public String getName() {
        return super.accountName;
    }

    @Override
    public double getValue() {
        return super.accountBalance + this.accountCredit;  // wartosc  z linia kredytowa
    }

    @Override
    public void doOperation(double value, String comment) {
        System.out.println("Konto: "+this.getName() +" Saldo przed operacja: " + this.getValue());
        System.out.println(comment + " " + value);
        double tmpAmount = super.accountBalance + value;
        if (tmpAmount < 0) {
            super.accountBalance = 0;
            this.accountCredit = this.accountCredit + tmpAmount;
        } else {
            super.accountBalance = tmpAmount;
        }
        System.out.println("Konto: "+this.getName() +" Saldo po operacji: " +this.getValue());
    }

}


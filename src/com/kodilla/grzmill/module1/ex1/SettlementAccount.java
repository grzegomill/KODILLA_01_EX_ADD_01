package com.kodilla.grzmill.module1.ex1;

class SettlementAccount  extends AbstractAccount {

    public SettlementAccount(String accountName, double accountBalance) {
        super(accountName, accountBalance);
    }

    @Override
    public String getName() {
        return super.accountName;
    }

    @Override
    public double getValue() {
        return super.accountBalance;
    }

    @Override
    public void doOperation(double value, String comment) {
        System.out.println("Konto: "+this.getName() +" Saldo przed operacja: " + this.getValue());
        System.out.println( comment + " " + value);
        super.accountBalance = super.accountBalance +value;
        System.out.println("Konto: "+this.getName() +" Saldo po operacji: " +this.getValue());
    }
}



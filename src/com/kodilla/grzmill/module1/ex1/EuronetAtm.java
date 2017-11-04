package com.kodilla.grzmill.module1.ex1;

class EuronetAtm implements Atm {
    private Bank bank;

    protected static final double EuronetCommission = 5;

    public EuronetAtm(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void doCardOperation(Card card, CardOperation operation) {
        this.bank.doCardOperationOnAccount(card.getConnectedCardName(), operation, this.EuronetCommission);
    }
}

package com.kodilla.grzmill.module1.ex1;

class CardImpl implements Card{
private String cardType;

    public CardImpl(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String getConnectedCardName() {
        return cardType;
    }
}

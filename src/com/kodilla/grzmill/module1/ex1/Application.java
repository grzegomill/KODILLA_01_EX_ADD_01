/**
 * Mamy dwa rozne typy kont, jedno rozliczeniowe, drugie kredytowe.
 * Na koncie kredytowa mozna zrobic debet ale tylko do ustalonego limitu.

 * Mamy bank, ktory ma w sobie oba konta.
 * Mamy bankomat Euronetu ktory jest polaczony z bankiem. Bankomat obsluguje karty i jest tez wplatomatem
 * wiec mozna w nim robic zarowno operacje wybrania jak i wplacenia pieniedzy
 * (kazda operacja jest specyficzna klasa
 * interfejsu CardOperation).
 *
 * Bankomat Euronetu pozwala na bezprowizyjna wyplate, jednak przy wplacie pobiera z kwoty wplaty 5 zl prowizji.

 * Do Ciebie nalezy implementacja klas, jesli bedzie taka potrzeba mozesz dopisywac/zmieniac interfejsy.
 */
package com.kodilla.grzmill.module1.ex1;
public class Application {

    public static void main(String[] args) {

        final Account settlementAccount = new SettlementAccount("settlement", 1000.0); // tysiac na koncie rozliczeniowym

        final Account creditAccount = new CreditAccount("credit", 500.0, 2000.0); // 500 na koncie, 2000 limitu kredytowego na koncie kredytowym

        final Bank pko = new PkoBank(settlementAccount, creditAccount); // bank z dowma kontami

        final Atm atm = new EuronetAtm(pko); // bankomat polaczony z bankiem

        final Card settlementCard = new CardImpl("settlement"); // karta podlaczona do konta rozliczeniowego
        final Card creditCard = new CardImpl("credit"); // karta podlaczona do konta kredytowego

        final CardOperation withdrawOperation = new WithdrawOpeation(1500.0); // operacja wybrania pieniedzy z baku

        final CardOperation depositOperation   = new DepositOperation(1500.0); // operacja depozytu pieniedzy  -(wplaty)


        atm.doCardOperation( creditCard, depositOperation);
        atm.doCardOperation( creditCard, withdrawOperation);
        atm.doCardOperation( creditCard, new WithdrawOpeation(995.0) );
        atm.doCardOperation( creditCard, new DepositOperation(50) );

        atm.doCardOperation( settlementCard, depositOperation);
        atm.doCardOperation( settlementCard, withdrawOperation);
        atm.doCardOperation( settlementCard, new WithdrawOpeation(995.0) );
        atm.doCardOperation( settlementCard, new DepositOperation(10) );



    }
}



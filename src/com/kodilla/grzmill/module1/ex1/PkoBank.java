package com.kodilla.grzmill.module1.ex1;

class PkoBank implements Bank {

    private Account settlementAccount;
    private Account creditAccount;
    private double atmCommissionSum;
    private double atmCommission;

    public PkoBank(Account settlementAccount, Account creditAccount) {

        this.settlementAccount = settlementAccount;
        this.creditAccount = creditAccount;
        this.atmCommission = 0;
    }

    @Override
    public void doCardOperationOnAccount(String accountName, CardOperation operation, double atmCommission) {
        Account account=null;
        //wybor konta
        if (accountName == this.settlementAccount.getName()) {
             account = this.settlementAccount;
        } else if (accountName == this.creditAccount.getName()) {
            account = this.creditAccount;
        } else {
            System.out.println("Nie rozpoznano karty!");      // nie rozpoznano karty
        }
        //wybor operacji
        if (account != null){
            if (operation instanceof WithdrawOpeation) {

                if(account.getValue()>=operation.getOperationValue()) {
                    doWithdrawOperation(account, operation);
                }else{
                    System.out.println("Brak srodkow - operacja nie moze byc wykonana!");
                }
            } else if (operation instanceof DepositOperation) {
                doDepositOperation(account, operation, atmCommission);
            } else {
                System.out.println("Nie rozpoznana operacja!");  // nie rospoznano operacji
            }
        }
    }

    public double getATMCommisssion(){ return this.atmCommission; }

    private void doWithdrawOperation(Account account, CardOperation operation) {
        account.doOperation( - operation.getOperationValue() ,"Wyplata");
    }

    private  void doDepositOperation( Account account, CardOperation operation, double atmCommission ){
        account.doOperation( operation.getOperationValue()- atmCommission ,"Wplata");
        // sumowanie prowizji dla Euronetu;
        this.atmCommission=this.atmCommission+atmCommission;
       // System.out.println( "Prowizje nalezne Euronetowi: " + this.getATMCommisssion()) ;
    }


}


package com.ofss.main.domain;

public class Current extends Account{
    private double odbal;
    private double odBalLimit;

    public Current() {
        System.out.println("Current ac");
    }

    public Current(int no, String name, double bal, double odbal) {
        super(no, name, bal);
        this.odBalLimit = odbal;
        this.odbal = odbal;
    }

    @Override
    public boolean withdraw(double amt) {
        if(amt > 0){
            if(amt > odbal + getAccountBalance()){
                return false;
            }
            if(amt > getAccountBalance()){
                double remAmt = amt - getAccountBalance();
                setAccountBalance(0);
                odbal = odbal - remAmt;
            }else{
                setAccountBalance(getAccountBalance() - amt);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amt) {
        if (amt > 0) {
            if(odbal < odBalLimit){
                double amtFill = odBalLimit - odbal;
                if(amtFill > amt){
                    odbal+=amt;
                    amt = 0;
                }else{
                    odbal+=amtFill;
                    amt-=amtFill;
                }
            }

            setAccountBalance(getAccountBalance() + amt);
            return true;
        }
        return false;
    }

    public double getodBal() {
        return odbal;
    }
}

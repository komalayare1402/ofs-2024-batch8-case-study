package com.ofss.main.domain;

public class Savings extends Account {

    private boolean isSal;
    private final int minBal = 1500;


    public Savings() {
        System.out.println("Savings ac");
    }

    public Savings(int no, String name, double bal, boolean isSal) {
        super(no, name, bal);
        this.isSal = isSal;
    }

    @Override
    public boolean withdraw(double amt) {
        if (amt > 0 && isSal && amt <= super.getAccountBalance()) {
            setAccountBalance(getAccountBalance() - amt);
            return true;
        } else if (amt > 0 && !isSal && getAccountBalance() - amt <= minBal) {
            setAccountBalance(getAccountBalance() - amt);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amt) {
        if (amt > 0) {
            setAccountBalance(getAccountBalance() + amt);
            return true;
        }
        return false;
    }

    public boolean isSal() {
        return isSal;
    }

    public void setSal(boolean isSal) {
        this.isSal = isSal;
    }

    public int getMinBal() {
        return minBal;
    }

}

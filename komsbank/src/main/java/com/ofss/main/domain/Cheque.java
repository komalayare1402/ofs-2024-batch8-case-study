package com.ofss.main.domain;

import java.time.LocalDate;

public class Cheque {
    private int ChequeId;
    private String ChequeStatus;
    private String payeeAcc;
    private String payerAcc;
    private double ChequeAmount;
    private LocalDate ChequeDate;


    public int getChequeId() {
        return ChequeId;
    }

    public void setChequeId(int chequeId) {
        ChequeId = chequeId;
    }

    public String getChequeStatus() {
        return ChequeStatus;
    }

    public void setChequeStatus(String chequeStatus) {
        ChequeStatus = chequeStatus;
    }

    public String getPayeeAcc() {
        return payeeAcc;
    }

    public void setPayeeAcc(String payeeAcc) {
        this.payeeAcc = payeeAcc;
    }

    public String getPayerAcc() {
        return payerAcc;
    }

    public void setPayerAcc(String payerAcc) {
        this.payerAcc = payerAcc;
    }

    public double getChequeAmount() {
        return ChequeAmount;
    }

    public void setChequeAmount(double chequeAmount) {
        ChequeAmount = chequeAmount;
    }

    public LocalDate getChequeDate() {
        return ChequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        ChequeDate = chequeDate;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alisson
 * @author Mei
 */
public class Transaction {
    private int id;
    private int transactionType;
    private int accountId;
    private PersonalAccount transactionAccount;
    private Date date;
    private Double amount;
    
    //Bean structure
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public PersonalAccount getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(PersonalAccount transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    //Class structure
    public List<Transaction> getExtract(Date from, Date to, 
            PersonalAccount account){
        //TODO
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private int id;
    
    @Column(name = "type")
    private int transactionType;
    
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private PersonalAccount account;
    
    @ManyToOne
    @JoinColumn(name = "transaction_account", nullable = true)
    private PersonalAccount transactionAccount;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "ammount")
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

    public PersonalAccount getAccount() {
        return account;
    }

    public void setAccount(PersonalAccount account) {
        this.account = account;
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
    public Collection<Transaction> getExtract(Date from, Date to, 
            PersonalAccount account){
        //TODO
        Collection<Transaction> transactions = null;
        return transactions;
    }
}

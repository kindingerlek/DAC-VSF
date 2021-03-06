/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountTransactionDAO;
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
public class AccountTransaction {
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private int id;
    
    @Column(name = "type")
    private String transactionType;
    
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private PersonalAccount account;
    
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public PersonalAccount getAccount() {
        return account;
    }

    public void setAccount(PersonalAccount account) {
        this.account = account;
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
    public Collection<AccountTransaction> getExtract(Date from, Date to, 
            PersonalAccount account){
        //TODO
        Collection<AccountTransaction> transactions = null;
        return transactions;
    }
    
    public boolean create() {
        return AccountTransactionDAO.create(this);
    }
    
    
}

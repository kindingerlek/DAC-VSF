/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class PersonalAccount implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = true)
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "number")
    private int number;

    @Column(name = "type")
    private int type;
    
    @Column(name = "password")
    private String password;

    //Double para amount
    @Column(name = "balance")
    private Double balance;

    @OneToMany(mappedBy = "transactionAccount", fetch = FetchType.LAZY, targetEntity = Transaction.class, cascade = CascadeType.ALL)
    private Collection<Transaction> transactionsIn;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, targetEntity = Transaction.class, cascade = CascadeType.ALL)
    private Collection<Transaction> transactionsOut;

    //Bean structure / getters & setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Collection<Transaction> getTransactionsIn() {
        return transactionsIn;
    }

    public void setTransactionsIn(Collection<Transaction> transactionsIn) {
        this.transactionsIn = transactionsIn;
    }

    public Collection<Transaction> getTransactionsOut() {
        return transactionsOut;
    }

    public void setTransactionsOut(Collection<Transaction> transactionsOut) {
        this.transactionsOut = transactionsOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    //Class structure
    public PersonalAccount getAccountById(int id) {
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }

    //Sem agency?
    public PersonalAccount getAccountByNumber(int number) {
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }

    //Double?
    public void deposit(Double in) {
        //TODO: Check
        this.balance += in;
    }

    public boolean transfer(PersonalAccount destination, Double out) {
        //TODO
        return true;
    }

    public Collection<Transaction> getTransactionsByPeriod(Date start, Date end) {
        //TODO
        Collection<Transaction> transactions = null;
        return transactions;
    }

    public PersonalAccount createAccount(int number, Agency agency,
            User owner, String password) {
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }

    public boolean auth(String password) {
        //TODO
        return true;
    }

    public boolean update() {
        //TODO
        return true;
    }

    public boolean close(User user) {
        //TODO
        return true;
    }

    public Collection<Transaction> getExtract(Date from, Date to) {
        //TODO
        Collection<Transaction> transactions = null;
        return transactions;
    }
}

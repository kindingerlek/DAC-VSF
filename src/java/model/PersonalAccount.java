/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PersonalAccountDAO;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "account")
public class PersonalAccount {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "number", unique = true, nullable = false)
    private String number;

    @Column(name = "type")
    private int type;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "password")
    private String password;

    //Double para amount
    @Column(name = "balance")
    private Double balance;

    @OneToMany(mappedBy = "transactionAccount", fetch = FetchType.LAZY, targetEntity = AccountTransaction.class, cascade = CascadeType.ALL)
    private Collection<AccountTransaction> transactionsIn;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, targetEntity = AccountTransaction.class, cascade = CascadeType.ALL)
    private Collection<AccountTransaction> transactionsOut;

    //Bean structure / getters & setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Collection<AccountTransaction> getTransactionsIn() {
        return transactionsIn;
    }

    public void setTransactionsIn(Collection<AccountTransaction> transactionsIn) {
        this.transactionsIn = transactionsIn;
    }

    public Collection<AccountTransaction> getTransactionsOut() {
        return transactionsOut;
    }

    public void setTransactionsOut(Collection<AccountTransaction> transactionsOut) {
        this.transactionsOut = transactionsOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Class structure
    public boolean openAccount(User user, Agency agency) {
        this.setAgency(agency);
        this.setBalance(0.0);
        this.setStatus("inative");
        Random numero = new Random();
        int conta1 = 1 + numero.nextInt(99999);
        int conta2 = 1 + numero.nextInt(9);
        this.setNumber(Integer.toString(conta1)+"-"+Integer.toString(conta2));
        this.setType(user.getType());
        this.setUser(user);
        
        return this.create();
    }
    
    public boolean create() {
        return PersonalAccountDAO.create(this);
    }
    
    public PersonalAccount readByNumber() {
        PersonalAccount account = PersonalAccountDAO.readByNumber(this);
        this.setId(account.getId());
        return account;
    }
    
    public boolean update() {
        return PersonalAccountDAO.update(this);
    }
    
    public PersonalAccount readById() {
        return PersonalAccountDAO.readById(this);
    }
    
//    public PersonalAccount getAccountById(int id) {
//        //TODO
//        PersonalAccount account = new PersonalAccount();
//        return account;
//    }
//
//    //Sem agency?
//    public PersonalAccount getAccountByNumber(int number) {
//        //TODO
//        PersonalAccount account = new PersonalAccount();
//        return account;
//    }
//
//    //Double?
//    public void deposit(Double in) {
//        //TODO: Check
//        this.balance += in;
//    }
//
//    public boolean transfer(PersonalAccount destination, Double out) {
//        //TODO
//        return true;
//    }
//
//    public Collection<AccountTransaction> getTransactionsByPeriod(Date start, Date end) {
//        //TODO
//        Collection<AccountTransaction> transactions = null;
//        return transactions;
//    }
//
//    public PersonalAccount createAccount(int number, Agency agency,
//            User owner, String password) {
//        //TODO
//        PersonalAccount account = new PersonalAccount();
//        return account;
//    }
//
//    public boolean auth(String password) {
//        //TODO
//        return true;
//    }
//
//    public boolean update() {
//        //TODO
//        return true;
//    }
//
//    public boolean close(User user) {
//        //TODO
//        return true;
//    }
//
//    public Collection<AccountTransaction> getExtract(Date from, Date to) {
//        //TODO
//        Collection<AccountTransaction> transactions = null;
//        return transactions;
//    }
}

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
public class PersonalAccount {
    private int id;
    private Agency agency;
    private int number;
    //Double para amount
    private Double amount;
    private ArrayList<Transaction> transactionList;
    
    //Bean structure / getters & setters
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
    
    
    
    //Class structure
    public PersonalAccount getAccountById (int id){
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }
    
    //Sem agency?
    public PersonalAccount getAccountByNumber (int number){
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }
    
    //Double?
    public void deposit (Double in){
        //TODO: Check
        this.amount += in;
    }
    
    public boolean transfer(PersonalAccount destination, Double out){
        //TODO
        return true;
    }
    
    public List<Transaction> getTransactionsByPeriod(Date start, Date end){
        //TODO
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
    
    public PersonalAccount createAccount(int number, Agency agency,
            User owner, String password){
        //TODO
        PersonalAccount account = new PersonalAccount();
        return account;
    }
    
    public boolean auth(String password){
        //TODO
        return true;
    }
    
    public boolean update(){
        //TODO
        return true;
    }
    
    public boolean close(User user){
        //TODO
        return true;
    }
    
    public List<Transaction> getExtract(Date from, Date to){
        //TODO
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}

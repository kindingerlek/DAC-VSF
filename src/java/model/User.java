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
public class User {

    private int id;
    private String password;
    private String email;
    private boolean active;
    private String landPhone;
    private String cellPhone;
    private String address;
    private String addressNumber;
    private String complement;
    private String zipCode;

    private List<PersonalAccount> accountList;

    // Beans Structure
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<PersonalAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<PersonalAccount> accountList) {
        this.accountList = accountList;
    }

    public PersonalAccount getAccountList(int indexPersonalAccount) {
        return accountList.get(indexPersonalAccount);
    }

    //Class Structure
    
    public boolean create() {
        return true;
    }
    
    public User read() {
        return new User();
    }
    
    public boolean update(){
        return true;
    }
    
    public boolean delete(){
        return true;
    }
    
    public static User auth(String email, String senha){
        User user = new User();
        user.setEmail(email);
        return user;
    }
    
    public float getAmount(){
        return 1;
    }
    
    public PersonalAccount getAccount(int number, Agency agency){
        return new PersonalAccount();
    }
    
    public List<Transaction> getExtract(PersonalAccount account){
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
    
    public List<Transaction> getFullExtract(PersonalAccount account,
            Date from, Date to){
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
    
     /*
    public static boolean auth(String email, String senha){
        User user = new User();
        user.setEmail(email);
        return true;
    */
    
}

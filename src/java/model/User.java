/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbuser")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "land_phone")
    private String landPhone;
    @Column(name = "cell_phone")
    private String cellPhone;
    @Column(name = "address")
    private String address;
    @Column(name = "address_number")
    private String addressNumber;
    @Column(name = "complement")
    private String complement;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "cpf", unique = true, nullable = true)
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cnpj", unique = true, nullable = true)
    private String cnpj;
    @Column(name = "name")
    private String name;
    @Column(name = "user_type")
    private int type;
    @Column(name = "fantasy_name")
    private String fantasyName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, targetEntity = PersonalAccount.class, cascade = CascadeType.ALL)
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }
    
    //Class Structure
    
    public boolean create() {
        return UserDAO.create(this);
    }
    
    public User read() {
        return UserDAO.read(this);
    }
    
    public boolean update(){
        return UserDAO.update(this);
    }
    public boolean delete(){
        return UserDAO.delete(this);
    }
//    
//    public static User auth(String email, String senha){
//        User user = new User();
//        user.setEmail(email);
//        return user;
//    }
//    
//    public float getAmount(){
//        return 1;
//    }
//    
//    public PersonalAccount getAccount(int number, Agency agency){
//        return new PersonalAccount();
//    }
//    
//    public List<Transaction> getExtract(PersonalAccount account){
//        Collection<Transaction> transactions = new Collection<>();
//        return transactions;
//    }
//    
//    public List<Transaction> getFullExtract(PersonalAccount account,
//            Date from, Date to){
//        Collection<Transaction> transactions = new Collection<>();
//        return transactions;
//    }
    
     /*
    public static boolean auth(String email, String senha){
        User user = new User();
        user.setEmail(email);
        return true;
    */
    
}

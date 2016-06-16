/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import utilities.Utils;

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
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "street")
    private String street;
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
    @Column(name = "token_for_account")
    private String tokenForAccount;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, targetEntity = PersonalAccount.class, cascade = CascadeType.ALL)
    private List<PersonalAccount> accountList;

    // Beans Structure
    public User() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTokenForAccount() {
        return tokenForAccount;
    }

    public void setTokenForAccount(String tokenForAccount) {
        this.tokenForAccount = tokenForAccount;
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
        this.password = hashString(password);
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

    public void setCpf(String cpf) throws Exception {
        if (Utils.isValidCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new Exception("CPF inválido.");
        }
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

    public void setCnpj(String cnpj) throws Exception {
        if (Utils.isValidCNPJ(cnpj)) {
            this.cnpj = cnpj;

        } else {
            throw new Exception("CNPJ inválido.");
        }
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
        if (getType() == 1) {
            if (hasNecessaryInformationPf()) {
                return UserDAO.create(this);

            } else {
                return false;
            }
        } else if (hasNecessaryInformationPj()) {
            return UserDAO.create(this);
        } else {
            return false;
        }
    }

    public User read() {
        return UserDAO.read(this);
    }

    public boolean update() {
        return UserDAO.update(this);
    }

    public boolean delete() {
        return UserDAO.delete(this);
    }

    public boolean hasAllInformation() {
        if (this.getType() == 1) {
            return hasAllInformationPF();
        } else {
            return hasAllInformationPJ();
        }
    }

    public boolean hasNecessaryInformationPj() {
        return !(this.getEmail() == null
                || this.getFantasyName() == null
                || this.getCnpj() == null
                || this.getPassword() == null
                || this.getPassword().isEmpty()
                || this.getEmail().isEmpty()
                || this.getFantasyName().isEmpty()
                || this.getCnpj().isEmpty());
    }

    public boolean hasNecessaryInformationPf() {
        return !(this.getEmail() == null
                || this.getRg() == null
                || this.getCpf() == null
                || this.getPassword() == null
                || this.getPassword().isEmpty()
                || this.getEmail().isEmpty()
                || this.getRg().isEmpty()
                || this.getCpf().isEmpty());
    }

    public boolean hasAllInformationPF() {
        return !(this.getCity() == null
                || this.getState() == null
                || this.getNeighborhood() == null
                || this.getStreet() == null
                || this.getAddressNumber() == null
                || this.getCellPhone() == null
                || this.getComplement() == null
                || this.getLandPhone() == null
                || this.getZipCode() == null
                || this.getRg() == null
                || this.getCpf() == null
                || this.getEmail() == null
                || this.getPassword() == null
                || this.getPassword().isEmpty()
                || this.getEmail().isEmpty()
                || (this.getCity().isEmpty())
                || (this.getState().isEmpty())
                || (this.getNeighborhood().isEmpty())
                || (this.getStreet().isEmpty())
                || (this.getAddressNumber().isEmpty())
                || (this.getCellPhone().isEmpty())
                || (this.getComplement().isEmpty())
                || (this.getLandPhone().isEmpty())
                || (this.getZipCode().isEmpty())
                || (this.getRg().isEmpty())
                || (this.getCpf().isEmpty()));
    }

    public boolean hasAllInformationPJ() {
        return !(this.getCity() == null
                || this.getState() == null
                || this.getNeighborhood() == null
                || this.getStreet() == null
                || this.getAddressNumber() == null
                || this.getCellPhone() == null
                || this.getComplement() == null
                || this.getLandPhone() == null
                || this.getZipCode() == null
                || this.getFantasyName() == null
                || this.getCnpj() == null
                || this.getEmail() == null
                || this.getPassword() == null
                || this.getPassword().isEmpty()
                || this.getEmail().isEmpty()
                || (this.getCity().isEmpty())
                || (this.getState().isEmpty())
                || (this.getNeighborhood().isEmpty())
                || (this.getStreet().isEmpty())
                || (this.getAddressNumber().isEmpty())
                || (this.getCellPhone().isEmpty())
                || (this.getComplement().isEmpty())
                || (this.getLandPhone().isEmpty())
                || (this.getZipCode().isEmpty())
                || (this.getFantasyName().isEmpty())
                || (this.getCnpj().isEmpty()));
    }

    public boolean verifyPassword(String password) {
        if (password != null && hashString(password).equals(this.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    private String hashString(String message) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));

            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(PersonalAccount.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
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

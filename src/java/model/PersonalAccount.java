/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountTransactionDAO;
import dao.PersonalAccountDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;
import utilities.Utils;

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

    @Column(name = "number", unique = true)
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

    @Column(name = "account_limit")
    private Double limit;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, targetEntity = AccountTransaction.class, cascade = CascadeType.ALL)
    private Collection<AccountTransaction> transactions;

    @Column(name = "indebt_since")
    private Date indebtSince;

    //Bean structure / getters & setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getIndebtSince() {
        return indebtSince;
    }

    public void setIndebtSince(Date indebtSince) {
        this.indebtSince = indebtSince;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double balanceLimit) {
        this.limit = balanceLimit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Collection<AccountTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<AccountTransaction> transactions) {
        this.transactions = transactions;
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
        this.password = hashString(password);
    }

    //Class structure
    public List<AccountTransaction> getExtract() {
        return AccountTransactionDAO.getExtract(this);
    }

    public List<AccountTransaction> getExtractByMonth() {
        return AccountTransactionDAO.getExtractByMonth(this);
    }

    public List<AccountTransaction> getExtractByWeek() {
        return AccountTransactionDAO.getExtractByWeek(this);
    }

    public List<AccountTransaction> getExtractByFornight() {
        return AccountTransactionDAO.getExtractByFortnight(this);
    }

    public void transfer(PersonalAccount accountToSend, Double ammount) throws Exception {
        this.withdraw(ammount, "Transferência");
        accountToSend.deposit(ammount, "Transferência");
    }

    public void deposit(Double amount, String type) {
        if (this.getBalance() + amount > 0) {
            this.setStatus("Regular");
            Utils.removeDebtorInDOR(getUser());
        }
        AccountTransaction at = new AccountTransaction();
        at.setAccount(this);
        at.setAmount(amount);
        at.setTransactionType(type);
        at.setDate(new Date());

        at.create();

        this.setBalance(getBalance() + amount);
        this.update();

    }

    public void withdraw(Double amount, String type) throws Exception {
        if (this.getType() == 2 || type.equals("Transferência")) {

            if (this.getBalance() - amount < 0) {
                if ((this.getBalance() - amount) < (-this.getLimit())) {
                    throw new Exception("inadequate limit");
                }
                if (!getStatus().equals("Em cheque especial")) {
                    this.setStatus("Em cheque especial");
                    this.setIndebtSince(new Date());
                }
            }

            AccountTransaction at = new AccountTransaction();
            at.setAccount(this);
            at.setAmount(-amount);
            at.setTransactionType(type);
            at.setDate(new Date());

            at.create();

            this.setBalance(getBalance() - amount);
            this.update();

        } else {
            throw new Exception("user unsupported");
        }
    }

    public void closeAccount() {
        this.setStatus("Fechada");
        PersonalAccountDAO.update(this);
    }

    public boolean openAccount(User user, Agency agency) {
        this.setAgency(agency);
        this.setBalance(0.0);
        this.setStatus("Inativa");
        Random numero = new Random();
        int conta1 = 1 + numero.nextInt(99999);
        while(conta1<10000){
            conta1 = 1 + numero.nextInt(99999);
        }
        int conta2 = 1 + numero.nextInt(9);
        this.setNumber(Integer.toString(conta1) + "-" + Integer.toString(conta2));
        this.setType(user.getType());
        user.setStatus("Ativo");
        this.setUser(user);

        if (user.getIncome() > 1000) {
            this.setLimit(user.getIncome() * 0.5);
        } else {
            this.setLimit(0.0);
        }

        return this.create();
    }

    public boolean create() {
        return PersonalAccountDAO.create(this);
    }

    public PersonalAccount readByUserIdAndInativeStatus() {
        PersonalAccount account = new PersonalAccount();
        account = PersonalAccountDAO.readByUserIdAndInativeStatus(this);
        if (account != null) {
            return account;
        } else {
            return this;
        }
    }

    public PersonalAccount readByUser() {
        PersonalAccount account;
        account = PersonalAccountDAO.readByUser(this);
        return account;
    }

    public PersonalAccount readByNumber() {
        PersonalAccount account = PersonalAccountDAO.readByNumber(this);
        return account;
    }

    public boolean update() {
        return PersonalAccountDAO.update(this);
    }

    public PersonalAccount readById() {
        return PersonalAccountDAO.readById(this);
    }

    public Double getMonthMovement() {
        Double amount = 0.0;

        for (AccountTransaction transaction : transactions) {
            Date dateBefore = new Date(System.currentTimeMillis() - 30 * 24 * 3600 * 1000);
            if (transaction.getDate().before(dateBefore)) {
                amount += transaction.getAmount();
            }
        }
        return amount;
    }

    public boolean verifyPassword(String password) {
        return hashString(password).equals(this.getPassword());
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
}

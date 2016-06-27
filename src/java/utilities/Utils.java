/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Agency;
import model.User;
import webService.DebtorCompanySituationWeb;

/**
 *
 * @author Mei
 */
public class Utils {

    private static final int[] CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static List<Agency> getAllAgencies() {
        //TODO
        ArrayList<Agency> agencies = new ArrayList<>();
        return agencies;
    }

    public static void verifyDebtor() {
        //TODO
    }

    public static Response addDebtorInDOR(User user) {
        Client client = ClientBuilder.newClient();
        String uri = "http://172.31.41.180:8084/DAC-DOR/webresources/debtorSituations";

        DebtorCompanySituationWeb debtor = new DebtorCompanySituationWeb();
        debtor.setDebtorIdentifier(user.getIdentifier());
        debtor.setDebtorName(user.getName());
        debtor.setIndebt(true);
        debtor.setCompanyToken("L2OfENSDI7");

        return client
                .target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(debtor, MediaType.APPLICATION_JSON));
    }
    
    public static Response removeDebtorInDOR(User user) {
        Client client = ClientBuilder.newClient();
        String uri = "http://172.31.41.180:8084/DAC-DOR/webresources/debtorSituations";

        DebtorCompanySituationWeb debtor = new DebtorCompanySituationWeb();
        debtor.setDebtorIdentifier(user.getIdentifier());
        debtor.setDebtorName(user.getName());
        debtor.setIndebt(false);
        debtor.setCompanyToken("L2OfENSDI7");

        return client
                .target(uri)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(debtor, MediaType.APPLICATION_JSON));
    }

    public static boolean isEmailAvaliable(String email) {
        User user = new User();

        user.setEmail(email);
        user = user.read();
        return (user == null);
    }

    public static boolean isCnpjAvaliable(String cnpj) throws Exception {
        User user = new User();

        user.setCnpj(cnpj);
        user = user.read();

        return (user == null);
    }

    public static boolean isCpfAvaliable(String cpf) throws Exception {
        User user = new User();

        user.setCpf(cpf);
        user = user.read();

        return (user == null);
    }

    private static int calculateDigit(String str, int[] height) {
        int add = 0;
        for (int indice = str.length() - 1, digit; indice >= 0; indice--) {
            digit = Integer.parseInt(str.substring(indice, indice + 1));
            add += digit * height[height.length - str.length() + indice];
        }
        add = 11 - add % 11;
        return add > 9 ? 0 : add;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digit1 = calculateDigit(cpf.substring(0, 9), CPF);
        Integer digit2 = calculateDigit(cpf.substring(0, 9) + digit1, CPF);
        return cpf.equals(cpf.substring(0, 9) + digit1.toString() + digit2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digit1 = calculateDigit(cnpj.substring(0, 12), CNPJ);
        Integer digit2 = calculateDigit(cnpj.substring(0, 12) + digit1, CNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digit1.toString() + digit2.toString());
    }
}

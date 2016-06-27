/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import dao.PersonalAccountDAO;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import model.PersonalAccount;

/**
 *
 * @author Bruno
 */
public class VerifyIndebt extends TimerTask {

    public VerifyIndebt() {
    }

    @Override
    public void run() {
        List<PersonalAccount> accountsIndebt = PersonalAccountDAO.accountsIndebt();
        
        Date dateBefore = new Date(System.currentTimeMillis() - 10 * 24 * 3600 * 1000);
        
        for(PersonalAccount account : accountsIndebt) {
            if(account.getIndebtSince().before(dateBefore)) {
                Utils.addDebtorInDOR(account.getUser());
            }
        }
    }
}

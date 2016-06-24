/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

/**
 *
 * @author Bruno
 */
public class DebtorCompanySituationWeb {
    private String debtorIdentifier;
    private String debtorName;
    private String companyToken;
    private boolean indebt;

    public String getDebtorIdentifier() {
        return debtorIdentifier;
    }

    public void setDebtorIdentifier(String debtorIdentifier) {
        this.debtorIdentifier = debtorIdentifier;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getCompanyToken() {
        return companyToken;
    }

    public void setCompanyToken(String companyToken) {
        this.companyToken = companyToken;
    }

    public boolean isIndebt() {
        return indebt;
    }

    public void setIndebt(boolean indebt) {
        this.indebt = indebt;
    }
}

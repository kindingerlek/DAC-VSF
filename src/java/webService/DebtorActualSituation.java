/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class DebtorActualSituation implements Serializable {
    private String identifier;
    private boolean indebt;

    public DebtorActualSituation() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isIndebt() {
        return indebt;
    }

    public void setIndebt(boolean indebt) {
        this.indebt = indebt;
    }
    
}

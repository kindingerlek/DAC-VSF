/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AgencyDAO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agency")
public class Agency {

    @Id
    @GeneratedValue
    @Column(name = "agency_id")
    private int id;

    @Column(name = "agency_number", length = 5)
    private String number;

    public Agency(String number) {
        this.number = number;
    }

    public Agency() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public boolean create() {
        return AgencyDAO.create(this);
    }
    
    public Agency readByNumber() {
        return AgencyDAO.read(this);
    }

}

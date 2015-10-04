/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Magnus
 */
public class Project implements Serializable {
    
    private int pro_id;
    private String pro_name;
    private Date pro_startdate;
    private Date pro_enddate;
    private double pro_budget;

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Date getPro_startdate() {
        return pro_startdate;
    }

    public void setPro_startdate(Date pro_startdate) {
        this.pro_startdate = pro_startdate;
    }

    public Date getPro_enddate() {
        return pro_enddate;
    }

    public void setPro_enddate(Date pro_enddate) {
        this.pro_enddate = pro_enddate;
    }

    public double getPro_budget() {
        return pro_budget;
    }

    public void setPro_budget(double pro_budget) {
        this.pro_budget = pro_budget;
    }
    
    
    
}

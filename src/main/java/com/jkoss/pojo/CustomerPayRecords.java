package com.jkoss.pojo;

import java.util.Date;

public class CustomerPayRecords {
    private Integer ID;

    private Integer REGID;

    private Integer USERID;

    private Integer CUSTOMERID;

    private Date PAYDATE;

    private Float MONEY;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getREGID() {
        return REGID;
    }

    public void setREGID(Integer REGID) {
        this.REGID = REGID;
    }

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public Integer getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Integer CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public Date getPAYDATE() {
        return PAYDATE;
    }

    public void setPAYDATE(Date PAYDATE) {
        this.PAYDATE = PAYDATE;
    }

    public Float getMONEY() {
        return MONEY;
    }

    public void setMONEY(Float MONEY) {
        this.MONEY = MONEY;
    }
}
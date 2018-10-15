package com.jkoss.pojo;

import java.util.Date;

public class PrepayRegister {
    private Integer ID;

    private Integer CUSTOMERID;

    private Float PREMONEY;

    private Date PREDATE;

    private Integer USERID;

    private String REMARK;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Integer CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public Float getPREMONEY() {
        return PREMONEY;
    }

    public void setPREMONEY(Float PREMONEY) {
        this.PREMONEY = PREMONEY;
    }

    public Date getPREDATE() {
        return PREDATE;
    }

    public void setPREDATE(Date PREDATE) {
        this.PREDATE = PREDATE;
    }

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }
}
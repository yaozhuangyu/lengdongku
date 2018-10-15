package com.jkoss.pojo;

import java.util.Date;

public class RepayRegister {
    private Integer ID;

    private Integer REGID;

    private String CUSTOMERID;

    private Date BEGINTIME;

    private Date ENDTIME;

    private Date STOPTIME;

    private Integer STATE;

    private String REMARK;

    private Float REPAYHOURS;

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

    public String getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(String CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID == null ? null : CUSTOMERID.trim();
    }

    public Date getBEGINTIME() {
        return BEGINTIME;
    }

    public void setBEGINTIME(Date BEGINTIME) {
        this.BEGINTIME = BEGINTIME;
    }

    public Date getENDTIME() {
        return ENDTIME;
    }

    public void setENDTIME(Date ENDTIME) {
        this.ENDTIME = ENDTIME;
    }

    public Date getSTOPTIME() {
        return STOPTIME;
    }

    public void setSTOPTIME(Date STOPTIME) {
        this.STOPTIME = STOPTIME;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Float getREPAYHOURS() {
        return REPAYHOURS;
    }

    public void setREPAYHOURS(Float REPAYHOURS) {
        this.REPAYHOURS = REPAYHOURS;
    }
}
package com.jkoss.pojo;

import java.util.Date;

public class CoolRegister {
    private Integer ID;

    private String CABINETNO;

    private Integer CUSTOMERID;

    private String FRUITCATEGERY;

    private Date BEGINTIME;

    private Date ENDTIME;

    private Float TEMPRATURE;

    private String CABINETLOC;

    private String OPERATER;

    private String MOBILE;

    private String REMARK;

    private Date REGISTERTIME;

    private Integer COOLTYPE;

    private Float MONEY;

    private Integer STATE;

    private Integer PAYTYPE;

    private String CUSTOMERNAME;

    private Date STOPTIME;

    private Date PAYDATETIME;

    private Integer REGISTERID;

    private Integer AREANUM;

    private Integer CARDNUM;
    

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCABINETNO() {
        return CABINETNO;
    }

    public void setCABINETNO(String CABINETNO) {
        this.CABINETNO = CABINETNO == null ? null : CABINETNO.trim();
    }

    public Integer getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Integer CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public String getFRUITCATEGERY() {
        return FRUITCATEGERY;
    }

    public void setFRUITCATEGERY(String FRUITCATEGERY) {
        this.FRUITCATEGERY = FRUITCATEGERY == null ? null : FRUITCATEGERY.trim();
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

    public Float getTEMPRATURE() {
        return TEMPRATURE;
    }

    public void setTEMPRATURE(Float TEMPRATURE) {
        this.TEMPRATURE = TEMPRATURE;
    }

    public String getCABINETLOC() {
        return CABINETLOC;
    }

    public void setCABINETLOC(String CABINETLOC) {
        this.CABINETLOC = CABINETLOC == null ? null : CABINETLOC.trim();
    }

    public String getOPERATER() {
        return OPERATER;
    }

    public void setOPERATER(String OPERATER) {
        this.OPERATER = OPERATER == null ? null : OPERATER.trim();
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Date getREGISTERTIME() {
        return REGISTERTIME;
    }

    public void setREGISTERTIME(Date REGISTERTIME) {
        this.REGISTERTIME = REGISTERTIME;
    }

    public Integer getCOOLTYPE() {
        return COOLTYPE;
    }

    public void setCOOLTYPE(Integer COOLTYPE) {
        this.COOLTYPE = COOLTYPE;
    }

    public Float getMONEY() {
        return MONEY;
    }

    public void setMONEY(Float MONEY) {
        this.MONEY = MONEY;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public Integer getPAYTYPE() {
        return PAYTYPE;
    }

    public void setPAYTYPE(Integer PAYTYPE) {
        this.PAYTYPE = PAYTYPE;
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME == null ? null : CUSTOMERNAME.trim();
    }

    public Date getSTOPTIME() {
        return STOPTIME;
    }

    public void setSTOPTIME(Date STOPTIME) {
        this.STOPTIME = STOPTIME;
    }

    public Date getPAYDATETIME() {
        return PAYDATETIME;
    }

    public void setPAYDATETIME(Date PAYDATETIME) {
        this.PAYDATETIME = PAYDATETIME;
    }

    public Integer getREGISTERID() {
        return REGISTERID;
    }

    public void setREGISTERID(Integer REGISTERID) {
        this.REGISTERID = REGISTERID;
    }

    public Integer getAREANUM() {
        return AREANUM;
    }

    public void setAREANUM(Integer AREANUM) {
        this.AREANUM = AREANUM;
    }

    public Integer getCARDNUM() {
        return CARDNUM;
    }

    public void setCARDNUM(Integer CARDNUM) {
        this.CARDNUM = CARDNUM;
    }
}
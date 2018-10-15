package com.jkoss.pojo;

import java.util.Date;

public class ColdArrange {
    private Integer ID;

    private Integer REGID;

    private String CABINETNO;

    private String CUSTOMERID;

    private String FRUITCATEGERY;

    private Date BEGINTIME;

    private Date ENDTIME;

    private Float TEMPRATURE;

    private String CABINETLOC;

    private Integer OPERATER;

    private Date OPERATETIME;

    private String MOBILE;

    private Integer COLDOPERATOR;

    private Integer STOPCOLDOPERATOR;

    private String REMARK;

    private String CUSTOMERNAME;

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

    public String getCABINETNO() {
        return CABINETNO;
    }

    public void setCABINETNO(String CABINETNO) {
        this.CABINETNO = CABINETNO == null ? null : CABINETNO.trim();
    }

    public String getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(String CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID == null ? null : CUSTOMERID.trim();
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

    public Integer getOPERATER() {
        return OPERATER;
    }

    public void setOPERATER(Integer OPERATER) {
        this.OPERATER = OPERATER;
    }

    public Date getOPERATETIME() {
        return OPERATETIME;
    }

    public void setOPERATETIME(Date OPERATETIME) {
        this.OPERATETIME = OPERATETIME;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    public Integer getCOLDOPERATOR() {
        return COLDOPERATOR;
    }

    public void setCOLDOPERATOR(Integer COLDOPERATOR) {
        this.COLDOPERATOR = COLDOPERATOR;
    }

    public Integer getSTOPCOLDOPERATOR() {
        return STOPCOLDOPERATOR;
    }

    public void setSTOPCOLDOPERATOR(Integer STOPCOLDOPERATOR) {
        this.STOPCOLDOPERATOR = STOPCOLDOPERATOR;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME == null ? null : CUSTOMERNAME.trim();
    }
}
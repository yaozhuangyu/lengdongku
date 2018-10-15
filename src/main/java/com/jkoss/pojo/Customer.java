package com.jkoss.pojo;

public class Customer {
    private Integer ID;

    private Integer TYPE;

    private String CUSTOMERNAME;

    private String NAME;

    private String TELEPHONE;

    private String IDENTITICODE;

    private String ADDRESS;

    private Float LEAVEMONEY;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME == null ? null : CUSTOMERNAME.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE == null ? null : TELEPHONE.trim();
    }

    public String getIDENTITICODE() {
        return IDENTITICODE;
    }

    public void setIDENTITICODE(String IDENTITICODE) {
        this.IDENTITICODE = IDENTITICODE == null ? null : IDENTITICODE.trim();
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    public Float getLEAVEMONEY() {
        return LEAVEMONEY;
    }

    public void setLEAVEMONEY(Float LEAVEMONEY) {
        this.LEAVEMONEY = LEAVEMONEY;
    }
}
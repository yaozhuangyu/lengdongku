package com.jkoss.pojo;

public class SysDept {
    private Integer ID;

    private String DEPTNAME;

    private Integer PARENTID;

    private String DEPTCODE;

    private String RESPONSER;

    private String ADDRESS;

    private String ZCODE;

    private String TELEPHONE;

    private String FAX;

    private String EMAIL;

    private String WEBSITE;

    private Integer STATE;

    private String CREATER;

    private String REMARK;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDEPTNAME() {
        return DEPTNAME;
    }

    public void setDEPTNAME(String DEPTNAME) {
        this.DEPTNAME = DEPTNAME == null ? null : DEPTNAME.trim();
    }

    public Integer getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Integer PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getDEPTCODE() {
        return DEPTCODE;
    }

    public void setDEPTCODE(String DEPTCODE) {
        this.DEPTCODE = DEPTCODE == null ? null : DEPTCODE.trim();
    }

    public String getRESPONSER() {
        return RESPONSER;
    }

    public void setRESPONSER(String RESPONSER) {
        this.RESPONSER = RESPONSER == null ? null : RESPONSER.trim();
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    public String getZCODE() {
        return ZCODE;
    }

    public void setZCODE(String ZCODE) {
        this.ZCODE = ZCODE == null ? null : ZCODE.trim();
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE == null ? null : TELEPHONE.trim();
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX == null ? null : FAX.trim();
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE == null ? null : WEBSITE.trim();
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public String getCREATER() {
        return CREATER;
    }

    public void setCREATER(String CREATER) {
        this.CREATER = CREATER == null ? null : CREATER.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }
}
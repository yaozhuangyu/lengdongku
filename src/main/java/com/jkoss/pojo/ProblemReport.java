package com.jkoss.pojo;

import java.util.Date;

public class ProblemReport {
    private Integer ID;

    private Integer CREATER;

    private String LOCATION;

    private Integer TYPE;

    private Integer EMERCY;

    private Date CREATETIME;

    private String DESCRIPTION;

    private String REMARK;

    private Integer STATE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCREATER() {
        return CREATER;
    }

    public void setCREATER(Integer CREATER) {
        this.CREATER = CREATER;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION == null ? null : LOCATION.trim();
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }

    public Integer getEMERCY() {
        return EMERCY;
    }

    public void setEMERCY(Integer EMERCY) {
        this.EMERCY = EMERCY;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }
}
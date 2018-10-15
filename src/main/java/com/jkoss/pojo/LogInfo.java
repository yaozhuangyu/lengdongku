package com.jkoss.pojo;

import java.util.Date;

public class LogInfo {
    private Integer ID;

    private Integer USERID;

    private Date OPRATETIME;

    private Integer OPRATEMODULS;

    private String OPRATENAME;

    private String DETAILINFO;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public Date getOPRATETIME() {
        return OPRATETIME;
    }

    public void setOPRATETIME(Date OPRATETIME) {
        this.OPRATETIME = OPRATETIME;
    }

    public Integer getOPRATEMODULS() {
        return OPRATEMODULS;
    }

    public void setOPRATEMODULS(Integer OPRATEMODULS) {
        this.OPRATEMODULS = OPRATEMODULS;
    }

    public String getOPRATENAME() {
        return OPRATENAME;
    }

    public void setOPRATENAME(String OPRATENAME) {
        this.OPRATENAME = OPRATENAME == null ? null : OPRATENAME.trim();
    }

    public String getDETAILINFO() {
        return DETAILINFO;
    }

    public void setDETAILINFO(String DETAILINFO) {
        this.DETAILINFO = DETAILINFO == null ? null : DETAILINFO.trim();
    }
}
package com.jkoss.pojo;

public class Moduls {
    private Integer ID;

    private Integer PARENTID;

    private String MODULSNAME;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Integer PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getMODULSNAME() {
        return MODULSNAME;
    }

    public void setMODULSNAME(String MODULSNAME) {
        this.MODULSNAME = MODULSNAME == null ? null : MODULSNAME.trim();
    }
}
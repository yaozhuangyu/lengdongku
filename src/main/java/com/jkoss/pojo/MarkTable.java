package com.jkoss.pojo;

public class MarkTable {
    private Integer ID;

    private Integer REGID;

    private String LOC;

    private Integer TYPE;

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

    public String getLOC() {
        return LOC;
    }

    public void setLOC(String LOC) {
        this.LOC = LOC == null ? null : LOC.trim();
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }
}
package com.jkoss.pojo;

public class FruitCategory {
    private Integer ID;

    private Integer PARENTID;

    private String CATENAME;

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

    public String getCATENAME() {
        return CATENAME;
    }

    public void setCATENAME(String CATENAME) {
        this.CATENAME = CATENAME == null ? null : CATENAME.trim();
    }
}
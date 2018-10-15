package com.jkoss.pojo;

public class AreaInfo {
    private Integer ID;

    private String AREANAME;

    private String REMARK;
    

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAREANAME() {
        return AREANAME;
    }

    public void setAREANAME(String AREANAME) {
        this.AREANAME = AREANAME == null ? null : AREANAME.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }
}
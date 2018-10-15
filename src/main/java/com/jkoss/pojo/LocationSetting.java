package com.jkoss.pojo;

import java.util.List;

public class LocationSetting {
    private Integer ID;

    private String CARDNO;

    private String CARDNAME;

    private String REMARK;

    private Integer CAPACITY;

    private Integer STATE;

    private Integer AREAID;

    private Integer TOTOL;

    private Integer INUSE;

    private Integer NOTUSE;
    
    private List<CabinatSetting> cabinatsetting;


    public List<CabinatSetting> getCabinatsetting() {
		return cabinatsetting;
	}

	public void setCabinatsetting(List<CabinatSetting> cabinatsetting) {
		this.cabinatsetting = cabinatsetting;
	}

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCARDNO() {
        return CARDNO;
    }

    public void setCARDNO(String CARDNO) {
        this.CARDNO = CARDNO == null ? null : CARDNO.trim();
    }

    public String getCARDNAME() {
        return CARDNAME;
    }

    public void setCARDNAME(String CARDNAME) {
        this.CARDNAME = CARDNAME == null ? null : CARDNAME.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Integer getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(Integer CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public Integer getAREAID() {
        return AREAID;
    }

    public void setAREAID(Integer AREAID) {
        this.AREAID = AREAID;
    }

    public Integer getTOTOL() {
        return TOTOL;
    }

    public void setTOTOL(Integer TOTOL) {
        this.TOTOL = TOTOL;
    }

    public Integer getINUSE() {
        return INUSE;
    }

    public void setINUSE(Integer INUSE) {
        this.INUSE = INUSE;
    }

    public Integer getNOTUSE() {
        return NOTUSE;
    }

    public void setNOTUSE(Integer NOTUSE) {
        this.NOTUSE = NOTUSE;
    }
    
    @Override
	public String toString() {
		return "LocationSetting [ID=" + ID + ", CARDNO=" + CARDNO + ", CARDNAME=" + CARDNAME + ", REMARK=" + REMARK
				+ ", CAPACITY=" + CAPACITY + ", STATE=" + STATE + ", AREAID=" + AREAID + ", TOTOL=" + TOTOL + ", INUSE="
				+ INUSE + ", NOTUSE=" + NOTUSE + ", cabinatsetting=" + cabinatsetting + "]";
	}
}
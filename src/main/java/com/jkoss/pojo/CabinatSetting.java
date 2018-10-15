package com.jkoss.pojo;

public class CabinatSetting {
    private Integer ID;

    private Integer CARDID;

    private String SERIALNO;

    private String LOCATION;

    private String CABINATENAME;

    private Integer CAPACITY;

    private Integer STATE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCARDID() {
        return CARDID;
    }

    public void setCARDID(Integer CARDID) {
        this.CARDID = CARDID;
    }

    public String getSERIALNO() {
        return SERIALNO;
    }

    public void setSERIALNO(String SERIALNO) {
        this.SERIALNO = SERIALNO == null ? null : SERIALNO.trim();
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION == null ? null : LOCATION.trim();
    }

    public String getCABINATENAME() {
        return CABINATENAME;
    }

    public void setCABINATENAME(String CABINATENAME) {
        this.CABINATENAME = CABINATENAME == null ? null : CABINATENAME.trim();
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
    
    @Override
	public String toString() {
		return "CabinatSetting [ID=" + ID + ", CARDID=" + CARDID + ", SERIALNO=" + SERIALNO + ", LOCATION=" + LOCATION
				+ ", CABINATENAME=" + CABINATENAME + ", CAPACITY=" + CAPACITY + ", STATE=" + STATE + "]";
	}
}
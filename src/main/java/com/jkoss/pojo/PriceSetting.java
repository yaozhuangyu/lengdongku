package com.jkoss.pojo;

import java.util.List;

public class PriceSetting {
    private Integer ID;

    private Integer UNIT;

    private Integer AREAID;

    private Integer CARDID;

    private Integer CABINID;

    private Integer FRUITCATEGORYID;

    private Integer CUSTOMERID;

    private Integer UNITNUM;

    private Integer DISCARD;

    private Float PRICE;

    private Integer FLAG;

    private Integer ISPAY;

    private String REMARK;
    
    private List<LocationSetting> locationsetting;
    
    private List<AreaInfo> areainfo;
    
    private List<CabinatSetting> cabinatsetting;
    
    private List<Customer> customer;
    
    private List<FruitCategory> fruitcategory;
    
    
	public List<AreaInfo> getAreainfo() {
		return areainfo;
	}

	public void setAreainfo(List<AreaInfo> areainfo) {
		this.areainfo = areainfo;
	}

	public List<CabinatSetting> getCabinatsetting() {
		return cabinatsetting;
	}

	public void setCabinatsetting(List<CabinatSetting> cabinatsetting) {
		this.cabinatsetting = cabinatsetting;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public List<FruitCategory> getFruitcategory() {
		return fruitcategory;
	}

	public void setFruitcategory(List<FruitCategory> fruitcategory) {
		this.fruitcategory = fruitcategory;
	}

	public List<LocationSetting> getLocationsetting() {
		return locationsetting;
	}

	public void setLocationsetting(List<LocationSetting> locationsetting) {
		this.locationsetting = locationsetting;
	}

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUNIT() {
        return UNIT;
    }

    public void setUNIT(Integer UNIT) {
        this.UNIT = UNIT;
    }

    public Integer getAREAID() {
        return AREAID;
    }

    public void setAREAID(Integer AREAID) {
        this.AREAID = AREAID;
    }

    public Integer getCARDID() {
        return CARDID;
    }

    public void setCARDID(Integer CARDID) {
        this.CARDID = CARDID;
    }

    public Integer getCABINID() {
        return CABINID;
    }

    public void setCABINID(Integer CABINID) {
        this.CABINID = CABINID;
    }

    public Integer getFRUITCATEGORYID() {
        return FRUITCATEGORYID;
    }

    public void setFRUITCATEGORYID(Integer FRUITCATEGORYID) {
        this.FRUITCATEGORYID = FRUITCATEGORYID;
    }

    public Integer getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(Integer CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public Integer getUNITNUM() {
        return UNITNUM;
    }

    public void setUNITNUM(Integer UNITNUM) {
        this.UNITNUM = UNITNUM;
    }

    public Integer getDISCARD() {
        return DISCARD;
    }

    public void setDISCARD(Integer DISCARD) {
        this.DISCARD = DISCARD;
    }

    public Float getPRICE() {
        return PRICE;
    }

    public void setPRICE(Float PRICE) {
        this.PRICE = PRICE;
    }

    public Integer getFLAG() {
        return FLAG;
    }

    public void setFLAG(Integer FLAG) {
        this.FLAG = FLAG;
    }

    public Integer getISPAY() {
        return ISPAY;
    }

    public void setISPAY(Integer ISPAY) {
        this.ISPAY = ISPAY;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }
}
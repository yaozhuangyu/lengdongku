package com.jkoss.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysRole {
    private Integer ID;

    private Integer DEPTID;

    private Integer ORDERNO;

    private String ROLENAME;

    private String REMARK;
    
    private List<SysRight> rights = new ArrayList<>();
    
    public List<SysRight> getRights() {
		return rights;
	}

	public void setRights(List<SysRight> rights) {
		this.rights = rights;
	}

	public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDEPTID() {
        return DEPTID;
    }

    public void setDEPTID(Integer DEPTID) {
        this.DEPTID = DEPTID;
    }

    public Integer getORDERNO() {
        return ORDERNO;
    }

    public void setORDERNO(Integer ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public String getROLENAME() {
        return ROLENAME;
    }

    public void setROLENAME(String ROLENAME) {
        this.ROLENAME = ROLENAME == null ? null : ROLENAME.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }
}
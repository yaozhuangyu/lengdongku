package com.jkoss.pojo;

import java.util.Date;

public class SysUser {
    private Integer ID;

    private Integer ROLEID;

    private String EMPNO;

	private String NAME;

    private String PASSWORD;

    private String ACCOUNT;

    private String TELEPHONE;

    private String MOBILE;

    private String EMAIL;

    private Integer STATE;

    private String IDENTITILY;

    private Integer DEPTNO;

    private String ADDRESS;

    private String SCHOOL;

    private Integer EDUCATION;

    private Date AFTERSCHOOL;

    private Date INTIME;

    private String REMARK;

    private String REBACK;
    
    //关联关系
    private SysRole role;

    public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getROLEID() {
        return ROLEID;
    }

    public void setROLEID(Integer ROLEID) {
        this.ROLEID = ROLEID;
    }

    public String getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(String EMPNO) {
        this.EMPNO = EMPNO == null ? null : EMPNO.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }

    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String ACCOUNT) {
        this.ACCOUNT = ACCOUNT == null ? null : ACCOUNT.trim();
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE == null ? null : TELEPHONE.trim();
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE == null ? null : MOBILE.trim();
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    public String getIDENTITILY() {
        return IDENTITILY;
    }

    public void setIDENTITILY(String IDENTITILY) {
        this.IDENTITILY = IDENTITILY == null ? null : IDENTITILY.trim();
    }

    public Integer getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(Integer DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS == null ? null : ADDRESS.trim();
    }

    public String getSCHOOL() {
        return SCHOOL;
    }

    public void setSCHOOL(String SCHOOL) {
        this.SCHOOL = SCHOOL == null ? null : SCHOOL.trim();
    }

    public Integer getEDUCATION() {
        return EDUCATION;
    }

    public void setEDUCATION(Integer EDUCATION) {
        this.EDUCATION = EDUCATION;
    }

    public Date getAFTERSCHOOL() {
        return AFTERSCHOOL;
    }

    public void setAFTERSCHOOL(Date AFTERSCHOOL) {
        this.AFTERSCHOOL = AFTERSCHOOL;
    }

    public Date getINTIME() {
        return INTIME;
    }

    public void setINTIME(Date INTIME) {
        this.INTIME = INTIME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public String getREBACK() {
        return REBACK;
    }

    public void setREBACK(String REBACK) {
        this.REBACK = REBACK == null ? null : REBACK.trim();
    }
}
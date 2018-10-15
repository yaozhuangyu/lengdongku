package com.jkoss.pojo;

public class SysRight {
    private Integer right_id;

    private String rightName;

    private String rightURL;

    private Integer rfloor;

    private Integer parentid;

    private Integer rownum;

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getRightURL() {
        return rightURL;
    }

    public void setRightURL(String rightURL) {
        this.rightURL = rightURL == null ? null : rightURL.trim();
    }

    public Integer getRfloor() {
        return rfloor;
    }

    public void setRfloor(Integer rfloor) {
        this.rfloor = rfloor;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }
}
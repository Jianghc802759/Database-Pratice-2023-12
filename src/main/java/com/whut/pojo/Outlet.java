package com.whut.pojo;

public class Outlet {
    private Integer outletNo;             // 门店编号
    private String outletStreet;          // 门店街道
    private String outletCity;            // 门店城市
    private String outletState;           // 门店州
    private String outletZipCode;         // 门店邮政编码
    private String outletTelNo;           // 门店电话号码
    private String outletFaxNo;           // 门店传真号码
    private String managerEmployeeNo;    // 经理员工编号


    public Outlet() {
    }

    public Outlet(Integer outletNo, String outletStreet, String outletCity, String outletState, String outletZipCode, String outletTelNo, String outletFaxNo, String managerEmployeeNo) {
        this.outletNo = outletNo;
        this.outletStreet = outletStreet;
        this.outletCity = outletCity;
        this.outletState = outletState;
        this.outletZipCode = outletZipCode;
        this.outletTelNo = outletTelNo;
        this.outletFaxNo = outletFaxNo;
        this.managerEmployeeNo = managerEmployeeNo;
    }

    /**
     * 获取
     * @return outletNo
     */
    public Integer getOutletNo() {
        return outletNo;
    }

    /**
     * 设置
     * @param outletNo
     */
    public void setOutletNo(Integer outletNo) {
        this.outletNo = outletNo;
    }

    /**
     * 获取
     * @return outletStreet
     */
    public String getOutletStreet() {
        return outletStreet;
    }

    /**
     * 设置
     * @param outletStreet
     */
    public void setOutletStreet(String outletStreet) {
        this.outletStreet = outletStreet;
    }

    /**
     * 获取
     * @return outletCity
     */
    public String getOutletCity() {
        return outletCity;
    }

    /**
     * 设置
     * @param outletCity
     */
    public void setOutletCity(String outletCity) {
        this.outletCity = outletCity;
    }

    /**
     * 获取
     * @return outletState
     */
    public String getOutletState() {
        return outletState;
    }

    /**
     * 设置
     * @param outletState
     */
    public void setOutletState(String outletState) {
        this.outletState = outletState;
    }

    /**
     * 获取
     * @return outletZipCode
     */
    public String getOutletZipCode() {
        return outletZipCode;
    }

    /**
     * 设置
     * @param outletZipCode
     */
    public void setOutletZipCode(String outletZipCode) {
        this.outletZipCode = outletZipCode;
    }

    /**
     * 获取
     * @return outletTelNo
     */
    public String getOutletTelNo() {
        return outletTelNo;
    }

    /**
     * 设置
     * @param outletTelNo
     */
    public void setOutletTelNo(String outletTelNo) {
        this.outletTelNo = outletTelNo;
    }

    /**
     * 获取
     * @return outletFaxNo
     */
    public String getOutletFaxNo() {
        return outletFaxNo;
    }

    /**
     * 设置
     * @param outletFaxNo
     */
    public void setOutletFaxNo(String outletFaxNo) {
        this.outletFaxNo = outletFaxNo;
    }

    /**
     * 获取
     * @return managerEmployeeNo
     */
    public String getManagerEmployeeNo() {
        return managerEmployeeNo;
    }

    /**
     * 设置
     * @param managerEmployeeNo
     */
    public void setManagerEmployeeNo(String managerEmployeeNo) {
        this.managerEmployeeNo = managerEmployeeNo;
    }

    public String toString() {
        return "Outlet{outletNo = " + outletNo + ", outletStreet = " + outletStreet + ", outletCity = " + outletCity + ", outletState = " + outletState + ", outletZipCode = " + outletZipCode + ", outletTelNo = " + outletTelNo + ", outletFaxNo = " + outletFaxNo + ", managerEmployeeNo = " + managerEmployeeNo + "}";
    }
}

package com.whut.pojo;

public class OutletLocation {
    private String outletStreet;
    private String outletCity;
    private String outletState;


    public OutletLocation() {
    }

    public OutletLocation(String outletStreet, String outletCity, String outletState) {
        this.outletStreet = outletStreet;
        this.outletCity = outletCity;
        this.outletState = outletState;
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

    public String toString() {
        return "OutletLocation{outletStreet = " + outletStreet + ", outletCity = " + outletCity + ", outletState = " + outletState + "}";
    }
}

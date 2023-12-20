package com.whut.pojo;

import java.math.BigDecimal;

public class Vehicle {
    private String vehLicenseNo;  // 车辆牌照号
    private String vehicleMake;   // 车辆制造商
    private String vehicleModel;  // 车辆型号
    private String color;         // 车辆颜色
    private Integer noDoors;      // 车辆门数
    private Integer rentalStatus; // 租用状态
    private Integer maintenanceStatus; // 需要维修状态
    private Integer capacity;     // 车辆容量
    private BigDecimal hireRate;  // 租赁费率
    private Integer outletNo;     // 所属门店编号


    public Vehicle() {
    }

    public Vehicle(String vehLicenseNo, String vehicleMake, String vehicleModel, String color, Integer noDoors, Integer rentalStatus, Integer maintenanceStatus, Integer capacity, BigDecimal hireRate, Integer outletNo) {
        this.vehLicenseNo = vehLicenseNo;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.color = color;
        this.noDoors = noDoors;
        this.rentalStatus = rentalStatus;
        this.maintenanceStatus = maintenanceStatus;
        this.capacity = capacity;
        this.hireRate = hireRate;
        this.outletNo = outletNo;
    }

    /**
     * 获取
     * @return vehLicenseNo
     */
    public String getVehLicenseNo() {
        return vehLicenseNo;
    }

    /**
     * 设置
     * @param vehLicenseNo
     */
    public void setVehLicenseNo(String vehLicenseNo) {
        this.vehLicenseNo = vehLicenseNo;
    }

    /**
     * 获取
     * @return vehicleMake
     */
    public String getVehicleMake() {
        return vehicleMake;
    }

    /**
     * 设置
     * @param vehicleMake
     */
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    /**
     * 获取
     * @return vehicleModel
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * 设置
     * @param vehicleModel
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return noDoors
     */
    public Integer getNoDoors() {
        return noDoors;
    }

    /**
     * 设置
     * @param noDoors
     */
    public void setNoDoors(Integer noDoors) {
        this.noDoors = noDoors;
    }

    /**
     * 获取
     * @return rentalStatus
     */
    public Integer getRentalStatus() {
        return rentalStatus;
    }

    /**
     * 设置
     * @param rentalStatus
     */
    public void setRentalStatus(Integer rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    /**
     * 获取
     * @return maintenanceStatus
     */
    public Integer getMaintenanceStatus() {
        return maintenanceStatus;
    }

    /**
     * 设置
     * @param maintenanceStatus
     */
    public void setMaintenanceStatus(Integer maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    /**
     * 获取
     * @return capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 设置
     * @param capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取
     * @return hireRate
     */
    public BigDecimal getHireRate() {
        return hireRate;
    }

    /**
     * 设置
     * @param hireRate
     */
    public void setHireRate(BigDecimal hireRate) {
        this.hireRate = hireRate;
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

    public String toString() {
        return "Vehicle{vehLicenseNo = " + vehLicenseNo + ", vehicleMake = " + vehicleMake + ", vehicleModel = " + vehicleModel + ", color = " + color + ", noDoors = " + noDoors + ", rentalStatus = " + rentalStatus + ", maintenanceStatus = " + maintenanceStatus + ", capacity = " + capacity + ", hireRate = " + hireRate + ", outletNo = " + outletNo + "}";
    }
}

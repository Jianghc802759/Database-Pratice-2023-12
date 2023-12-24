package com.whut.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class FaultReport {
    private String vehLicenseNo;  // 车辆牌照号，外键，关联到Vehicle表的vehLicenseNo
    private LocalDate dateChecked; // 检查日期
    private LocalTime timeChecked; // 检查时间
    private String comments;       // 备注
    private String employeeNo;    // 员工编号，外键，关联到Employee表的employeeNo


    public FaultReport() {
    }

    public FaultReport(String vehLicenseNo, LocalDate dateChecked, LocalTime timeChecked, String comments, String employeeNo) {
        this.vehLicenseNo = vehLicenseNo;
        this.dateChecked = dateChecked;
        this.timeChecked = timeChecked;
        this.comments = comments;
        this.employeeNo = employeeNo;
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
     * @return dateChecked
     */
    public LocalDate getDateChecked() {
        return dateChecked;
    }

    /**
     * 设置
     * @param dateChecked
     */
    public void setDateChecked(LocalDate dateChecked) {
        this.dateChecked = dateChecked;
    }

    /**
     * 获取
     * @return timeChecked
     */
    public LocalTime getTimeChecked() {
        return timeChecked;
    }

    /**
     * 设置
     * @param timeChecked
     */
    public void setTimeChecked(LocalTime timeChecked) {
        this.timeChecked = timeChecked;
    }

    /**
     * 获取
     * @return comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 获取
     * @return employeeNo
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * 设置
     * @param employeeNo
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String toString() {
        return "FaultReport{vehLicenseNo = " + vehLicenseNo + ", dateChecked = " + dateChecked + ", timeChecked = " + timeChecked + ", comments = " + comments + ", employeeNo = " + employeeNo + "}";
    }
}

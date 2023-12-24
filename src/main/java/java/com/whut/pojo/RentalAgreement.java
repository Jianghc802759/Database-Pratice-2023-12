package com.whut.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RentalAgreement {
    private Integer rentalNo;           // 租赁编号
    private LocalDate dateStart;         // 起租日期
    private LocalTime timeStart;         // 起租时间
    private LocalDate dateReturn;        // 归还日期
    private LocalTime timeReturn;        // 归还时间
    private Integer mileageBefore;       // 租赁前里程
    private Integer mileageAfter;        // 租赁后里程
    private String policyNo;             // 保单编号
    private String insuranceCoverType;   // 保险类型
    private Double insurancePremium;     // 保险费用
    private String clientNo;            // 客户编号，外键，关联到Client表的clientNo
    private String vehLicenseNo;         // 车辆牌照号，外键，关联到Vehicle表的vehLicenseNo


    public RentalAgreement() {
    }

    public RentalAgreement(Integer rentalNo, LocalDate dateStart, LocalTime timeStart, LocalDate dateReturn, LocalTime timeReturn, Integer mileageBefore, Integer mileageAfter, String policyNo, String insuranceCoverType, Double insurancePremium, String clientNo, String vehLicenseNo) {
        this.rentalNo = rentalNo;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateReturn = dateReturn;
        this.timeReturn = timeReturn;
        this.mileageBefore = mileageBefore;
        this.mileageAfter = mileageAfter;
        this.policyNo = policyNo;
        this.insuranceCoverType = insuranceCoverType;
        this.insurancePremium = insurancePremium;
        this.clientNo = clientNo;
        this.vehLicenseNo = vehLicenseNo;
    }

    /**
     * 获取
     * @return rentalNo
     */
    public Integer getRentalNo() {
        return rentalNo;
    }

    /**
     * 设置
     * @param rentalNo
     */
    public void setRentalNo(Integer rentalNo) {
        this.rentalNo = rentalNo;
    }

    /**
     * 获取
     * @return dateStart
     */
    public LocalDate getDateStart() {
        return dateStart;
    }

    /**
     * 设置
     * @param dateStart
     */
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * 获取
     * @return timeStart
     */
    public LocalTime getTimeStart() {
        return timeStart;
    }

    /**
     * 设置
     * @param timeStart
     */
    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * 获取
     * @return dateReturn
     */
    public LocalDate getDateReturn() {
        return dateReturn;
    }

    /**
     * 设置
     * @param dateReturn
     */
    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    /**
     * 获取
     * @return timeReturn
     */
    public LocalTime getTimeReturn() {
        return timeReturn;
    }

    /**
     * 设置
     * @param timeReturn
     */
    public void setTimeReturn(LocalTime timeReturn) {
        this.timeReturn = timeReturn;
    }

    /**
     * 获取
     * @return mileageBefore
     */
    public Integer getMileageBefore() {
        return mileageBefore;
    }

    /**
     * 设置
     * @param mileageBefore
     */
    public void setMileageBefore(Integer mileageBefore) {
        this.mileageBefore = mileageBefore;
    }

    /**
     * 获取
     * @return mileageAfter
     */
    public Integer getMileageAfter() {
        return mileageAfter;
    }

    /**
     * 设置
     * @param mileageAfter
     */
    public void setMileageAfter(Integer mileageAfter) {
        this.mileageAfter = mileageAfter;
    }

    /**
     * 获取
     * @return policyNo
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 设置
     * @param policyNo
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 获取
     * @return insuranceCoverType
     */
    public String getInsuranceCoverType() {
        return insuranceCoverType;
    }

    /**
     * 设置
     * @param insuranceCoverType
     */
    public void setInsuranceCoverType(String insuranceCoverType) {
        this.insuranceCoverType = insuranceCoverType;
    }

    /**
     * 获取
     * @return insurancePremium
     */
    public Double getInsurancePremium() {
        return insurancePremium;
    }

    /**
     * 设置
     * @param insurancePremium
     */
    public void setInsurancePremium(Double insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    /**
     * 获取
     * @return clientNo
     */
    public String getClientNo() {
        return clientNo;
    }

    /**
     * 设置
     * @param clientNo
     */
    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public String toString() {
        return "RentalAgreement{rentalNo = " + rentalNo + ", dateStart = " + dateStart + ", timeStart = " + timeStart + ", dateReturn = " + dateReturn + ", timeReturn = " + timeReturn + ", mileageBefore = " + mileageBefore + ", mileageAfter = " + mileageAfter + ", policyNo = " + policyNo + ", insuranceCoverType = " + insuranceCoverType + ", insurancePremium = " + insurancePremium + ", clientNo = " + clientNo + ", vehLicenseNo = " + vehLicenseNo + "}";
    }
}

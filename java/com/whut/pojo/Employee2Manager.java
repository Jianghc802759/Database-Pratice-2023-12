package com.whut.pojo;

import java.time.LocalDate;

public class Employee2Manager {
    private String employeeNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String workTelExt;
    private String position;
    private String gender;
    private LocalDate dateStarted;


    public Employee2Manager() {
    }

    public Employee2Manager(String employeeNo, String firstName, String middleName, String lastName, String workTelExt, String position, String gender, LocalDate dateStarted) {
        this.employeeNo = employeeNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.workTelExt = workTelExt;
        this.position = position;
        this.gender = gender;
        this.dateStarted = dateStarted;
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

    /**
     * 获取
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 获取
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * 设置
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * 获取
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 获取
     * @return workTelExt
     */
    public String getWorkTelExt() {
        return workTelExt;
    }

    /**
     * 设置
     * @param workTelExt
     */
    public void setWorkTelExt(String workTelExt) {
        this.workTelExt = workTelExt;
    }

    /**
     * 获取
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return dateStarted
     */
    public LocalDate getDateStarted() {
        return dateStarted;
    }

    /**
     * 设置
     * @param dateStarted
     */
    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String toString() {
        return "Employee2Manager{employeeNo = " + employeeNo + ", firstName = " + firstName + ", middleName = " + middleName + ", lastName = " + lastName + ", workTelExt = " + workTelExt + ", position = " + position + ", gender = " + gender + ", dateStarted = " + dateStarted + "}";
    }
}

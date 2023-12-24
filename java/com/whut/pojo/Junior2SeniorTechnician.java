package com.whut.pojo;

public class Junior2SeniorTechnician {
    private String employeeNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String workTelExt;
    private String gender;
    private String dateStarted;


    public Junior2SeniorTechnician() {
    }

    public Junior2SeniorTechnician(String employeeNo, String firstName, String middleName, String lastName, String workTelExt, String gender, String dateStarted) {
        this.employeeNo = employeeNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.workTelExt = workTelExt;
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
    public String getDateStarted() {
        return dateStarted;
    }

    /**
     * 设置
     * @param dateStarted
     */
    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String toString() {
        return "Junior2SeniorTechnician{employeeNo = " + employeeNo + ", firstName = " + firstName + ", middleName = " + middleName + ", lastName = " + lastName + ", workTelExt = " + workTelExt + ", gender = " + gender + ", dateStarted = " + dateStarted + "}";
    }
}

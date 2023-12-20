package com.whut.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String employeeNo;           // 员工编号
    private String title;                 // 职称
    private String firstName;             // 名字
    private String middleName;            // 中间名
    private String lastName;              // 姓氏
    private String address;               // 地址
    private String workTelExt;            // 工作电话分机
    private String homeTelNo;             // 家庭电话号码
    private String empEmailAddress;       // 员工电子邮件地址
    private String socialSecurityNumber;  // 社会安全号码
    private LocalDate DOB;                // 出生日期
    private String position;              // 职位
    private String gender;                     // 性别
    private BigDecimal salary;            // 工资
    private LocalDate dateStarted;        // 入职日期
    private Integer outletNo;             // 所属门店编号


    public Employee() {
    }

    public Employee(String employeeNo, String title, String firstName, String middleName, String lastName, String address, String workTelExt, String homeTelNo, String empEmailAddress, String socialSecurityNumber, LocalDate DOB, String position, String gender, BigDecimal salary, LocalDate dateStarted, Integer outletNo) {
        this.employeeNo = employeeNo;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.workTelExt = workTelExt;
        this.homeTelNo = homeTelNo;
        this.empEmailAddress = empEmailAddress;
        this.socialSecurityNumber = socialSecurityNumber;
        this.DOB = DOB;
        this.position = position;
        this.gender = gender;
        this.salary = salary;
        this.dateStarted = dateStarted;
        this.outletNo = outletNo;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return homeTelNo
     */
    public String getHomeTelNo() {
        return homeTelNo;
    }

    /**
     * 设置
     * @param homeTelNo
     */
    public void setHomeTelNo(String homeTelNo) {
        this.homeTelNo = homeTelNo;
    }

    /**
     * 获取
     * @return empEmailAddress
     */
    public String getEmpEmailAddress() {
        return empEmailAddress;
    }

    /**
     * 设置
     * @param empEmailAddress
     */
    public void setEmpEmailAddress(String empEmailAddress) {
        this.empEmailAddress = empEmailAddress;
    }

    /**
     * 获取
     * @return socialSecurityNumber
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * 设置
     * @param socialSecurityNumber
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * 获取
     * @return DOB
     */
    public LocalDate getDOB() {
        return DOB;
    }

    /**
     * 设置
     * @param DOB
     */
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
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
     * @return salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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
        return "Employee{employeeNo = " + employeeNo + ", title = " + title + ", firstName = " + firstName + ", middleName = " + middleName + ", lastName = " + lastName + ", address = " + address + ", workTelExt = " + workTelExt + ", homeTelNo = " + homeTelNo + ", empEmailAddress = " + empEmailAddress + ", socialSecurityNumber = " + socialSecurityNumber + ", DOB = " + DOB + ", position = " + position + ", gender = " + gender + ", salary = " + salary + ", dateStarted = " + dateStarted + ", outletNo = " + outletNo + "}";
    }
}

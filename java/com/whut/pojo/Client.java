package com.whut.pojo;

public class Client {
    private String clientNo;              // 客户编号
    private String clientName;             // 客户名称
    private String clientStreet;           // 客户街道
    private String clientCity;             // 客户城市
    private String clientState;            // 客户州
    private String clientZipCode;          // 客户邮政编码
    private String clientTelNo;            // 客户电话号码
    private String clientFaxNo;            // 客户传真号码
    private String clientWebAddress;       // 客户网址
    private String contactName;            // 联系人姓名
    private String contactTelNo;           // 联系人电话号码
    private String contactFaxNo;           // 联系人传真号码
    private String contactEmailAddress;    // 联系人电子邮件地址


    public Client() {
    }

    public Client(String clientNo, String clientName, String clientStreet, String clientCity, String clientState, String clientZipCode, String clientTelNo, String clientFaxNo, String clientWebAddress, String contactName, String contactTelNo, String contactFaxNo, String contactEmailAddress) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientStreet = clientStreet;
        this.clientCity = clientCity;
        this.clientState = clientState;
        this.clientZipCode = clientZipCode;
        this.clientTelNo = clientTelNo;
        this.clientFaxNo = clientFaxNo;
        this.clientWebAddress = clientWebAddress;
        this.contactName = contactName;
        this.contactTelNo = contactTelNo;
        this.contactFaxNo = contactFaxNo;
        this.contactEmailAddress = contactEmailAddress;
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
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取
     * @return clientStreet
     */
    public String getClientStreet() {
        return clientStreet;
    }

    /**
     * 设置
     * @param clientStreet
     */
    public void setClientStreet(String clientStreet) {
        this.clientStreet = clientStreet;
    }

    /**
     * 获取
     * @return clientCity
     */
    public String getClientCity() {
        return clientCity;
    }

    /**
     * 设置
     * @param clientCity
     */
    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    /**
     * 获取
     * @return clientState
     */
    public String getClientState() {
        return clientState;
    }

    /**
     * 设置
     * @param clientState
     */
    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    /**
     * 获取
     * @return clientZipCode
     */
    public String getClientZipCode() {
        return clientZipCode;
    }

    /**
     * 设置
     * @param clientZipCode
     */
    public void setClientZipCode(String clientZipCode) {
        this.clientZipCode = clientZipCode;
    }

    /**
     * 获取
     * @return clientTelNo
     */
    public String getClientTelNo() {
        return clientTelNo;
    }

    /**
     * 设置
     * @param clientTelNo
     */
    public void setClientTelNo(String clientTelNo) {
        this.clientTelNo = clientTelNo;
    }

    /**
     * 获取
     * @return clientFaxNo
     */
    public String getClientFaxNo() {
        return clientFaxNo;
    }

    /**
     * 设置
     * @param clientFaxNo
     */
    public void setClientFaxNo(String clientFaxNo) {
        this.clientFaxNo = clientFaxNo;
    }

    /**
     * 获取
     * @return clientWebAddress
     */
    public String getClientWebAddress() {
        return clientWebAddress;
    }

    /**
     * 设置
     * @param clientWebAddress
     */
    public void setClientWebAddress(String clientWebAddress) {
        this.clientWebAddress = clientWebAddress;
    }

    /**
     * 获取
     * @return contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取
     * @return contactTelNo
     */
    public String getContactTelNo() {
        return contactTelNo;
    }

    /**
     * 设置
     * @param contactTelNo
     */
    public void setContactTelNo(String contactTelNo) {
        this.contactTelNo = contactTelNo;
    }

    /**
     * 获取
     * @return contactFaxNo
     */
    public String getContactFaxNo() {
        return contactFaxNo;
    }

    /**
     * 设置
     * @param contactFaxNo
     */
    public void setContactFaxNo(String contactFaxNo) {
        this.contactFaxNo = contactFaxNo;
    }

    /**
     * 获取
     * @return contactEmailAddress
     */
    public String getContactEmailAddress() {
        return contactEmailAddress;
    }

    /**
     * 设置
     * @param contactEmailAddress
     */
    public void setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
    }

    public String toString() {
        return "Client{clientNo = " + clientNo + ", clientName = " + clientName + ", clientStreet = " + clientStreet + ", clientCity = " + clientCity + ", clientState = " + clientState + ", clientZipCode = " + clientZipCode + ", clientTelNo = " + clientTelNo + ", clientFaxNo = " + clientFaxNo + ", clientWebAddress = " + clientWebAddress + ", contactName = " + contactName + ", contactTelNo = " + contactTelNo + ", contactFaxNo = " + contactFaxNo + ", contactEmailAddress = " + contactEmailAddress + "}";
    }
}

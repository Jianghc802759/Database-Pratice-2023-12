package com.whut.service;

import com.whut.pojo.PageBean;
import com.whut.pojo.RentalAgreement;

import java.util.List;
import java.util.Map;

public interface RentalAgreementService {
    /**
     * 添加协议
     * @param rentalAgreement
     */
    boolean addRentalAgreement(RentalAgreement rentalAgreement);

    /**
     * 批量删除协议
     * @param ids
     */
    boolean deleteRentalAgreementByIds(int[] ids);

    /**
     * 更新协议
     * @param rentalAgreement
     */
    boolean updateRentalAgreement(RentalAgreement rentalAgreement);

    /**
     * 查询门店业绩
     * @return
     */
    List<Map<String, String>> selectRentalAgeementByOutlet();

    /**
     * 查询所有协议
     * @return
     */
    List<RentalAgreement> selectAllRentalAgreement();

    PageBean<RentalAgreement> selectRentalAgreementByPage(int currentPage, int pageSize);

    PageBean<RentalAgreement> selectRentalAgreementByPageAndCondition(int currentPage, int pageSize, RentalAgreement rentalAgreement);
}

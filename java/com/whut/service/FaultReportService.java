package com.whut.service;

import com.whut.pojo.FaultReport;
import com.whut.pojo.PageBean;

import java.util.List;

public interface FaultReportService {
    /**
     * 添加报表
     * @param faultReport
     */
    boolean addFaultReport(FaultReport faultReport);

    /**
     * 根据牌照号删除错误报表
     * @param ids
     */
    boolean deleteFaultReportByIds(String[] ids);

    /**
     * 更新报表
     * @param faultReport
     */
    boolean updateFaultReport(FaultReport faultReport);

    /**
     * 查询所有错误报表
     * @return
     */
    List<FaultReport> selectAllFaultReport();

    PageBean<FaultReport> selectFaultReportByPage(int currentPage, int pageSize);

    PageBean<FaultReport> selectFaultReportByPageAndCondition(int currentPage, int pageSize,FaultReport faultReport );
}

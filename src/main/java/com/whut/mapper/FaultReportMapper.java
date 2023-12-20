package com.whut.mapper;

import com.whut.pojo.FaultReport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface FaultReportMapper {
    /**
     * 提交错误报表
     * @param faultReport
     */
    void addFaultReport(FaultReport faultReport) throws SQLException;

    /**
     * 根据牌照号删除错误报表
     * @param ids
     */
    void deleteFaultReportByIds(@Param("ids") String[] ids) throws SQLException;

    /**
     * 修改报表信息
     * @param faultReport
     */
    void updateFaultReport(FaultReport faultReport) throws SQLException;

    /**
     * 查询所有错误报表
     * @return
     */
    @Select("select * from FaultReport")
    List<FaultReport> selectAllFaultReport();

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from FaultReport limit #{begin}, #{size}")
    List<FaultReport> selectFaultReportByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from FaultReport")
    int selectFaultReportCount();

    /**
     * 分页查询报表
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from FaultReport limit #{begin}, #{size}")
    List<FaultReport> selectFaultReportByCondition(@Param("begin") int begin,@Param("size") int size);

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param faultReport
     * @return
     */
    List<FaultReport> selectFaultReportByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("faultReport") FaultReport faultReport);

    /**
     * 根据条件查询总数
     * @param faultReport
     * @return
     */
    int selectFaultReportCountByCondition(FaultReport faultReport);
}

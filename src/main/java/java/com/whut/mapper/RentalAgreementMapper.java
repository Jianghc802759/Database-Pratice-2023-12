package com.whut.mapper;

import com.whut.pojo.RentalAgreement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RentalAgreementMapper {
    /**
     * 添加租赁协议
     * @param rentalAgreement
     */
    void addRentalAgreement(RentalAgreement rentalAgreement) throws SQLException;

    /**
     * 修改租赁协议
     * @param rentalAgreement
     */
    void updateRentalAgreement(RentalAgreement rentalAgreement) throws SQLException;

    /**
     * 删除租赁协议
     * @param ids
     */
    void deleteRentalAgreementByIds(@Param("ids") int[] ids) throws SQLException;

    /**
     * 租赁协议总数
     * @return
     */
    @Select("select count(*) from RentalAgreement")
    int selectRentalAgreementCount();

    /**
     * 查询门店对应的业绩
     * @return
     */
    @Select("select outletNo, totalCount from RentalAgreementByOutlet group by outletNo order by totalCount desc ")
    List<Map<String, String>> selectRentalAgreementByOutlet();

    /**
     * 查询所有租赁协议
     * @return
     */
    @Select("select * from RentalAgreement")
    List<RentalAgreement> selectAllRentalAgreement();

    @Select("select * from RentalAgreement limit #{begin}, #{size}")
    List<RentalAgreement> selectRentalAgreementByPage(@Param("begin")int begin, @Param("size")int size);

    /**
     * 条件分页查询
     * @param begin
     * @param size
     * @param rentalAgreement
     * @return
     */
    List<RentalAgreement> selectRentalAgreementByPageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("rentalAgreement") RentalAgreement rentalAgreement);

    /**
     * 条件查询总数
     * @param rentalAgreement
     * @return
     */
    int selectRentalAgreementCountByCondition(RentalAgreement rentalAgreement);
}

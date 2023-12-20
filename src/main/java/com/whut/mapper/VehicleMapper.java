package com.whut.mapper;

import com.whut.pojo.Vehicle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface VehicleMapper {
    /**
     * 添加汽车
     * @param vehicle
     */
    void addVehicle(Vehicle vehicle) throws SQLException;

    /**
     * 根据编号删除车辆
     * @param ids
     */
    void deleteVehicleByIds(@Param("ids") String[] ids) throws  SQLException;

    /**
     * 修改汽车信息
     * @param vehicle
     */
    void updateVehicle(Vehicle vehicle) throws SQLException;

    /**
     * 汽车总数
     * @return
     */
    @Select("select count(*) from Vehicle")
    int selectVehicleCount();

    /**
     * 查询所有汽车
     * @return
     */
    @Select("select * from Vehicle")
    List<Vehicle> selectAllVehicle();

    /**
     * 根据门店查询车辆
     * @param outletNo
     * @return
     */
    @Select("select * from Vehicle where outletNo = #{outletNo}")
    List<Vehicle> selectVehicleByOutlet(int outletNo);

    /**
     * 分页查询汽车
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from Vehicle limit #{begin}, #{size}")
    List<Vehicle> selectVehicleByPage(@Param("begin")int begin, @Param("size")int size);

    /**
     * 条件分页查询汽车
     * @param begin
     * @param size
     * @param vehicle
     * @return
     */
    List<Vehicle> selectVehicleByPageAndCondition(@Param("begin")int begin, @Param("size")int size, @Param("vehicle")Vehicle vehicle);

    /**
     * 条件查询总数
     * @param vehicle
     * @return
     */
    int selectVehicleCountByCondition(Vehicle vehicle);

}

package com.whut.mapper;

import org.apache.ibatis.annotations.Select;

public interface VehicleIDMapper {
    /**
     * 判断此牌照是否唯一
     * @param vehicleID
     * @return
     */
    @Select("select count(*) from VehicleID where vehicleID = #{vehicleID}")
    int getIDCount(String vehicleID);
}

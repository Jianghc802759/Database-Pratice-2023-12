package com.whut.mapper;

import org.apache.ibatis.annotations.Select;

public interface PolicyIDMapper {
    /**
     * 查询保单编号数量
     * @param policyID
     * @return
     */
    @Select("select count(*) from PolicyID where policyID = #{policyID}")
    int getIDCount(String policyID);
}

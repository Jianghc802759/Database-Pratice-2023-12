package com.whut.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserIDMapper {
    /**
     * 判断此用户编号是否唯一
     * @param userID
     * @return
     */
    @Select("select count(*) from UserID where userID = #{userID}")
    int getIDCount(String userID);
}

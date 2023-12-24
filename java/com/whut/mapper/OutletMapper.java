package com.whut.mapper;

import com.whut.pojo.Outlet;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OutletMapper {
    /**
     * 添加门店
     * @param outlet
     */
    void addOutlet(Outlet outlet) throws SQLException;

    /**
     * 根据编号删除门店
     * @param ids
     */
    void deleteOutletByIds(@Param("ids") int[] ids) throws SQLException;

    /**
     * 修改门店信息
     * @param outlet
     */
    void updateOutlet(Outlet outlet) throws SQLException;

    /**
     * 查询所有门店信息
     */
    @Select("select * from Outlet")
    List<Outlet> selectAllOutlet();

    /**
     * 门店总数
     * @return
     */
    @Select("select count(*) from Outlet")
    int selectOutletCount();

    /**
     * 客户查询门店信息
     * @param outletStreet
     * @param outletCity
     * @param outletState
     * @return
     */
    List<Outlet> selectOutletByCondition(@Param("outletStreet")String outletStreet, @Param("outletCity") String outletCity,@Param("outletState") String outletState);

    /**
     * 分页查询门店
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from Outlet limit #{begin}, #{limit}")
    List<Outlet> selectOutletByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 分页条件查询门店
     * @param begin
     * @param size
     * @param outlet
     * @return
     */
    List<Outlet> selectOutletByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("outlet") Outlet outlet);

    /**
     * 条件查询总数
     * @param outlet
     * @return
     */
    int selectOutletCountByCondition(Outlet outlet);

    /**
     * 查询门店州
     * @return
     */
    @Select("select * from OutletStateView")
    List<Map<String, String>> selectOutletState();

    /**
     * 查询门店城市
     * @return
     */
    @Select("select * from OutletCityView")
    List<Map<String, String>> selectOutletCity();

    /**
     * 查询门店州
     * @return
     */
    @Select("select * from OutletStreetView")
    List<Map<String, String>> selectOutletStreet();
}

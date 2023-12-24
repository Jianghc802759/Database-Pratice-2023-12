package com.whut.service;

import com.whut.pojo.Outlet;
import com.whut.pojo.PageBean;

import java.util.List;
import java.util.Map;

public interface OutletService {
    /**
     * 添加门店
     * @param outlet
     */
    boolean addOutlet(Outlet outlet);

    /**
     * 删除门店
     * @param ids
     */
    boolean deleteOutletByIds(int[] ids);

    /**
     * 更新门店信息
     * @param outlet
     */
    boolean updateOutlet(Outlet outlet);

    /**
     * 查询门店街道
     * @return
     */
    List<Map<String, String>> selectOutletStreet();

    /**
     * 查询门店城市
     * @return
     */
    List<Map<String, String>> selectOutletCity();

    /**
     * 查询门店州
     * @return
     */
    List<Map<String, String>> selectOutletState();



    /**
     * 客户查询门店
     * @param outletStreet
     * @param outletCity
     * @param outletState
     * @return
     */
    List<Outlet> selectOutletByCondition(String outletStreet, String outletCity, String outletState);

    /**
     * 查询所有门店
     * @return
     */
    List<Outlet> selectAllOutlet();

    PageBean<Outlet> selectOutletByPage(int currentPage, int pageSize);

    PageBean<Outlet> selectOutletByPageAndCondition(int currentPage, int pageSize, Outlet outlet);
}

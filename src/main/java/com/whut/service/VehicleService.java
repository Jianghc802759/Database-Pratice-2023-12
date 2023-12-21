package com.whut.service;

import com.whut.pojo.PageBean;
import com.whut.pojo.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    /**
     * 添加汽车
     * @param vehicle
     */
    boolean addVehicle(Vehicle vehicle);

    /**
     * 根据牌照号删除汽车
     * @param ids
     */
    boolean deleteVehicleByIds(String[] ids);

    /**
     * 更新汽车信息
     * @param vehicle
     */
    boolean updateVehicle(Vehicle vehicle);

    /**
     * 所有汽车
     * @return
     */
    List<Vehicle> selectAllVehicle();

    /**
     *  查询可用汽车
     * @param outlet
     * @return
     */
    List<Vehicle> selectVehicleToClient(int outlet);

    /**
     * 查询汽车制造商
     * @return
     */
    List<Map<String, String>> selectVehicleMake();

    /**
     * 查询汽车型号
     * @return
     */
    List<Map<String, String>> selectVehicleModel();

    /**
     * 查询汽车颜色
     * @return
     */
    List<Map<String, String>> selectVehicleColor();

    /**
     * 经理查询门店汽车
     * @param outletNo
     * @return
     */
    List<Vehicle> selectVehicleByOutlet(int outletNo);

    PageBean<Vehicle> selectVehicleByPage(int currentPage, int pageSize);

    PageBean<Vehicle> selectVehicleByPageAndCondition(int currentPage, int pageSize, Vehicle vehicle);
}

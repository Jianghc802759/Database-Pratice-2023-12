package com.whut.service.impl;

import com.whut.mapper.VehicleIDMapper;
import com.whut.mapper.VehicleMapper;
import com.whut.pojo.PageBean;
import com.whut.pojo.Vehicle;
import com.whut.service.VehicleService;
import com.whut.util.GenerateVehicleID;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public class VehicleServiceImpl implements VehicleService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    GenerateVehicleID generateVehicleID = new GenerateVehicleID();

    /**
     * 添加汽车
     * @param vehicle
     * @return
     */
    @Override
    public boolean addVehicle(Vehicle vehicle) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);
        VehicleIDMapper vehicleIDMapper = sqlSession.getMapper(VehicleIDMapper.class);

        try {
            while(true){
                String vehicleNo = generateVehicleID.getVehicleID();
                if(vehicleIDMapper.getIDCount(vehicleNo) == 0){
                    vehicle.setVehLicenseNo(vehicleNo);
                    vehicleMapper.addVehicle(vehicle);
                    sqlSession.commit();
                    break;
                }
            }
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量删除汽车
     * @param ids
     * @return
     */
    @Override
    public boolean deleteVehicleByIds(String[] ids) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        try {
            vehicleMapper.deleteVehicleByIds(ids);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 更新汽车信息
     * @param vehicle
     * @return
     */
    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        try {
            vehicleMapper.updateVehicle(vehicle);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 查询所有汽车
     * @return
     */
    @Override
    public List<Vehicle> selectAllVehicle() {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Vehicle> vehicles = vehicleMapper.selectAllVehicle();

        sqlSession.close();

        return vehicles;
    }

    @Override
    public Integer selectVehicleMile(String vehLicenseNo) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        Integer vehicleMile = vehicleMapper.selectVehicleMile(vehLicenseNo);

        sqlSession.close();

        return vehicleMile;
    }

    /**
     * 客户查询可用汽车
     * @param outlet
     * @return
     */
    @Override
    public List<Vehicle> selectVehicleToClient(int outlet) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Vehicle> vehicles = vehicleMapper.selectVehicleToClient(outlet);

        sqlSession.close();

        return vehicles;
    }

    /**
     * 查询汽车制造商、型号、颜色视图
     * @return
     */
    @Override
    public List<Map<String, String>> selectVehicleMake() {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Map<String, String>> vehicleMakes = vehicleMapper.selectVehicleMake();

        sqlSession.close();

        return vehicleMakes;
    }

    @Override
    public List<Map<String, String>> selectVehicleModel() {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Map<String, String>> vehicleModels = vehicleMapper.selectVehicleModel();

        sqlSession.close();

        return vehicleModels;
    }

    @Override
    public List<Map<String, String>> selectVehicleColor() {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Map<String, String>> vehicleColors = vehicleMapper.selectVehicleColor();

        sqlSession.close();

        return vehicleColors;
    }

    /**
     * 经理查询汽车信息
     * @param outletNo
     * @return
     */
    @Override
    public List<Vehicle> selectVehicleByOutlet(int outletNo) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        List<Vehicle> vehicles = vehicleMapper.selectVehicleByOutlet(outletNo);

        sqlSession.close();

        return vehicles;
    }

    @Override
    public PageBean<Vehicle> selectVehicleByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Vehicle> rows = vehicleMapper.selectVehicleByPage(begin, size);

        int totalCount = vehicleMapper.selectVehicleCount();

        PageBean<Vehicle> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Vehicle> selectVehicleByPageAndCondition(int currentPage, int pageSize, Vehicle vehicle) {
        SqlSession sqlSession = factory.openSession();
        VehicleMapper vehicleMapper = sqlSession.getMapper(VehicleMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        String vehicleMake = vehicle.getVehicleMake();
        if(vehicleMake != null && vehicleMake.length() > 0){
            vehicle.setVehicleMake("%" + vehicleMake + "%");
        }
        String vehicleModel = vehicle.getVehicleModel();
        if(vehicleModel != null && vehicleModel.length() > 0){
            vehicle.setVehicleModel("%" + vehicleModel + "%");
        }

        List<Vehicle> rows = vehicleMapper.selectVehicleByPageAndCondition(begin, size, vehicle);
        int totalCount = vehicleMapper.selectVehicleCountByCondition(vehicle);

        PageBean<Vehicle> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setRows(rows);

        sqlSession.close();

        return pageBean;
    }
}

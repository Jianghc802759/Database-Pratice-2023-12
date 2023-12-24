package com.whut.service.impl;

import com.whut.mapper.EmployeeMapper;
import com.whut.mapper.OutletMapper;
import com.whut.pojo.Outlet;
import com.whut.pojo.PageBean;
import com.whut.service.OutletService;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

public class OutletServiceImpl implements OutletService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 添加门店
     * @param outlet
     * @return
     */
    @Override
    public boolean addOutlet(Outlet outlet) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        try {
            outletMapper.addOutlet(outlet);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量删除门店
     * @param ids
     * @return
     */
    @Override
    public boolean deleteOutletByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        try {
            outletMapper.deleteOutletByIds(ids);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 更新门店
     * @param outlet
     * @return
     */
    @Override
    public boolean updateOutlet(Outlet outlet) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        try {
            outletMapper.updateOutlet(outlet);
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
     * 查询门店街道、城市、州视图
     * @return
     */
    @Override
    public List<Map<String, String>> selectOutletStreet() {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        List<Map<String, String>> outletStreets = outletMapper.selectOutletStreet();

        sqlSession.close();

        return outletStreets;
    }

    @Override
    public List<Map<String, String>> selectOutletCity() {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        List<Map<String, String>> outletCitys = outletMapper.selectOutletCity();

        sqlSession.close();

        return outletCitys;
    }

    @Override
    public List<Map<String, String>> selectOutletState() {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        List<Map<String, String>> outletStates = outletMapper.selectOutletState();

        sqlSession.close();

        return outletStates;
    }

    @Override
    public List<Outlet> selectOutletByCondition(String outletStreet, String outletCity, String outletState) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        if(outletStreet != null && outletStreet.length() > 0){
            outletStreet = "%" + outletStreet + "%";
        }
        if(outletCity != null && outletCity.length() > 0){
            outletCity = "%" + outletCity + "%";
        }
        if(outletState != null && outletState.length() > 0){
            outletState = "%" + outletState + "%";
        }

        List<Outlet> outlets = outletMapper.selectOutletByCondition(outletStreet, outletCity, outletState);

        if(outlets != null){
            int len = outlets.size();
            for(int i = 0; i < len; i++){
                Integer outletNo = outlets.get(i).getOutletNo();
                outlets.get(i).setManagerEmployeeNo(employeeMapper.selectManagerByOutlet(outletNo));
            }
        }

        sqlSession.close();

        return outlets;
    }

    /**
     * 查询所有门店
     * @return
     */
    @Override
    public List<Outlet> selectAllOutlet() {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Outlet> outlets = outletMapper.selectAllOutlet();

        if(outlets != null){
            int len = outlets.size();
            for(int i = 0; i < len; i++){
                Integer outletNo = outlets.get(i).getOutletNo();
                outlets.get(i).setManagerEmployeeNo(employeeMapper.selectManagerByOutlet(outletNo));
            }
        }

        sqlSession.close();

        return outlets;
    }

    @Override
    public PageBean<Outlet> selectOutletByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Outlet> rows = outletMapper.selectOutletByPage(begin, size);

        int totalCount = outletMapper.selectOutletCount();

        PageBean<Outlet> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Outlet> selectOutletByPageAndCondition(int currentPage, int pageSize, Outlet outlet) {
        SqlSession sqlSession = factory.openSession();
        OutletMapper outletMapper = sqlSession.getMapper(OutletMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        String outletStreet = outlet.getOutletStreet();
        if(outletStreet != null && outletStreet.length() > 0){
            outlet.setOutletStreet("%" + outletStreet + "%");
        }
        String outletCity = outlet.getOutletCity();
        if(outletCity != null && outletCity.length() > 0){
            outlet.setOutletCity("%" + outletCity + "%");
        }
        String outletState = outlet.getOutletState();
        if(outletState != null && outletState.length() > 0){
            outlet.setOutletState("%" + outletState + "%");
        }

        List<Outlet> rows = outletMapper.selectOutletByPageAndCondition(begin, size, outlet);
        int totalCount = outletMapper.selectOutletCountByCondition(outlet);

        PageBean<Outlet> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setRows(rows);

        sqlSession.close();

        return pageBean;
    }
}

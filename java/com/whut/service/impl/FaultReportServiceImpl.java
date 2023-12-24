package com.whut.service.impl;

import com.whut.mapper.FaultReportMapper;
import com.whut.pojo.FaultReport;
import com.whut.pojo.PageBean;
import com.whut.service.FaultReportService;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class FaultReportServiceImpl implements FaultReportService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 添加报表
     * @param faultReport
     * @return
     */
    @Override
    public boolean addFaultReport(FaultReport faultReport) {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        try {
            faultReportMapper.addFaultReport(faultReport);
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
     * 批量删除报表
     * @param ids
     * @return
     */
    @Override
    public boolean deleteFaultReportByIds(String[] ids) {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        try {
            faultReportMapper.deleteFaultReportByIds(ids);
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
     * 更新报表
     * @param faultReport
     * @return
     */
    @Override
    public boolean updateFaultReport(FaultReport faultReport) {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        try {
            faultReportMapper.updateFaultReport(faultReport);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            return false;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询所有报表
     * @return
     */
    @Override
    public List<FaultReport> selectAllFaultReport() {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        List<FaultReport> faultReports = faultReportMapper.selectAllFaultReport();

        sqlSession.commit();

        return faultReports;
    }

    @Override
    public PageBean<FaultReport> selectFaultReportByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<FaultReport> rows = faultReportMapper.selectFaultReportByPage(begin, size);

        int totalCount = faultReportMapper.selectFaultReportCount();

        PageBean<FaultReport> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<FaultReport> selectFaultReportByPageAndCondition(int currentPage, int pageSize, FaultReport faultReport) {
        SqlSession sqlSession = factory.openSession();
        FaultReportMapper faultReportMapper = sqlSession.getMapper(FaultReportMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        List<FaultReport> rows = faultReportMapper.selectFaultReportByPageAndCondition(begin, size, faultReport);
        int totalCount = faultReportMapper.selectFaultReportCountByCondition(faultReport);

        PageBean<FaultReport> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}

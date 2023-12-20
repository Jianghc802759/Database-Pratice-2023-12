package com.whut.service.impl;

import com.whut.mapper.RentalAgreementMapper;
import com.whut.pojo.PageBean;
import com.whut.pojo.RentalAgreement;
import com.whut.service.RentalAgreementService;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class RentalAgreementServiceImpl implements RentalAgreementService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 添加租赁协议
     * @param rentalAgreement
     * @return
     */
    @Override
    public boolean addRentalAgreement(RentalAgreement rentalAgreement) {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        try {
            rentalAgreementMapper.addRentalAgreement(rentalAgreement);
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
     * 批量删除租赁协议
     * @param ids
     * @return
     */
    @Override
    public boolean deleteRentalAgreementByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        try {
            rentalAgreementMapper.deleteRentalAgreementByIds(ids);
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
     * 更新租赁协议
     * @param rentalAgreement
     * @return
     */
    @Override
    public boolean updateRentalAgreement(RentalAgreement rentalAgreement) {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        try {
            rentalAgreementMapper.updateRentalAgreement(rentalAgreement);
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
     * 查询所有租赁协议
     * @return
     */
    @Override
    public List<RentalAgreement> selectAllRentalAgreement() {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        List<RentalAgreement> rentalAgreements = rentalAgreementMapper.selectAllRentalAgreement();

        sqlSession.close();

        return rentalAgreements;
    }

    @Override
    public PageBean<RentalAgreement> selectRentalAgreementByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<RentalAgreement> rows = rentalAgreementMapper.selectRentalAgreementByPage(begin, size);

        int totalCount = rentalAgreementMapper.selectRentalAgreementCount();

        PageBean<RentalAgreement> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<RentalAgreement> selectRentalAgreementByPageAndCondition(int currentPage, int pageSize, RentalAgreement rentalAgreement) {
        SqlSession sqlSession = factory.openSession();
        RentalAgreementMapper rentalAgreementMapper = sqlSession.getMapper(RentalAgreementMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        List<RentalAgreement> rows = rentalAgreementMapper.selectRentalAgreementByPageAndCondition(begin, size, rentalAgreement);
        int totalCount = rentalAgreementMapper.selectRentalAgreementCountByCondition(rentalAgreement);

        PageBean<RentalAgreement> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }
}

package com.whut.service.impl;

import com.whut.mapper.EmployeeMapper;
import com.whut.mapper.UserIDMapper;
import com.whut.pojo.Employee;
import com.whut.pojo.Employee2Manager;
import com.whut.pojo.Junior2SeniorTechnician;
import com.whut.pojo.PageBean;
import com.whut.service.EmployeeService;
import com.whut.util.GenerateUserId;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    GenerateUserId generateUserId = new GenerateUserId();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public boolean addEmployee(Employee employee) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        UserIDMapper userIDMapper = sqlSession.getMapper(UserIDMapper.class);

        try{
            while(true){
                String employeeNo = "E" + generateUserId.getUserId();
                if(userIDMapper.getIDCount(employeeNo) == 0){
                    employee.setEmployeeNo(employeeNo);
                    employeeMapper.addEmployee(employee);
                    sqlSession.commit();
                    break;
                }
            }
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            if(e.getSQLState().equals("23000")){
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
        return false;
    }

    /**
     * 批量删除员工
     * @param ids
     * @return
     */
    @Override
    public boolean deleteEmployeeByIds(String[] ids) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        try {
            employeeMapper.deleteEmployeeByIds(ids);
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
     * 更新员工信息
     * @param employee
     * @return
     */
    @Override
    public boolean updateEmployee(Employee employee) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        try{
            employeeMapper.updateEmployee(employee);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            if(e.getSQLState().equals("23000")){
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
        return false;
    }

    /**
     * 员工查询个人信息
     * @param employeeNo
     * @return
     */
    @Override
    public Employee selectEmployee(String employeeNo) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.selectEmployee(employeeNo);

        sqlSession.close();

        return employee;
    }

    /**
     * 查询门店经理
     * @param outlet
     * @return
     */
    @Override
    public String selectManagerByOutlet(int outlet) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        String managerNo = employeeMapper.selectManagerByOutlet(outlet);

        sqlSession.close();

        return managerNo;
    }

    /**
     * 经理查看员工信息
     * @param outletNo
     * @return
     */
    @Override
    public List<Employee2Manager> selectEmployeeByManager(int outletNo) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee2Manager> employees = employeeMapper.selectEmployeeByManager(outletNo);

        sqlSession.close();

        return employees;
    }

    /**
     * 高级技工查询普通技工信息
     * @param outlet
     * @return
     */
    @Override
    public List<Junior2SeniorTechnician> selectJuniorBySenior(int outlet) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Junior2SeniorTechnician> employees = employeeMapper.selectJuniorBySenior(outlet);

        sqlSession.close();

        return employees;
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Employee> selectAllEmployee() {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = employeeMapper.selectAllEmployee();

        sqlSession.close();

        return employees;
    }

    @Override
    public PageBean<Employee> selectEmployeeByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Employee> rows = employeeMapper.selectEmployeeByPage(begin, size);

        int totalCount = employeeMapper.selectEmployeeCount();

        PageBean<Employee> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Employee> selectEmployeeByPageAndCondition(int currentPage, int pageSize, Employee employee) {
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        String title = employee.getTitle();
        if(title != null && title.length() > 0){
            employee.setTitle("%" + title + "%");
        }
        String firstName = employee.getFirstName();
        if(firstName != null && firstName.length() > 0){
            employee.setFirstName("%" + firstName + "%");
        }
        String middleName = employee.getMiddleName();
        if(middleName != null && middleName.length() > 0){
            employee.setMiddleName("%" + middleName + "%");
        }
        String lastName = employee.getLastName();
        if(lastName != null && lastName.length() > 0){
            employee.setLastName("%" + lastName + "%");
        }
        String position = employee.getPosition();
        if(position != null && position.length() > 0){
            employee.setPosition("%" + position + "%");
        }

        List<Employee> rows = employeeMapper.selectEmployeeByPageAndCondition(begin, size, employee);
        int totalCount = employeeMapper.selectEmployeeCountByCondition(employee);

        PageBean<Employee> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setRows(rows);

        sqlSession.close();

        return pageBean;
    }
}

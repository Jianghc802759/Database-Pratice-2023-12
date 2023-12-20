package com.whut.service;

import com.whut.pojo.Employee;
import com.whut.pojo.Employee2Manager;
import com.whut.pojo.Junior2SeniorTechnician;
import com.whut.pojo.PageBean;

import java.util.List;

public interface EmployeeService {
    /**
     * 添加员工
     * @param employee
     */
    boolean addEmployee(Employee employee);

    /**
     * 批量删除员工
     * @param ids
     */
    boolean deleteEmployeeByIds(String[] ids);

    /**
     * 修改员工信息
     * @param employee
     */
    boolean updateEmployee(Employee employee);

    /**
     * 查询员工个人信息
     * @param employeeNo
     * @return
     */
    Employee selectEmployee(String employeeNo);

    /**
     * 查询门店对应的经理
     * @param outlet
     * @return
     */
    String selectManagerByOutlet(int outlet);

    /**
     * 根据经理返回所在门店的技工
     * @param outletNo
     * @return
     */
    List<Employee2Manager> selectEmployeeByManager(int outletNo);

    /**
     * 根据高级技工返回所在门店的普通技工
     * @param outlet
     * @return
     */
    List<Junior2SeniorTechnician> selectJuniorBySenior(int outlet);

    /**
     * 返回所有员工
     * @return
     */
    List<Employee> selectAllEmployee();

    PageBean<Employee> selectEmployeeByPage(int currentPage, int pageSize);

    PageBean<Employee> selectEmployeeByPageAndCondition(int currentPage, int pageSize, Employee employee);
}

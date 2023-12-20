package com.whut.mapper;

import com.whut.pojo.Employee;
import com.whut.pojo.Employee2Manager;
import com.whut.pojo.Junior2SeniorTechnician;
import com.whut.pojo.PageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeMapper {
    /**
     * 添加员工
     * @param employee
     */
    void addEmployee(Employee employee) throws SQLException;

    /**
     * 根据编号删除员工
     * @param ids
     */
    void deleteEmployeeByIds(@Param("ids") String ids[]) throws SQLException;

    /**
     * 查询员工基本信息
     * @param employeeNo
     * @return
     */
    @Select("select * from Employee where empployeeNo = #{employeeNo}")
    Employee selectEmployee(String employeeNo);

    /**
     * 修改员工信息
     * @param employee
     */
    void updateEmployee(Employee employee) throws SQLException;

    /**
     * 查询门店对应的经理
     * @param outletNo
     * @return
     */
    @Select("select employeeNo from Employee where title = 'Manager' and outletNo = #{outletNo}")
    String selectManagerByOutlet(int outletNo);

    /**
     * 根据经理返回其所在门店对应的技工信息
     * @param outletNo
     * @return
     */
    @Select("select * from EmployeeToManagerView where outlet = #{outlet}")
    List<Employee2Manager> selectEmployeeByManager(int outletNo);

    /**
     * 根据高级技工返回所在门店的普通技工
     * @param outlet
     * @return
     */
    @Select("select * from JuniorToSeniorTechnicianView where outlet = #{outlet}")
    List<Junior2SeniorTechnician> selectJuniorBySenior(int outlet);

    /**
     * 查询所有员工
     * @return
     */
    @Select("select * from Employee")
    List<Employee> selectAllEmployee();

    /**
     * 员工总数
     * @return
     */
    @Select("select count(*) from Employee")
    int selectEmployeeCount();

    /**
     * 分页查询员工
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from Employee limit #{begin}, #{size}")
    List<Employee> selectEmployeeByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 条件分页查询员工
     * @param begin
     * @param size
     * @param employee
     * @return
     */
    List<Employee> selectEmployeeByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("employee") Employee employee);

    /**
     * 条件查询总数
     * @param employee
     * @return
     */
    int selectEmployeeCountByCondition(Employee employee);
}

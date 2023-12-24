package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.mapper.EmployeeMapper;
import com.whut.pojo.*;
import com.whut.service.EmployeeService;
import com.whut.service.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/employee/*")
public class EmployeeServlet extends BaseServlet {
   private EmployeeService employeeService = new EmployeeServiceImpl();

   public void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      BufferedReader br = request.getReader();
      String params = br.readLine();

      Employee employee = JSON.parseObject(params, Employee.class);

      if(employeeService.addEmployee(employee) == true){
         response.getWriter().write("{\"success\": true}");
      } else{
         response.getWriter().write("{\"success\": false}");
      }
   }

   public void deleteEmployeeByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      BufferedReader br = request.getReader();
      String params = br.readLine();

      String[] ids = JSON.parseObject(params, String[].class);

      if(employeeService.deleteEmployeeByIds(ids) == true){
         response.getWriter().write("{\"success\": true}");
      } else{
         response.getWriter().write("{\"success\": false}");
      }
   }

   public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      BufferedReader br = request.getReader();
      String params = br.readLine();

      Employee employee = JSON.parseObject(params, Employee.class);

      if(employeeService.updateEmployee((employee)) == true) {
         response.getWriter().write("{\"success\": true}");
      } else{
         response.getWriter().write("{\"success\": false}");
      }
   }

   public void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      BufferedReader br = request.getReader();
      String params = br.readLine();

      UserInfo userInfo = JSON.parseObject(params, UserInfo.class);

      String username = userInfo.getUsername();
      String password = userInfo.getPassword();

      if(employeeService.employeeLogin(username, password)){
         HttpSession session = request.getSession();
         Integer outletNo = employeeService.selectEmployee(username).getOutletNo();
         session.setAttribute("outletNo",outletNo);
         session.setAttribute("employeeNo",username);
         System.out.println(username);

         response.getWriter().write("{\"success\": true}");
      } else{
         response.getWriter().write("{\"success\": false}");
      }
   }

   public void selectEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      HttpSession session = request.getSession();
      String employeeNo = (String) session.getAttribute("employeeNo");
      System.out.println(employeeNo);

      Employee employee = employeeService.selectEmployee(employeeNo);

      String jsonString = JSON.toJSONString(employee);

      System.out.println("展示员工信息");
      System.out.println(jsonString);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      List<Employee> employees = employeeService.selectAllEmployee();

      String jsonString = JSON.toJSONString(employees);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeeGender(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      List<Map<String,String>> employeeGenders = employeeService.selectEmployeeGender();

      String jsonString = JSON.toJSONString(employeeGenders);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeePosition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      List<Map<String,String>> employeePositions = employeeService.selectEmployeePosition();

      String jsonString = JSON.toJSONString(employeePositions);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeeWorkload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      List<Map<String,String>> employeeWorkloads = employeeService.selectEmployeeWorkload();

      String jsonString = JSON.toJSONString(employeeWorkloads);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeeByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      HttpSession session = request.getSession();
      int outletNo = (Integer) session.getAttribute("outletNo");

      List<Employee2Manager> employee2Managers = employeeService.selectEmployeeByManager(outletNo);

      String jsonString = JSON.toJSONString(employee2Managers);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectJuniorBySenior(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      HttpSession session = request.getSession();
      int outletNo = (Integer) session.getAttribute("outletNo");

      List<Junior2SeniorTechnician> junior2SeniorTechnicians = employeeService.selectJuniorBySenior(outletNo);
      String jsonString = JSON.toJSONString(junior2SeniorTechnicians);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeeByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      int currentPage = Integer.parseInt(request.getParameter("currentPage"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));

      PageBean<Employee> pageBean = employeeService.selectEmployeeByPage(currentPage, pageSize);

      String jsonString = JSON.toJSONString(pageBean);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }

   public void selectEmployeeByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      BufferedReader br = request.getReader();
      String params = br.readLine();

      Employee employee = JSON.parseObject(params, Employee.class);

      int currentPage = Integer.parseInt(request.getParameter("currentPage"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));

      PageBean<Employee> pageBean = employeeService.selectEmployeeByPageAndCondition(currentPage, pageSize, employee);

      String jsonString = JSON.toJSONString(pageBean);

      response.setContentType("text/json;charset=utf-8");
      response.getWriter().write(jsonString);
   }
}

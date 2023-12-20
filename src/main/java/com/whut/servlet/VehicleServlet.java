package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.PageBean;
import com.whut.pojo.Vehicle;
import com.whut.service.VehicleService;
import com.whut.service.impl.VehicleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicle/*")
public class VehicleServlet extends BaseServlet {
    private VehicleService vehicleService = new VehicleServiceImpl();

    public void addVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Vehicle vehicle = JSON.parseObject(params, Vehicle.class);

        if(vehicleService.addVehicle(vehicle) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void deleteVehicleByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        String[] ids = JSON.parseObject(params, String[].class);

        if(vehicleService.deleteVehicleByIds(ids) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Vehicle vehicle = JSON.parseObject(params, Vehicle.class);

        if(vehicleService.updateVehicle(vehicle) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void selectAllVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Vehicle> vehicles = vehicleService.selectAllVehicle();

        String jsonString = JSON.toJSONString(vehicles);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectVehicleByOutlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int outletNo = Integer.parseInt(request.getParameter("outletNo"));

        List<Vehicle> vehicles = vehicleService.selectVehicleByOutlet(outletNo);

        String jsonString = JSON.toJSONString(vehicles);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectVehicleByManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int outletNo = Integer.parseInt((String) session.getAttribute("outletNo"));

        List<Vehicle> vehicles = vehicleService.selectVehicleByOutlet(outletNo);

        String jsonString = JSON.toJSONString(vehicles);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectVehicleByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Vehicle> pageBean = vehicleService.selectVehicleByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectVehicleByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Vehicle vehicle = JSON.parseObject(params, Vehicle.class);

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Vehicle> pageBean = vehicleService.selectVehicleByPageAndCondition(currentPage, pageSize, vehicle);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}

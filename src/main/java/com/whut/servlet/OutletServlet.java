package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.Outlet;
import com.whut.pojo.OutletLocation;
import com.whut.pojo.PageBean;
import com.whut.service.OutletService;
import com.whut.service.impl.OutletServiceImpl;
import org.apache.ibatis.javassist.expr.NewArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/outlet/*")
public class OutletServlet extends BaseServlet {
    private OutletService outletService = new OutletServiceImpl();

    public void addOutlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Outlet outlet = JSON.parseObject(params, Outlet.class);

        if(outletService.addOutlet(outlet) == true){
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void deleteOutletByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        if(outletService.deleteOutletByIds(ids) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void updateOutlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Outlet outlet = JSON.parseObject(params, Outlet.class);

        if(outletService.updateOutlet(outlet) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void selectAllOutlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Outlet> outlets = outletService.selectAllOutlet();

        String jsonString = JSON.toJSONString(outlets);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletStreet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Map<String,String>> outletStreets = outletService.selectOutletStreet();

        String jsonString = JSON.toJSONString(outletStreets);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Map<String,String>> outletCitys = outletService.selectOutletCity();

        String jsonString = JSON.toJSONString(outletCitys);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Map<String,String>> outletStates = outletService.selectOutletState();

        String jsonString = JSON.toJSONString(outletStates);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        OutletLocation outletLocation = JSON.parseObject(params, OutletLocation.class);

        String outletStreet = outletLocation.getOutletStreet();
        String outletCity = outletLocation.getOutletCity();
        String outletState = outletLocation.getOutletState();

        System.out.println(outletStreet+" "+outletCity+" "+outletState);

        List<Outlet> outlets = outletService.selectOutletByCondition(outletStreet, outletCity, outletState);

        String jsonString = JSON.toJSONString(outlets);
        System.out.println(jsonString);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Outlet> pageBean = outletService.selectOutletByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectOutletByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Outlet outlet = JSON.parseObject(params, Outlet.class);

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Outlet> pageBean = outletService.selectOutletByPageAndCondition(currentPage, pageSize, outlet);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}

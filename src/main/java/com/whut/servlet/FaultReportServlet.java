package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.FaultReport;
import com.whut.pojo.PageBean;
import com.whut.service.FaultReportService;
import com.whut.service.impl.FaultReportServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/faultReport/*")
public class FaultReportServlet extends BaseServlet {
    private FaultReportService faultReportService = new FaultReportServiceImpl();

    public void addFaultReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        FaultReport faultReport = JSON.parseObject(params, FaultReport.class);

        if(faultReportService.addFaultReport(faultReport) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void deleteFaultReportByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        String[] ids = JSON.parseObject(params, String[].class);

        if(faultReportService.deleteFaultReportByIds(ids)) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void updateFaultReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        FaultReport faultReport = JSON.parseObject(params, FaultReport.class);

        if(faultReportService.updateFaultReport(faultReport) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void selectAllFaultReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<FaultReport> faultReports = faultReportService.selectAllFaultReport();

        String jsonString = JSON.toJSONString(faultReports);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectFaultReportByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<FaultReport> pageBean = faultReportService.selectFaultReportByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectFaultReportByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        FaultReport faultReport = JSON.parseObject(params, FaultReport.class);

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<FaultReport> pageBean = faultReportService.selectFaultReportByPageAndCondition(currentPage, pageSize, faultReport);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}

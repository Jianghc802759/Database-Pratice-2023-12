package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.PageBean;
import com.whut.pojo.RentalAgreement;
import com.whut.service.RentalAgreementService;
import com.whut.service.impl.RentalAgreementServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/rentalAgreement/*")
public class RentalAgreementServlet extends BaseServlet {
    private RentalAgreementService rentalAgreementService = new RentalAgreementServiceImpl();

    public void addRentalAgreement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        RentalAgreement rentalAgreement = JSON.parseObject(params, RentalAgreement.class);

        if(rentalAgreementService.addRentalAgreement(rentalAgreement) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void deleteRentalAgreementByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        if(rentalAgreementService.deleteRentalAgreementByIds(ids) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void updateRentalAgreement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        RentalAgreement rentalAgreement = JSON.parseObject(params, RentalAgreement.class);

        if(rentalAgreementService.updateRentalAgreement(rentalAgreement) == true) {
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void selectAllRentalAgreement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<RentalAgreement> rentalAgreements = rentalAgreementService.selectAllRentalAgreement();

        String jsonString = JSON.toJSONString(rentalAgreements);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectRentalAgreementByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<RentalAgreement> pageBean = rentalAgreementService.selectRentalAgreementByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectRentalAgreementByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        RentalAgreement rentalAgreement = JSON.parseObject(params, RentalAgreement.class);

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<RentalAgreement> pageBean = rentalAgreementService.selectRentalAgreementByPageAndCondition(currentPage, pageSize, rentalAgreement);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}

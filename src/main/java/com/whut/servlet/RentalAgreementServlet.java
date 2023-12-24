package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.PageBean;
import com.whut.pojo.RentalAgreement;
import com.whut.service.RentalAgreementService;
import com.whut.service.VehicleService;
import com.whut.service.impl.RentalAgreementServiceImpl;
import com.whut.service.impl.VehicleServiceImpl;
import com.whut.util.GeneratePolicyID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/rentalAgreement/*")
public class RentalAgreementServlet extends BaseServlet {
    private RentalAgreementService rentalAgreementService = new RentalAgreementServiceImpl();
    private VehicleService vehicleService = new VehicleServiceImpl();
    private GeneratePolicyID generatePolicyID = new GeneratePolicyID();

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

        System.out.println(params);
        int[] ids = JSON.parseObject(params, int[].class);
        System.out.println(ids);

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

    /**
     * 获取租赁协议部分信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectLeaseInfoToClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String line = br.readLine();

        Map<String, String> vehicleInfo = JSON.parseObject(line, Map.class);

        RentalAgreement rentalAgreement = new RentalAgreement();
        String vehLicenseNo = vehicleInfo.get("vehLicenseNo");
        rentalAgreement.setVehLicenseNo(vehLicenseNo);

        Integer mileageBefore = vehicleService.selectVehicleMile(vehLicenseNo);
        rentalAgreement.setMileageBefore(mileageBefore);

        HttpSession session = request.getSession();
        String clientNo = (String) session.getAttribute("clientNo");
        rentalAgreement.setClientNo(clientNo);

        while(true){
            String policyNo = generatePolicyID.getPolicyID();
            if(rentalAgreementService.selectPolicyNoCount(policyNo) == 0){
                rentalAgreement.setPolicyNo(policyNo);
                break;
            }
        }
        System.out.println(rentalAgreement);
        String jsonString = JSON.toJSONString(rentalAgreement);
        System.out.println(jsonString);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectRentalAgreementByOutlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Map<String, String>> counts = rentalAgreementService.selectRentalAgreementByOutlet();

        String jsonString = JSON.toJSONString(counts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
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

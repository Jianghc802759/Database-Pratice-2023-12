package com.whut.servlet;

import com.alibaba.fastjson.JSON;
import com.whut.pojo.Client;
import com.whut.pojo.PageBean;
import com.whut.service.ClientService;
import com.whut.service.impl.ClientServiceImpl;
import com.whut.util.GenerateUserId;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/client/*")
public class ClientServlet extends BaseServlet {
    private ClientService clientService = new ClientServiceImpl();

    public void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Client client = JSON.parseObject(params, Client.class);

        if(clientService.addClient(client) == true){
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void deleteClientByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        String[] ids = JSON.parseObject(params, String[].class);

//        System.out.println("deleteclient begin");
//        System.out.println(params);
//        System.out.println(ids);
//        System.out.println("deleteclient end");

        if(clientService.deleteClientByIds(ids) == true){
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Client client = JSON.parseObject(params, Client.class);
        System.out.println("update begin");
        System.out.println(client);
        System.out.println("update end");

        if(clientService.updateClient(client) == true){
            response.getWriter().write("{\"success\": true}");
        } else{
            response.getWriter().write("{\"success\": false}");
        }
    }

    public void selectClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String clientNo = (String) session.getAttribute("clientNo");

        Client client = clientService.selectClient(clientNo);

        String jsonString = JSON.toJSONString(client);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectAllClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Client> clients = clientService.selectAllClient();

        String jsonString = JSON.toJSONString(clients);

        response.setContentType("text/json;charset=utf-8");
        System.out.println(jsonString);
        response.getWriter().write(jsonString);
    }

    public void selectClientByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Client> pageBean = clientService.selectClientByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectClientByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        BufferedReader br = request.getReader();
        String params = br.readLine();

        Client client = JSON.parseObject(params, Client.class);

        PageBean<Client> pageBean = clientService.selectClientByPageAndCondition(currentPage, pageSize, client);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}

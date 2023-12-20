package com.whut.service;

import com.whut.pojo.Client;
import com.whut.pojo.PageBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ClientService {
    /**
     * 增加客户
     * @param client
     */
    boolean addClient(Client client);

    /**
     * 删除客户
     * @param ids
     */
    boolean deleteClientByIds(String[] ids);

    /**
     * 修改客户信息
     * @param client
     */
    boolean updateClient(Client client);

    /**
     * 客户查询个人信息
     * @param clientNo
     * @return
     */
    Client selectClient(String clientNo);

    /**
     * 查询所有客户
     * @return
     */
    List<Client> selectAllClient();

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Client> selectClientByPage(int currentPage, int pageSize);

    /**
     * 条件分页查询客户
     * @param currentPage
     * @param pageSize
     * @param client
     * @return
     */
    PageBean<Client> selectClientByPageAndCondition(int currentPage, int pageSize, Client client);
}

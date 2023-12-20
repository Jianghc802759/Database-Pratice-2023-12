package com.whut.service.impl;

import com.whut.mapper.ClientMapper;
import com.whut.mapper.UserIDMapper;
import com.whut.pojo.Client;
import com.whut.pojo.PageBean;
import com.whut.service.ClientService;
import com.whut.util.GenerateUserId;
import com.whut.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    GenerateUserId generateUserId = new GenerateUserId();

    /**
     * 添加客户
     * @param client
     * @return
     */
    @Override
    public boolean addClient(Client client) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);
        UserIDMapper userIDMapper = sqlSession.getMapper(UserIDMapper.class);

        try {
            while (true) {
                String clientNo = "C" + generateUserId.getUserId();
                if (userIDMapper.getIDCount(clientNo) == 0) {
                    client.setClientNo(clientNo);
                    System.out.println(clientNo);
                    clientMapper.addClient(client);
                    sqlSession.commit();
                    break;
                }
            }
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getSQLState().equals("23000")) {
                // 唯一性约束违反，你可以在这里处理该情况
                // e.printStackTrace();  // 这里只是打印异常信息，可以根据需要进行其他处理
                System.out.println("唯一性约束违反");
                return false;  // 插入失败，唯一性约束违反
            }
        } catch (SQLException e) {
            System.out.println("其他sql报错");
            // e.printStackTrace();  // 其他 SQL 异常，你可以根据实际情况处理
            return false;  // 插入失败
        } finally {
            sqlSession.close();
        }

        return false;
    }


    /**
     * 批量删除客户
     * @param ids
     * @return
     */
    @Override
    public boolean deleteClientByIds(String[] ids) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        try {
            clientMapper.deleteClientByIds(ids);
            sqlSession.commit();
            return true;
        } catch (SQLIntegrityConstraintViolationException e){
            return false;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 更新客户信息
     * @param client
     * @return
     */
    @Override
    public boolean updateClient(Client client) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        try {
            clientMapper.updateClient(client);
            sqlSession.commit();
            return true;  // 更新成功
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getSQLState().equals("23000")) {
                // 唯一性约束违反，你可以在这里处理该情况
                e.printStackTrace();  // 这里只是打印异常信息，可以根据需要进行其他处理
                return false;  // 更新失败，唯一性约束违反
            }
        } catch (SQLException e) {
            e.printStackTrace();  // 其他 SQL 异常，你可以根据实际情况处理
            return false;
        } finally {
            sqlSession.close();
        }

        return false;  // 更新失败
    }


    /**
     * 客户查询个人信息
     * @param clientNo
     * @return
     */
    @Override
    public Client selectClient(String clientNo) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        Client client = clientMapper.selectClient(clientNo);

        sqlSession.close();

        return client;
    }

    /**
     * 展示所有客户信息
     * @return
     */
    @Override
    public List<Client> selectAllClient() {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        List<Client> clients = clientMapper.selectAllClient();

        sqlSession.close();

        return clients;
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Client> selectClientByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Client> rows = clientMapper.selectClientByPage(begin, size);

        int totalCount = clientMapper.selectClientCount();

        PageBean<Client> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();

        return pageBean;
    }

    /**
     * 条件分页查询
     * @param currentPage
     * @param pageSize
     * @param client
     * @return
     */
    @Override
    public PageBean<Client> selectClientByPageAndCondition(int currentPage, int pageSize, Client client) {
        SqlSession sqlSession = factory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        String clientName = client.getClientName();
        if(clientName != null && clientName.length() > 0){
            client.setClientName("%" + clientName + "%");
        }
        String clientStreet = client.getClientStreet();
        if(clientStreet != null && clientStreet.length() > 0){
            client.setClientStreet("%" + clientStreet + "%");
        }
        String clientCity = client.getClientCity();
        if(clientCity != null && clientCity.length() > 0){
            client.setClientCity("%" + clientCity + "%");
        }
        String clientState = client.getClientState();
        if(clientState != null && clientState.length() > 0){
            client.setClientState("%" + clientState + "%");
        }

        List<Client> rows = clientMapper.selectClientByPageAndCondition(begin, size, client);

        //6. 查询总记录数
        int totalCount = clientMapper.selectClientCountByCondition(client);

        //7. 封装PageBean对象
        PageBean<Client> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

}

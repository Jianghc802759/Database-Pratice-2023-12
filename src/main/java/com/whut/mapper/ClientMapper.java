package com.whut.mapper;

import com.whut.pojo.Client;
import com.whut.pojo.PageBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ClientMapper {
    /**
     * 添加客户
     * @param client
     */
    void addClient(Client client) throws SQLException;

    /**
     * 根据客户编码删除客户
     * @param ids
     */
    void deleteClientByIds(@Param("ids") String[] ids) throws SQLException;

    /**
     * 修改客户信息
     * @param client
     */
    void updateClient(Client client) throws SQLException;

    /**
     * 查询客户基本信息
     * @param clientNo
     * @return
     */
    @Select("select * from Client where clientNo = #{clientNo}")
    Client selectClient(String clientNo);

    /**
     * 查询客户的电话号码，作为密码
     * @param clientNo
     * @return
     */
    @Select("select clientTelNo from Client where clientNo = #{clientNo}")
    String selectClientTelNo(String clientNo);

    /**
     * 查询所有客户
     * @return
     */
    @Select("select * from Client")
    List<Client> selectAllClient();

    /**
     * 客户总数
     * @return
     */
    @Select("select count(*) from Client")
    int selectClientCount();

    /**
     * 分页查询客户
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from Client limit #{begin}, #{size}")
    List<Client> selectClientByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 条件分页查询客户
     * @param begin
     * @param size
     * @param client
     * @return
     */
    List<Client> selectClientByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("client") Client client);

    /**
     * 条件查询的返回结果数
     * @param client
     * @return
     */
    int selectClientCountByCondition(Client client);

    /**
     * 查询客户街道
     * @return
     */
    @Select("select * from ClientStreetView")
    List<Map<String,String>> selectClientStreet();

    /**
     * 查询客户城市
     * @return
     */
    @Select("select * from ClientCityView")
    List<Map<String,String>> selectClientCity();

    /**
     * 查询客户州
     * @return
     */
    @Select("select * from ClientStateView")
    List<Map<String,String>> selectClientState();
}

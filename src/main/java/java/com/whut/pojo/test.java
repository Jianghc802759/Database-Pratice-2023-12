package com.whut.pojo;

import com.alibaba.fastjson.JSON;

public class test {
    public static void main(String[] args) {
        Client client = new Client ("1","1","1","1","1","1","1","1","1","1","1","1","1");
        String jsonString = JSON.toJSONString(client);
        System.out.println(jsonString);

        Client client1 = JSON.parseObject(jsonString, Client.class);
        System.out.println(client1);
    }
}

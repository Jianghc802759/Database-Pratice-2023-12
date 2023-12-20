package com.whut.util;

import java.util.Random;

public class GenerateUserId {
    public String getUserId(){
        Random random = new Random();
        // 生成一个10位整数，包含前导零
        String randomString = String.format("%010d", random.nextLong(10000000000L));
        return randomString;
    }
}

package com.whut.util;

import java.util.Random;

public class GeneratePolicyID {
    public String getPolicyID(){
        // 生成四个字母
        String letters = generateRandomLetters(4);

        // 生成十六个数字
        String numbers = generateRandomNumbers(16);

        // 组合字母和数字
        return letters + numbers;
    }

    private static String generateRandomLetters(int count) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            char randomLetter = (char) ('A' + random.nextInt(26));
            sb.append(randomLetter);
        }

        return sb.toString();
    }

    private static String generateRandomNumbers(int count) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }

        return sb.toString();
    }
}

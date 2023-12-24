package com.whut.util;

import java.util.Random;

public class GenerateVehicleID {
    public String getVehicleID(){
        // 生成三个字母
        String letters = generateRandomLetters(3);

        // 生成三个数字
        String numbers = generateRandomNumbers(3);

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

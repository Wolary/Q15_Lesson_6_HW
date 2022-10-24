package quru.qa.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < lenght) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static String getRandomStringAbc(int lenght) {
    return RandomStringUtils.randomAlphabetic(lenght);
    }


        public static String getRandomEmail() {
        return getRandomString(5) + "@ya.ru";
    }


    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    public static String getRandomPhone() {
        return "+0000" + getRandomLong(1111111111L, 9999999999L).toString();
    }


// можно и так:
//    public static String getRandomPhone(int lenght) {
//        String SALTCHARS = "1234567890";
//        StringBuilder result = new StringBuilder();
//        Random rnd = new Random();
//        while (result.length() < lenght) {
//            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
//            result.append(SALTCHARS.charAt(index));
//        }
//        return result.toString();
//    }
}

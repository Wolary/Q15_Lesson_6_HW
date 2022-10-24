package quru.qa.utils;

import java.util.Random;

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

    public static String getRandomPhone(int lenght) {
        String SALTCHARS = "1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < lenght) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
}

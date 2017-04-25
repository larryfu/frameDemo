package cn.larry.demo.Utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author gzfu
 */
public class RandomUtils {

    private RandomUtils() {
    }

    private static final Random random = ThreadLocalRandom.current();
    public static final String BASE_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";
    public static final String STRING_BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int nextInt(int max) {
        return random.nextInt(max);
    }

    public static String getString(int length) { //length
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++)
            sb.append(STRING_BASE.charAt(random.nextInt(STRING_BASE.length())));
        return sb.toString();
    }

}
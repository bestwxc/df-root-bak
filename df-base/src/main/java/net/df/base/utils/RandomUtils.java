package net.df.base.utils;

import java.util.Random;


/**
 * 随机数生成工具类
 */
public class RandomUtils {
    private static final String NUMBERCHAR = "0123456789";
    private static final String LETTERCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getNumCode(int length){
        return getCode(NUMBERCHAR,length);
    }

    public static String getStringCode(int length){
        return getCode(LETTERCHAR,length);
    }

    private static String getCode(String from,int length){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < length; i++){
            sb.append(from.charAt(random.nextInt(from.length())));
        }
        return sb.toString();
    }
}

package net.df.base.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 价格工具类
 */
public class PriceUtils {
    public static String PATTERN1 = "0.0";
    public static String PATTERN2 = "0.00";
    public static String PATTERN3 = "0.000";
    public static String PATTERN4 = "0.0000";

    public static String format(BigDecimal price){
        return format(price,PATTERN2);
    }

    public static String format(BigDecimal price,String pattren){
        DecimalFormat df = new DecimalFormat(pattren);
        return df.format(price);
    }
}

package net.df.base.utils;

import net.df.base.exception.ParamIllegalException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Map工具类
 */
public class MapUtils {

    public static Object getObjectFromMapNotNull(Map<String,?> map,String fieldName){
        Object object = map.get(fieldName);
        if(ValidateUtils.isNull(object)){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]为null");
        }
        return object;
    }

    public static String getStringFromMapNotNull(Map<String,?> map,String fieldName){
        Object object = getObjectFromMapNotNull(map,fieldName);
        String value = String.valueOf(object);
        if(ValidateUtils.isEmptyString(value)){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]为空");
        }
        return value;
    }

    public static String getStringFromMap(Map<String,?> map,String fieldName,String defaultValue){
        try {
            return getStringFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static Integer getIntegerFromMapNotNull(Map<String,?> map,String fieldName){
        Object object = getObjectFromMapNotNull(map,fieldName);
        try {
            return Integer.valueOf(String.valueOf(object));
        }catch (RuntimeException e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为Integer");
        }
    }
    public static Integer getIntegerFromMap(Map<String,?> map,String fieldName,Integer defaultValue){
        try {
            return getIntegerFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static Long getLongFromMapNotNull(Map<String,?> map,String fieldName){
        Object object = getObjectFromMapNotNull(map,fieldName);
        try {
            return Long.valueOf(String.valueOf(object));
        }catch (RuntimeException e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为Long");
        }
    }

    public static Long getLongFromMap(Map<String,?> map,String fieldName,Long defaultValue){
        try {
            return getLongFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static BigDecimal getBigDecimalFromMapNotNull(Map<String,?> map,String fieldName){
        String object = getStringFromMapNotNull(map,fieldName);
        try {
            return new BigDecimal(object);
        }catch (RuntimeException e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为BigDecimal");
        }
    }


    public static BigDecimal getBigDecimalFromMap(Map<String,?> map,String fieldName,BigDecimal defaultValue){
        try {
            return getBigDecimalFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static Date getDateFromMapNotNull(Map<String,?> map,String fieldName,String pattern){
        String object = getStringFromMapNotNull(map,fieldName);
        try{
            return DateUtils.parse(object,pattern);
        }catch (Exception e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为Date");
        }
    }

    public static Date getDateFromMap(Map<String,?> map,String fieldName,String pattern,Date defaultValue){
        try {
            return getDateFromMapNotNull(map, fieldName,pattern);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static List getListFromMapNotNull(Map<String,?> map, String fieldName){
        try{
            return (List) map.get(fieldName);
        }catch (Exception e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为List");
        }
    }


    public static List getListFromMap(Map<String,?> map, String fieldName,List defaultValue){
        try {
            return getListFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }

    public static Map getMapFromMapNotNull(Map<String,?> map, String fieldName){
        try{
            return (Map) map.get(fieldName);
        }catch (Exception e){
            throw new ParamIllegalException("从map中获取[" + fieldName + "]错误，属性不能转换为Map");
        }
    }

    public static Map getMapFromMap(Map<String,?> map, String fieldName,Map defaultValue){
        try {
            return getMapFromMapNotNull(map, fieldName);
        }catch (ParamIllegalException e){
            return defaultValue;
        }
    }
}

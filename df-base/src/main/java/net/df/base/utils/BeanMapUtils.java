package net.df.base.utils;

import net.df.base.exception.BaseException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean、Map互转工具类
 */
public class BeanMapUtils {
    public static Map<String,?> toMap(Object bean){
        Field[] fields = bean.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            for(int i = 0; i < fields.length; i++){
                fields[i].setAccessible(true);
                map.put(fields[i].getName().toString(),fields[i].get(bean));
            }
        }catch (IllegalAccessException e){
            throw new BaseException("Bean转换为Map异常",e);
        }
        return map;
    }

    public static <T> T toBean(Class<T> clazz,Map<String,?> map){
        try {
            T t = clazz.newInstance();
            for (String key : map.keySet()) {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                field.set(t, map.get(key));
            }
            return t;
        }catch (Exception e){
            throw new BaseException("map转换成Bean异常",e);
        }
    }
}

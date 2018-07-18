package net.df.base.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.df.base.constants.BaseConstants;
import net.df.base.exception.BaseException;

/**
 * Json工具类
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将Json转化为字符串
     * @param object
     * @param ignoreError
     * @return
     */
    public static String writeObjectAsString(Object object,boolean ignoreError){
        if(object == null){
            return BaseConstants.EMPTY_STRING;
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            if(!ignoreError){
                throw new BaseException("将对象转换为Json出错",e);
            }
        }
        return BaseConstants.EMPTY_STRING;
    }

    /**
     * 将对象转化为字符串
     * @param object
     * @return
     */
    public static String writeObjectAsString(Object object){
        return writeObjectAsString(object,true);
    }

    /**
     * 将Json 字符串转化为对象
     * @param json
     * @return
     */
    public static Object getObjectFromString(String json) {
        return getObjectFromString(json,Object.class);
    }

    /**
     * 将Json转化为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromString(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        }catch (Exception e){
            throw new BaseException("将Json转换为对象出错",e);
        }
    }
}

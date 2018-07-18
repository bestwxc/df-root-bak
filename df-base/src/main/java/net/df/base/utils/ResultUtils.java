package net.df.base.utils;

import net.df.base.server.Result;

/**
 * 构造返回结果的工具类
 */
public class ResultUtils {
    public static Result success(Object resultObject){
        Result result = new Result();
        if(resultObject != null){
            result.setResult(resultObject);
        }
        return result;
    }

    public static Result error(int errorNo, String errorInfo){
        Result result = new Result();
        result.setErrorNo(errorNo);
        result.setErrorInfo(errorInfo);
        return result;
    }
}

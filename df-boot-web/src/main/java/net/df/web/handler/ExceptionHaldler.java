package net.df.web.handler;


import com.github.pagehelper.PageHelper;
import net.df.base.constants.ErrorNo;
import net.df.base.exception.BaseException;
import net.df.base.exception.BusinessException;
import net.df.base.server.Result;
import net.df.base.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringBoot 统一异常捕获
 */
@ControllerAdvice
public class ExceptionHaldler {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public Result handle(Throwable t){
        Integer errorNo = null;
        String errorInfo = null;
        try{
            //移除PageHelper的ThreadLocal变量
            PageHelper.clearPage();
        }catch (Exception e){
            logger.error("移除PageHelper的ThreadLocal变量抛出异常", t);
            t.addSuppressed(e);
        }
        if(t instanceof BusinessException){
            //已经编码归类的业务异常
            BusinessException be = (BusinessException) t;
            errorNo = be.getErrorNo();
            errorInfo = be.getMessage();
            logger.info("业务异常，errorNo:{},errorInfo:{}",errorNo,errorInfo,t);
        }else if(t instanceof HttpMessageNotReadableException){
            //请求格式异常
            errorNo = ErrorNo.REQUEST_ERROR;
            errorInfo = "请求接口格式不正确";
            logger.warn("errorNo:{},errorInfo:{}",errorNo,errorInfo,t);
        }else if(t instanceof BaseException){
            //捕获过，但未归类处理异常
            errorNo = ErrorNo.SYSTEM_ERROR;
            errorInfo = t.getMessage();
            logger.error("errorNo:{},errorInfo:{}",errorNo,errorInfo,t);
        }else{
            //未有效捕获异常
            errorNo = ErrorNo.SYSTEM_ERROR;
            errorInfo = "系统异常:" + t.getMessage();
            logger.error("errorNo:{},errorInfo:{}",errorNo,errorInfo,t);
        }
        return ResultUtils.error(errorNo,errorInfo);
    }
}

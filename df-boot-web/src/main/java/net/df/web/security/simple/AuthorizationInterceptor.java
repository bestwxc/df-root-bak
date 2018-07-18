package net.df.web.security.simple;


import net.df.base.constants.ErrorNo;
import net.df.base.server.Result;
import net.df.base.utils.ResultUtils;
import net.df.web.constants.SessionKey;
import net.df.web.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 权限校验拦截器
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(Authorization.class) != null){
            HttpSession httpSession = request.getSession();
            if(httpSession != null){
                Object user = httpSession.getAttribute(SessionKey.SESSION_USER_KEY);
                if(user != null){
                    return true;
                }
            }
            Result result = ResultUtils.error(ErrorNo.UNLOGIN,"unlogin");
            ResponseUtils.returnJsonResult(response,result);
            return false;
        }else {
            return true;
        }
    }
}

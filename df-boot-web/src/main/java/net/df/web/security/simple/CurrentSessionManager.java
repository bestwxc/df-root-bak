package net.df.web.security.simple;

import net.df.web.constants.SessionKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 当前Session管理
 */
public class CurrentSessionManager {

    /**
     * 设置当前用户
     * @param request
     * @param user
     */
    public static void setUser(HttpServletRequest request,Object user){
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(SessionKey.SESSION_USER_KEY,user);
    }

    /**
     * 获取当前用户
     * @param request
     * @return
     */
    public static Object getUser(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        if(httpSession == null){
            return null;
        }else {
            return httpSession.getAttribute(SessionKey.SESSION_USER_KEY);
        }
    }
}

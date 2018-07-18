package net.df.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Web框架配置量，统一管理
 */
@ConfigurationProperties(prefix = "df.web")
public class WebProperties {

    /**
     * 是否打开跨域设置
     */
    private boolean openCors;

    /**
     * redis序列化方式
     */
    private String redisSerializer;

    /**
     * 权限校验方式
     */
    private String securityType;

    public void setOpenCors(boolean openCors) {
        this.openCors = openCors;
    }
    public boolean isOpenCors() {
        return openCors;
    }

    public void setRedisSerializer(String redisSerializer) {
        this.redisSerializer = redisSerializer;
    }
    public String getRedisSerializer() {
        return redisSerializer;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }
    public String getSecurityType() {
        return securityType;
    }
}

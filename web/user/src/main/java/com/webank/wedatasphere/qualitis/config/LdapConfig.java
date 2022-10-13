package com.webank.wedatasphere.qualitis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author allenzhou@webank.com
 * @date 2021/8/27 10:50
 */
@Configuration
public class LdapConfig {
    @Value("${ldap.ip}")
    private String ip;
    @Value("${ldap.port}")
    private int port;
    @Value("${ldap.userNameFormat}")
    private String userNameFormat;

    public LdapConfig() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public String getUserNameFormat() {
        return userNameFormat;
    }

    public void setUserNameFormat(String userNameFormat) {
        this.userNameFormat = userNameFormat;
    }

}

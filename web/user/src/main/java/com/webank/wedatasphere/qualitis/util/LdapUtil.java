package com.webank.wedatasphere.qualitis.util;

import com.webank.wedatasphere.qualitis.config.LdapConfig;
import org.apache.commons.lang3.StringUtils;
import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.opendj.ldap.requests.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author allenzhou@webank.com
 * @date 2021/8/27 10:30
 */
@Component
public class LdapUtil {
    @Autowired
    private LdapConfig ldapConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(LdapUtil.class);

    public boolean loginByLdap(String userName, String password) {
        LDAPConnectionFactory ldf = new LDAPConnectionFactory(ldapConfig.getIp(), ldapConfig.getPort());
        Connection conn;
        try {
            conn = ldf.getConnection();
        } catch (LdapException e) {
            LOGGER.info("connecting failed. please check ip :" + ldapConfig.getIp() + " port: " + ldapConfig.getPort());
            return false;
        }

        String userNameFormat = ldapConfig.getUserNameFormat();
        String bindDN = userName;
        if (!StringUtils.isBlank(userNameFormat)) {
            bindDN = String.format(userNameFormat, userName);
        }

        BindRequest request = Requests.newSimpleBindRequest(bindDN , password.getBytes());
        try {
            conn.bind(request);
            LOGGER.info("Login by ladp success! User: {}", bindDN);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        } finally {
            conn.close();
        }

        return true;
    }
}

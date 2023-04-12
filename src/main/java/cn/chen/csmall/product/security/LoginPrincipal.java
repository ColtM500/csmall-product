package cn.chen.csmall.product.security;

import lombok.Data;

import java.io.Serializable;

/**
 * 认证信息中的当事人数据
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Data
public class LoginPrincipal implements Serializable {

    /**
     * 当事人ID
     */
    private Long id;
    /**
     * 当事人用户名
     */
    private String username;

}

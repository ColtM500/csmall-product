package cn.chen.csmall.product.web;

/**
 * 业务状态码枚举类型
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
public enum ServiceCode {

    /**
     * 成功
     */
    OK(20000),
    /**
     * 错误：请求参数格式有误
     */
    ERR_BAD_REQUEST(40000),
    /**
     * 错误：数据不存在
     */
    ERR_NOT_FOUND(40400),
    /**
     * 错误：数据冲突
     */
    ERR_CONFLICT(40900),
    /**
     * 错误：未知错误
     */
    ERR_UNKNOWN(99999);

    private Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
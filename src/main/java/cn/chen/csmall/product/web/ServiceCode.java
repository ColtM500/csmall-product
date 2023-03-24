package cn.chen.csmall.product.web;

/**
 * 枚举
 */
public enum ServiceCode {

    OK(20000),
    ERR_BAD_REQUEST(40000),
    ERR_NOT_FOUND(40400),
    ERR_UNKNOWN(99999),
    ERR_CONFLICT(40900);

    private Integer value;

    ServiceCode(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}

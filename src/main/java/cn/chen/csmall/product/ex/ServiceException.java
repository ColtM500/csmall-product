package cn.chen.csmall.product.ex;

import lombok.Getter;

public class ServiceException extends RuntimeException{

    /**
     * 状态码
     * @param message
     */
    @Getter
    private Integer state;

    public ServiceException(Integer state, String message){
        super(message);
        this.state = state;
    }
}

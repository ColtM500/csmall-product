package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handleServiceException(ServiceException e) {
        return e.getMessage();
    }

    @ExceptionHandler
    public String handleBindException(BindException e) {
        String message = e.getFieldError().getDefaultMessage();
        return message;
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        return "程序运行过程中出现了Throwable";
    }

}

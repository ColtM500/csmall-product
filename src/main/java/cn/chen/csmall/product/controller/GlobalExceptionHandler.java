package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
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
    public String handleNullPointerException(NullPointerException e) {
        return "程序运行过程中出现了NullPointerException";
    }

    @ExceptionHandler
    public String handleRuntimeException(RuntimeException e) {
        return "程序运行过程中出现了RuntimeException";
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        return "程序运行过程中出现了Throwable";
    }


}

package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

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
//        // 使用以下方式时，如果有多个检查错误，
//        // 将获取其中某1个检查注解中配置的message值，但无法确定到底是哪一个
//        String message = e.getFieldError().getDefaultMessage();
//        return message;

        StringJoiner stringJoiner = new StringJoiner(",", "请求参数错误的是: ", "! ");
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors){
            stringJoiner.add(fieldError.getDefaultMessage());
        }
        return stringJoiner.toString();
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        return "程序运行过程中出现了Throwable";
    }

}

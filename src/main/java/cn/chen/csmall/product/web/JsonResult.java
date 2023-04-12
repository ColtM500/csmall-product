package cn.chen.csmall.product.web;

import cn.chen.csmall.product.ex.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor //无参的构造方法
@AllArgsConstructor   //全参的构造方法
@Accessors(chain = true) //支持链式写法
public class JsonResult<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer state;
    /**
     * 操作“失败”时的描述文本
     */
    private String message;
    /**
     * 操作“成功”时响应的数据
     */
    private T data; // E > Element / K > Key / V > Value / T > Type

    public static JsonResult<Void> ok() {
        // JsonResult jsonResult = new JsonResult();
        // jsonResult.setState(ServiceCode.OK.getValue());
        // return jsonResult;
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setState(ServiceCode.OK.getValue());
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult<Void> fail(ServiceException e) {
        // JsonResult jsonResult = new JsonResult();
        // jsonResult.setState(e.getState());
        // jsonResult.setMessage(e.getMessage());
        // return jsonResult;
        return fail(e.getServiceCode(), e.getMessage());
    }

    public static JsonResult<Void> fail(ServiceCode serviceCode, String message) {
        JsonResult<Void> jsonResult = new JsonResult<>();
        jsonResult.setState(serviceCode.getValue());
        jsonResult.setMessage(message);
        return jsonResult;
    }



}

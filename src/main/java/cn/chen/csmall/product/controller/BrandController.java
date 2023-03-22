package cn.chen.csmall.product.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
@Api(tags = "02.品牌管理模块")
public class BrandController {

    @RequestMapping("delete")
    public void delete(Long id){
        // 由adminService调用删除方法，Service中的方法仍可能抛出异常
        throw new ClassCastException();
    }

    @RequestMapping("update")
    public void update(){
        // 由adminService调用修改方法，Service中的方法仍可能抛出异常
        throw new NullPointerException();
    }
}

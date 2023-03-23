package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@Api(tags = "02. 品牌管理模块")
public class BrandController {

//    @RequestMapping("/delete")
//    public void delete(Long id) {
//        // 由adminService调用删除方法，Service中的方法仍可能抛出异常
//        throw new ServiceException("测试删除品牌时，假设抛出的异常");
//    }
//
//    @RequestMapping("/update")
//    public void update() {
//        // 由adminService调用修改方法，Service中的方法仍可能抛出异常
//        throw new ServiceException("测试修改品牌时，假设抛出的异常");
//    }

}

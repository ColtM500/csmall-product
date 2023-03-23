package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.service.IBrandService;
import cn.chen.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
@Api(tags = "02. 品牌管理模块")
@Validated
public class BrandController {
    @Autowired
    private IBrandService brandService;

    // http://localhost:6080/albums/add-new?name=TestName001&description=TestDescription001&sort=199
    @PostMapping("add-new")
    @ApiOperation("添加品牌模板")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Validated BrandAddNewDTO brandAddNewDTO){
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }


}

package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.service.IAlbumService;
import cn.chen.csmall.product.service.IAttributeTemplateService;
import cn.chen.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/attributeTemplate/")
@Api(tags = "03.属性模板管理模板")
@Validated
public class AttributeTemplateController {

    @Autowired
    private IAttributeTemplateService attributeTemplateService;

    // http://localhost:6080/attributeTemplate/add-new?name=TestName001&description=TestDescription001&sort=199
    @PostMapping("add-new")
    @ApiOperation("添加属性模板")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Valid AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        attributeTemplateService.addNew(attributeTemplateAddNewDTO);
        return JsonResult.ok();
    }
}

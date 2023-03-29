package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AlbumUpdateNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.service.IAlbumService;
import cn.chen.csmall.product.service.IAttributeTemplateService;
import cn.chen.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    // http://localhost:6080/attributeTemplate/9825/delete
    @GetMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根据ID删除属性模板")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "相册ID", required = true, dataType = "long")
    })
    public JsonResult delete(@Range(min = 1, message = "删除相册失败，ID值无效！")
                             @PathVariable Long id) {
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/attributeTemplate
    @GetMapping("")
    @ApiOperation("查询属性模板列表")
    @ApiOperationSupport(order = 420)
    public JsonResult list(){
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }

    // http://locaohost:6080/attributeTemplate/9999
    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据ID查询属性模板详情")
    @ApiOperationSupport(order = 410)
    public JsonResult getStandardById(@Range(min = 1, message = "获取属性模板详情失败，ID值无效！")
                                      @PathVariable Long id){
        AttributeTemplateStandardVO queryResult = attributeTemplateService.getStandardById(id);
        return JsonResult.ok(queryResult);
    }

    // http://localhost:6080/attributeTemplate/9527/update
    @PostMapping("/{id:[0-9]+}/update")
    @ApiOperation("修改属性模板信息")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "属性模板ID", required = true, dataType = "long")
    })
    public JsonResult updateInfoById(@Range(min = 1, message = "修改属性模板详情失败，ID值无效！")
                                     @PathVariable Long id, @Valid AttributeTemplateUpdateNewDTO attributeTemplateUpdateNewDTO){
        attributeTemplateService.updateInfoById(id, attributeTemplateUpdateNewDTO);
        return JsonResult.ok();
    }
}

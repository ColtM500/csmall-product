package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandUpdateNewDTO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import cn.chen.csmall.product.service.IBrandService;
import cn.chen.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand/")
@Api(tags = "02. 品牌管理模块")
@Validated
@Slf4j
public class BrandController {
    @Autowired
    private IBrandService brandService;

    // http://localhost:6080/brand/add-new?name=TestName001&description=TestDescription001&sort=199
    @PostMapping("add-new")
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Validated BrandAddNewDTO brandAddNewDTO){
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:6080/brand/9825/delete
    @GetMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根据ID删除品牌")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "相册ID", required = true, dataType = "long")
    })
    public JsonResult delete(@Range(min = 1, message = "删除相册失败，ID值无效！")
                             @PathVariable Long id) {
        brandService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/brand
    @GetMapping("")
    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 420)
    public JsonResult list(){
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }

    // http://locaohost:6080/brand/9999
    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据ID查询品牌详情")
    @ApiOperationSupport(order = 410)
    public JsonResult getStandardById(@Range(min = 1, message = "获取属性模板详情失败，ID值无效！")
                                      @PathVariable Long id){
        BrandStandardVO queryResult = brandService.getStandardById(id);
        return JsonResult.ok(queryResult);
    }

    // http://localhost:6080/brand/9527/update
    @PostMapping("/{id:[0-9]+}/update")
    @ApiOperation("修改品牌信息")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "属性模板ID", required = true, dataType = "long")
    })
    public JsonResult updateInfoById(@Range(min = 1, message = "修改属性模板详情失败，ID值无效！")
                                     @PathVariable Long id, @Valid BrandUpdateNewDTO brandUpdateNewDTO){
        brandService.updateInfoById(id, brandUpdateNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:6080/brand/rebuild-cache
    @GetMapping("rebuild-cache")
    @ApiOperation("重建品牌缓存数据")
    @ApiOperationSupport(order = 500)
    public JsonResult rebuildCache(){
        log.debug("开始处理【重建品牌数据缓存】的请求，无参数");
        brandService.rebuildCache();
        return JsonResult.ok();
    }
}

package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.service.ICategoryService;
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

@Slf4j
@RestController
@RequestMapping("/categories")
@Api(tags = "04. 类别管理模块")
@Validated
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    //http://localhost:6080/categorties/add-new
    @PostMapping("/add-new")
    @ApiOperation("添加类别")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Valid CategoryAddNewDTO categoryAddNewDTO){
        log.debug("开始处理[添加类别]的请求, 参数:{}", categoryAddNewDTO);
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    //http://localhost:6080/categorties/list-by-parent?parentId=0
    @GetMapping("/list-by-parent")
    @ApiOperation("根据父级查询子类级别")
    @ApiOperationSupport(order = 200)
    public JsonResult listByParentId(Long parentId){
        List<CategoryListItemVO> list = categoryService.listByParentId(parentId);
        return JsonResult.ok(list);
    }

    //http://localhost:6080/categorties/9527/delete
    @GetMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根据ID删除类别")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult delete(@Range(min = 1, message = "删除类别失败，ID值无效！")
                             @PathVariable Long id) {
        categoryService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/categories/9527/enable
    @PostMapping("/{id:[0-9]+}/enable")
    @ApiOperation("启用类别")
    @ApiOperationSupport(order = 410)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult setEnable(@Range(min = 1, message = "启用类别失败，ID值无效！")
                                @PathVariable Long id) {
        categoryService.setEnable(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/categories/9527/disable
    @PostMapping("/{id:[0-9]+}/disable")
    @ApiOperation("禁用类别")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult setDisable(@Range(min = 1, message = "禁用类别失败，ID值无效！")
                                 @PathVariable Long id) {
        categoryService.setDisable(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/categories/9527/display
    @PostMapping("/{id:[0-9]+}/display")
    @ApiOperation("显示类别")
    @ApiOperationSupport(order = 510)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult setDisplay(@Range(min = 1, message = "启用类别失败，ID值无效！")
                                @PathVariable Long id) {
        categoryService.setDisplay(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/categories/9527/hidden
    @PostMapping("/{id:[0-9]+}/hidden")
    @ApiOperation("隐藏类别")
    @ApiOperationSupport(order = 520)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult setHidden(@Range(min = 1, message = "禁用类别失败，ID值无效！")
                                 @PathVariable Long id) {
        categoryService.setHidden(id);
        return JsonResult.ok();
    }
}

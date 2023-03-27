package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import cn.chen.csmall.product.service.IAlbumService;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/albums")
@Api(tags = "01. 相册管理模块")
@Validated
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    // http://localhost:6080/albums/add-new?name=TestName001&description=TestDescription001&sort=199
    @PostMapping("/add-new")
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Valid AlbumAddNewDTO albumAddNewDTO) {
        albumService.addNew(albumAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:6080/albums/9825/delete
    @GetMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根据ID删除相册")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "相册ID", required = true, dataType = "long")
    })
    public JsonResult delete(@Range(min = 1, message = "删除相册失败，ID值无效！")
                         @PathVariable Long id) {
        albumService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:6080/albums
    @GetMapping("")
    @ApiOperation("查询相册列表")
    @ApiOperationSupport(order = 420)
    public JsonResult list(){
        List<AlbumListItemVO> list = albumService.list();
        return JsonResult.ok(list);
    }

    // http://locaohost:6080/albums/9999
    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据ID查询相册详情")
    @ApiOperationSupport(order = 410)
    public JsonResult getStandardById(@Range(min = 1, message = "获取相册详情失败，ID值无效！")
                                      @PathVariable Long id){
        AlbumStandardVO queryResult = albumService.getStandardById(id);
        return JsonResult.ok(queryResult);
    }



}

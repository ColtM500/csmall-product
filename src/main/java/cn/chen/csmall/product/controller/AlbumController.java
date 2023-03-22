package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.IAlbumService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/album")
@Api(tags = "01. 相册管理模块")
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    // http://localhost:9080/album/add-new?name=TestName001&description=TestDescription001&sort=199
    @PostMapping("/add-new")
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    public String addNew(@Valid AlbumAddNewDTO albumAddNewDTO) {
        albumService.addNew(albumAddNewDTO);
        return "添加相册成功！";
    }

    @PostMapping("/delete")
    @ApiOperation("根据ID删除相册")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", value = "相册ID", required = true,  dataType = "long"),
        @ApiImplicitParam(name = "username", value = "用户名", required = true)
    })
    public void delete(@RequestParam Long id, @RequestParam String username) {
        // 由adminService调用删除方法，Service中的方法仍可能抛出异常
        throw new ServiceException("测试删除相册时，假设抛出的异常");
    }

    @PostMapping("/update")
    @ApiOperation("修改相册")
    @ApiOperationSupport(order = 300)
    public void update(@ApiIgnore HttpSession session) {
        // 由adminService调用修改方法，Service中的方法仍可能抛出异常
        throw new ServiceException("测试修改相册时，假设抛出的异常");
    }
}

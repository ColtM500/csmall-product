package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.IAlbumService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album/")
@Api(tags = "01.相册管理模块")
public class AlbumController {
    @Autowired
    private IAlbumService albumService;

    // http://localhost:9080/a8lbum/add-new?name=TestName001&description=TestDescription001&sort=199
    @RequestMapping("add-new")
    @ApiOperation("根据ID添加相册")
    @ApiOperationSupport(order = 100)
    public String addNew(AlbumAddNewDTO albumAddNewDTO) {
        albumService.addNew(albumAddNewDTO);
        return "添加相册成功！";
    }

    @RequestMapping("delete")
    @ApiOperation("根据ID删除相册")
    @ApiOperationSupport(order = 200)
    public void delete(Long id) {
        // 由adminService调用删除方法，Service中的方法仍可能抛出异常
        throw new ServiceException("测试删除相册时, 假设抛出异常");
    }

    @RequestMapping("update")
    @ApiOperation("修改相册")
    @ApiOperationSupport(order = 300)
    public void update() {
        // 由adminService调用修改方法，Service中的方法仍可能抛出异常
        throw new ServiceException("测试修改想测试, 假设抛出异常");
    }
}

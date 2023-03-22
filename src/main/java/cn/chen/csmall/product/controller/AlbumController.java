package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album/")
public class AlbumController {
    @Autowired
    private IAlbumService albumService;

    // http://localhost:9080/album/add-new?name=TestName001&description=TestDescription001&sort=199
    @RequestMapping("add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO) {
        albumService.addNew(albumAddNewDTO);
        return "添加相册成功！";
    }

    @RequestMapping("delete")
    public void delete(Long id) {
        // 由adminService调用删除方法，Service中的方法仍可能抛出异常
        throw new ServiceException();
    }

    @RequestMapping("update")
    public void update() {
        // 由adminService调用修改方法，Service中的方法仍可能抛出异常
        throw new ServiceException();
    }

    @ExceptionHandler
    public String handleServiceException(ServiceException e) {
        return "程序运行过程中出现了ServiceException";
    }

    @ExceptionHandler
    public String handleNullPointerException(NullPointerException e){
        return "程序运行过程中出现了NullPointerException";
    }

    @ExceptionHandler
    public String handleRuntimeException(RuntimeException e) {
        return "程序运行过程中出现了RuntimeException";
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        return "程序运行过程中出现了Throwable";
    }
}

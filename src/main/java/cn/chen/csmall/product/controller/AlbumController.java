package cn.chen.csmall.product.controller;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album/")
public class AlbumController {
    @Autowired
    private IAlbumService service;

    @RequestMapping("add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO){
        try {
            service.addNew(albumAddNewDTO);
            return "添加相册成功!";
        } catch (ServiceException e) {
            return "添加相册失败! 相册名称已被占用!";
        }

    }
}

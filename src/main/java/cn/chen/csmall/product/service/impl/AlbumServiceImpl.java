package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.AlbumMapper;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.service.IAlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    private AlbumMapper mapper;

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        // 从参数对象中获取相册名称
        String name = albumAddNewDTO.getName();
        // 调用albumMapper的int countByName(String name)根据名称执行统计
        int countByName = mapper.countByName(name);
        // 判断统计结果是否大于0
        if (countByName>0){
            // 是：抛出异常throw new RuntimeException()
            throw new ServiceException();
        }

        // 创建Album对象
        Album album = new Album();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到Album对象中
        BeanUtils.copyProperties(albumAddNewDTO, album);
        // 调用albumMapper的int insert(Album album)方法将相册数据插入到数据库
        mapper.insert(album);
    }
}

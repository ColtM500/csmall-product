package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.AlbumMapper;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AlbumUpdateNewDTO;
import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import cn.chen.csmall.product.service.IAlbumService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            String message = "添加相册失败, 相册名称已被占用!";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // "".substring(1000); // StringIndexOutOfBoundsException
        // new Album().getName().toString(); // NullPointerException

        // 创建Album对象
        Album album = new Album();
        // 调用BeanUtils.copyProperties()将参数对象的属性值复制到Album对象中
        BeanUtils.copyProperties(albumAddNewDTO, album);
        // 调用albumMapper的int insert(Album album)方法将相册数据插入到数据库
        int rows =  mapper.insert(album);
        if (rows!=1){
            String message = "添加相册失败! 服务器繁忙, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }

    @Override
    public List<AlbumListItemVO> list(){
        List<AlbumListItemVO> list = mapper.list();
        return list;
    }

    @Override
    public AlbumStandardVO getStandardById(Long id) {
        AlbumStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null){
            String message = "获取相册详情失败, 尝试访问的数据不存在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        return queryResult;
    }

    @Override
    public void delete(Long id) {
        AlbumStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult == null){
            String message = "获取相册详情失败, 尝试访问的数据不存在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        int rows = mapper.deleteById(id);
        if (rows!=1){
            String message = "删除相册失败! 服务器繁忙, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
    }

    @Override
    public void updateInfoById(Long id, AlbumUpdateNewDTO albumUpdateNewDTO) {
        //根据id传过去寻找要修改的相册
        AlbumStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult==null){
            String message = "修改相册详情失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        //名称不能重合
        String name = albumUpdateNewDTO.getName();
        int count = mapper.countByNameAndNotId(id, name);
        if (count>0){
            String message = "修改相册详情失败，相册名称已经被占用！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        Album album = new Album();
        BeanUtils.copyProperties(albumUpdateNewDTO, album);
        album.setId(id);
        int rows = mapper.update(album);
        if (rows!=1){
            String message = "修改相册详情失败, 服务器繁忙, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }


}

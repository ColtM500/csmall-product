package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;

import java.util.List;

public interface IAlbumService {

    /**
     * 添加相册
     * @param albumAddNewDTO 相册数据
     */
    void addNew(AlbumAddNewDTO albumAddNewDTO);

    /**
     * 查询相册列表
     * @return 相册列表
     */
    List<AlbumListItemVO> list();
}

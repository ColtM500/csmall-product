package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;

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

    /**
     * 根据id查询相册数据详情
     * @param id 相册id
     * @return 匹配的相册数据 如果妹有匹配的数据 将抛出异常
     */
    AlbumStandardVO getStandardById(Long id);

    /**
     * 根据id删除数据
     * @param id 相册id
     */
    void delete(Long id);


}

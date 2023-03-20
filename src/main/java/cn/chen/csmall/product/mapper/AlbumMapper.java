package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {
    int insert(Album album);

    int insertBatch(List<Album> albumList);

    int deleteById(Long id);

    int deleteByIds(Long[] idList);

    int update(Album album);

    int count();

    AlbumStandardVO getStandardById(Long id);

    //查询数据列表
    List<AlbumListItemVO> list();

}

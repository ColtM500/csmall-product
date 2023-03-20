package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {
    int insert(Album album);

    int insertBatch(List<Album> albumList);

    int deleteById(Long id);

    int deleteByIds(Long[] idList);

    int update(Album album);
}

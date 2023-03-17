package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    int insert(Album album);

    int deleteById(Long id);
}

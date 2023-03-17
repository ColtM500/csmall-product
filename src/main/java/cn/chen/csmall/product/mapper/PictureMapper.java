package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Picture;

public interface PictureMapper {
    int insert(Picture picture);

    int deleteById(long id);
}

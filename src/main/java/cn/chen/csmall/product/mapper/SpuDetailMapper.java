package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SpuDetail;

public interface SpuDetailMapper {
    int insert(SpuDetail spuDetail);

    int deleteById(long id);
}

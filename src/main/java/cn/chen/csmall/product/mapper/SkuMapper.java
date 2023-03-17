package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Sku;

public interface SkuMapper {
    int insert(Sku sku);

    int deleteById(long id);
}

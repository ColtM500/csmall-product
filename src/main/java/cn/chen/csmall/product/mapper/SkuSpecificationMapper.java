package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SkuSpecification;

public interface SkuSpecificationMapper {
    int insert(SkuSpecification skuSpecification);

    int deleteById(long id);
}

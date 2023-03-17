package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;

public interface BrandMapper {
    int insert(Brand brand);

    int deleteById(long id);
}

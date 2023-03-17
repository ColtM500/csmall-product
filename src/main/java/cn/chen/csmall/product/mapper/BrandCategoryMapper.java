package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.BrandCategory;

public interface BrandCategoryMapper {
    int insert(BrandCategory brandCategory);

    int deleteById(long id);
}

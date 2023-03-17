package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;

public interface CategoryMapper {
    int insert(Category category);

    int deleteById(long id);
}

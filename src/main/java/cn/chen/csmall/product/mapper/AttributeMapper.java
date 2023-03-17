package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;

public interface AttributeMapper {
    int insert(Attribute attribute);

    int deleteById(Long id);
}

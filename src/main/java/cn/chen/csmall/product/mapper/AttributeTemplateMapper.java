package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.AttributeTemplate;

public interface AttributeTemplateMapper {
    int insert(AttributeTemplate attributeTemplate);

    int deleteById(Long id);
}

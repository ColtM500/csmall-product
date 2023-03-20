package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.CategoryAttributeTemplate;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;

import java.util.List;

public interface CategoryAttributeTemplateMapper {
    int insert(CategoryAttributeTemplate categoryAttributeTemplate);

    int deleteById(long id);

    int count();

    CategoryStandardVO getStandardById(Long id);

    List<CategoryListItemVO> list();
}

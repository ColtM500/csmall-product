package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;

import java.util.List;

public interface CategoryMapper {
    int insert(Category category);

    int deleteById(long id);

    int count();

    CategoryStandardVO getStandardById(Long id);

    List<CategoryListItemVO> list();
}

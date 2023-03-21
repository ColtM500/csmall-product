package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.entity.CategoryAttributeTemplate;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeTemplateMapper {
    int insert(CategoryAttributeTemplate categoryAttributeTemplate);

    int deleteById(long id);

    int count();

    CategoryStandardVO getStandardById(Long id);

    List<CategoryListItemVO> list();

    int insertBatch(List<CategoryAttributeTemplate> CategoryAttributeTemplate);

    int deleteByIds(Long[] idList);

    int update(CategoryAttributeTemplate categoryAttributeTemplate);
}

package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    int insert(Category category);

    int deleteById(long id);

    int count();

    int countByName(String name);

    int countByNameAndNotId(@Param("id") Long id, @Param("name") String name);

    CategoryStandardVO getStandardById(Long id);

    List<CategoryListItemVO> list();

    int insertBatch(List<Category> categories);

    int deleteByIds(Long[] idList);

    int update(Category category);
}

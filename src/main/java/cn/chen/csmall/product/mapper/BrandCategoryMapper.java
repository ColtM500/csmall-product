package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.entity.BrandCategory;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryMapper {
    int insert(BrandCategory brandCategory);

    int deleteById(long id);

    int count();

    int countByBrand(Long brandId);

    int countByCategory(Long categoryId);

    int countByBrandAndCategory(@Param("brandId") Long brandId, @Param("categoryId") Long categoryId);

    BrandStandardVO getStandardById(Long id);

    List<BrandListItemVO> list();

    int insertBatch(List<BrandCategory> brandCategories);

    int deleteByIds(Long[] idList);

    int update(BrandCategory brandCategory);
}

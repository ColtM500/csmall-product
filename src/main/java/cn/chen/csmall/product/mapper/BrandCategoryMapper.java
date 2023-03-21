package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.entity.BrandCategory;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;

import java.util.List;

public interface BrandCategoryMapper {
    int insert(BrandCategory brandCategory);

    int deleteById(long id);

    int count();

    BrandStandardVO getStandardById(Long id);

    List<BrandListItemVO> list();

    int insertBatch(List<BrandCategory> brandCategories);

    int deleteByIds(Long[] idList);

    int update(BrandCategory brandCategory);
}

package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.pojo.entity.BrandCategory;
import cn.chen.csmall.product.pojo.vo.AttributeListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    int insert(Brand brand);

    int deleteById(long id);

    int count();

    int countByName(String name);

    int countByNameAndNotId(@Param("id") Long id, @Param("name") String name);

    BrandStandardVO getStandardById(Long id);

    List<BrandListItemVO> list();

    int insertBatch(List<Brand> brands);

    int deleteByIds(Long[] idList);

    int update(Brand brand);
}

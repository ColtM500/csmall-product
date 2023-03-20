package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.pojo.vo.AttributeListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;

import java.util.List;

public interface BrandMapper {
    int insert(Brand brand);

    int deleteById(long id);

    int count();

    BrandStandardVO getStandardById(Long id);

    List<BrandListItemVO> list();
}

package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Sku;
import cn.chen.csmall.product.pojo.entity.SkuSpecification;
import cn.chen.csmall.product.pojo.vo.SkuListItemVO;
import cn.chen.csmall.product.pojo.vo.SkuSpecificationListItemVO;
import cn.chen.csmall.product.pojo.vo.SkuSpecificationStandardVO;
import cn.chen.csmall.product.pojo.vo.SkuStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuSpecificationMapper {
    int insert(SkuSpecification skuSpecification);

    int deleteById(long id);

    int count();

    SkuSpecificationStandardVO getStandardById(Long id);

    List<SkuSpecificationListItemVO> list();

    int insertBatch(List<SkuSpecification> skuSpecifications);

    int deleteByIds(Long[] idList);

    int update(SkuSpecification skuSpecification);
}

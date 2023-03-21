package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Spu;
import cn.chen.csmall.product.pojo.entity.SpuDetail;
import cn.chen.csmall.product.pojo.vo.SkuSpecificationListItemVO;
import cn.chen.csmall.product.pojo.vo.SkuSpecificationStandardVO;
import cn.chen.csmall.product.pojo.vo.SpuListItemVO;
import cn.chen.csmall.product.pojo.vo.SpuStandardVO;

import java.util.List;

public interface SpuMapper {
    int insert(Spu spu);

    int deleteById(long id);

    int count();

    SpuStandardVO getStandardById(Long id);

    List<SpuListItemVO> list();

    int insertBatch(List<Spu> spus);

    int deleteByIds(Long[] idList);

    int update(Spu spu);
}

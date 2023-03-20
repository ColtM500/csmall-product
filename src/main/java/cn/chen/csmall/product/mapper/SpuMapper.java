package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Spu;
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
}

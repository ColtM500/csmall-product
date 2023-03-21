package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SkuSpecification;
import cn.chen.csmall.product.pojo.entity.SpuDetail;
import cn.chen.csmall.product.pojo.vo.SpuDetailListItemVO;
import cn.chen.csmall.product.pojo.vo.SpuDetailStandardVO;
import cn.chen.csmall.product.pojo.vo.SpuListItemVO;
import cn.chen.csmall.product.pojo.vo.SpuStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuDetailMapper {
    int insert(SpuDetail spuDetail);

    int deleteById(long id);

    int count();

    SpuDetailStandardVO getStandardById(Long id);

    List<SpuDetailListItemVO> list();

    int insertBatch(List<SpuDetail> spuDetails);

    int deleteByIds(Long[] idList);

    int update(SpuDetail spuDetail);
}

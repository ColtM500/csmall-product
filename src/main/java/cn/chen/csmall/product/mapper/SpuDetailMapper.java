package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SpuDetail;
import cn.chen.csmall.product.pojo.vo.SpuDetailListItemVO;
import cn.chen.csmall.product.pojo.vo.SpuDetailStandardVO;
import cn.chen.csmall.product.pojo.vo.SpuListItemVO;
import cn.chen.csmall.product.pojo.vo.SpuStandardVO;

import java.util.List;

public interface SpuDetailMapper {
    int insert(SpuDetail spuDetail);

    int deleteById(long id);

    int count();

    SpuDetailStandardVO getStandardById(Long id);

    List<SpuDetailListItemVO> list();
}

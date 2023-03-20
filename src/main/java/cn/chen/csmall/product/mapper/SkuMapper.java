package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Sku;
import cn.chen.csmall.product.pojo.vo.PictureListItemVO;
import cn.chen.csmall.product.pojo.vo.PictureStandardVO;
import cn.chen.csmall.product.pojo.vo.SkuListItemVO;
import cn.chen.csmall.product.pojo.vo.SkuStandardVO;

import java.util.List;

public interface SkuMapper {
    int insert(Sku sku);

    int deleteById(long id);

    int count();

    SkuStandardVO getStandardById(Long id);

    List<SkuListItemVO> list();
}

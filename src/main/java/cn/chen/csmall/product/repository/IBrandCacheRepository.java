package cn.chen.csmall.product.repository;

import cn.chen.csmall.product.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandCacheRepository {

    //将品牌列表写入Redis中
    void save(List<BrandListItemVO> brandListItemVOList);

    //从Redis中读取品牌列表
    List<BrandListItemVO> list();
}

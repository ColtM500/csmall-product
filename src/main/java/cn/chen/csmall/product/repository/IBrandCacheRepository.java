package cn.chen.csmall.product.repository;

import cn.chen.csmall.product.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandCacheRepository {

    /**
     * 将品牌列表写入到Redis中
     * @param brandListItemVOList 品牌列表
     */
    void save(List<BrandListItemVO> brandListItemVOList);

    /**
     * 从Redis中读取列表
     * @return 返回品牌列表
     */
    List<BrandListItemVO> list();

    /**
     * 删除Redis中的品牌列表
     * @return 品牌列表
     */
    Boolean deleteList();
}

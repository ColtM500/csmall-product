package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Spu;

public interface SpuMapper {
    int insert(Spu spu);

    int deleteById(long id);
}

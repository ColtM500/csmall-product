package cn.chen.csmall.product.repository.impl;

import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.repository.IBrandCacheRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class BrandCachRepositoryImpl implements IBrandCacheRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void save(List<BrandListItemVO> brandListItemVOList) {
        log.debug("准备向Redis中写入【品牌列表】数据……");
        String key = "brandList";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        for ( BrandListItemVO item: brandListItemVOList) {
            ops.rightPush(key, item);
            log.debug("写入【品牌列表】数据项:{}",item);
        }
        log.debug("向Redis中写入【品牌列表】数据，完成！");
    }

    @Override
    public List<BrandListItemVO> list() {
        String key = "brandList";
        long start = 0;
        long end = -1;
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key, start, end);
        List<BrandListItemVO> brandList = new ArrayList<>();
        for (Serializable serializable: list) {
            brandList.add((BrandListItemVO) serializable);
        }
        return brandList;
    }
}

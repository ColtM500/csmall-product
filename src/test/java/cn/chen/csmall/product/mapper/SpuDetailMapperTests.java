package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SpuDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpuDetailMapperTests {
    @Autowired
    SpuDetailMapper mapper;

    @Test
    void insert(){
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setSpuId(1L);
        spuDetail.setDetail("w");

        mapper.insert(spuDetail);
        System.out.println(spuDetail);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }
}

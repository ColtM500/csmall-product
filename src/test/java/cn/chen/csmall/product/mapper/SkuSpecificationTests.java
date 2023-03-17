package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SkuSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SkuSpecificationTests {
    @Autowired
    SkuSpecificationMapper mapper;

    @Test
    void insert(){
        SkuSpecification skuSpecification = new SkuSpecification();
        skuSpecification.setSkuId(1L);
        skuSpecification.setAttributeId(1L);
        skuSpecification.setAttributeName("ww");
        skuSpecification.setAttributeValue("ww");
        skuSpecification.setUnit("w");
        skuSpecification.setSort(1);

        mapper.insert(skuSpecification);
        System.out.println(skuSpecification);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }
}

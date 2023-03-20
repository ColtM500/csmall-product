package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SkuSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void count(){
        int count = mapper.count();
        System.out.println("统计完成，数据的数量：" + count);
    }

    @Test
    void getStandardById() {
        Long id = 10L;

        Object queryResult = mapper.getStandardById(id);
        System.out.println("根据ID查询数据完成，结果：" + queryResult);
    }

    @Test
    void list() {
        List<?> list = mapper.list();
        System.out.println("查询列表完成，查询结果中数据的数量：" + list.size());
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

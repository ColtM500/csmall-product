package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Sku;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SkuMapperTests {
    @Autowired
    SkuMapper mapper;

    @Test
    void insert(){
        Sku sku = new Sku();
        sku.setId(1L);
        sku.setSpuId(1L);
        sku.setTitle("ww");
        sku.setBarCode("1");
        sku.setAttributeTemplateId(1L);
        sku.setSpecifications("w");
        sku.setAlbumId(1L);
        sku.setPictures("w");
        sku.setPrice(null);
        sku.setStock(1);
        sku.setStockThreshold(1);
        sku.setSales(1);
        sku.setCommentCount(1);
        sku.setPositiveCommentCount(1);
        sku.setSort(1);

        mapper.insert(sku);
        System.out.println(sku);
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

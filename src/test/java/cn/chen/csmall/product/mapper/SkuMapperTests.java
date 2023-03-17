package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Sku;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

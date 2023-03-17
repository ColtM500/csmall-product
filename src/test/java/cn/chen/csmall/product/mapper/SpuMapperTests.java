package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Spu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpuMapperTests {
    @Autowired
    SpuMapper mapper;

    @Test
    void insert(){
        Spu spu = new Spu();
        spu.setId(1L);

        spu.setName("w");
        spu.setTypeNumber("w");
        spu.setTitle("w");
        spu.setDescription("w");
        spu.setListPrice(null);

        spu.setStock(1);
        spu.setStockThreshold(1);
        spu.setUnit("1");
        spu.setBrandId(1L);
        spu.setBrandName("w");

        spu.setCategoryId(1L);
        spu.setCategoryName("w");
        spu.setAttributeTemplateId(1L);
        spu.setAlbumId(1L);
        spu.setPictures("w");

        spu.setKeywords("w");
        spu.setTags("w");
        spu.setSales(1);
        spu.setCommentCount(1);
        spu.setPositiveCommentCount(1);

        spu.setSort(1);
        spu.setIsDeleted(1);
        spu.setIsPublished(1);
        spu.setIsNewArrival(1);
        spu.setIsRecommend(1);

        spu.setIsChecked(1);
        spu.setCheckUser("w");

        mapper.insert(spu);
        System.out.println(spu);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }
}

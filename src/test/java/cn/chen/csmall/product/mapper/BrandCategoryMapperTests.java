package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.BrandCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandCategoryMapperTests {
    @Autowired
    BrandCategoryMapper mapper;

    @Test
    void insert(){
        BrandCategory brandCategory = new BrandCategory();
        brandCategory.setBrandId(1L);
        brandCategory.setCategoryId(1L);

        mapper.insert(brandCategory);
        System.out.println(brandCategory);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }
}

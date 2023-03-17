package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandMapperTests {
    @Autowired
    BrandMapper mapper;

    @Test
    void insert(){
        Brand brand = new Brand();
        brand.setName("aa");
        brand.setPinyin("aa");
        brand.setLogo("aa");
        brand.setDescription("aa");
        brand.setKeywords("aa");
        brand.setSort(1);
        brand.setSales(1);
        brand.setProductCount(1);
        brand.setCommentCount(1);
        brand.setPositiveCommentCount(1);
        brand.setEnable(1);

        mapper.insert(brand);
        System.out.println(brand);
    }

    @Test
    void deleteById(){
        mapper.deleteById(15L);
    }
}

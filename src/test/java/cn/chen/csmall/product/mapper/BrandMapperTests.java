package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

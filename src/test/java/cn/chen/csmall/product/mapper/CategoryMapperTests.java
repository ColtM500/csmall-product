package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTests {
    @Autowired
    CategoryMapper mapper;

    @Test
    void insert(){
        Category category = new Category();
        category.setName("w");
        category.setParentId(1L);
        category.setDepth(1);
        category.setKeywords("w");
        category.setSort(1);
        category.setIcon("w");
        category.setEnable(1);
        category.setIsParent(1);
        category.setIsDisplay(1);

        mapper.insert(category);
        System.out.println(category);
    }

    @Test
    void deleteById(){
        mapper.deleteById(74L);
    }
}

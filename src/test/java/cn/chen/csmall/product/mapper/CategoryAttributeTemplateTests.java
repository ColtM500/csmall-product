package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.CategoryAttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryAttributeTemplateTests {
    @Autowired
    CategoryAttributeTemplateMapper mapper;

    @Test
    void insert(){
        CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
        categoryAttributeTemplate.setCategoryId(1L);
        categoryAttributeTemplate.setAttributeTemplateId(1L);

        mapper.insert(categoryAttributeTemplate);
        System.out.println(categoryAttributeTemplate);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }
}

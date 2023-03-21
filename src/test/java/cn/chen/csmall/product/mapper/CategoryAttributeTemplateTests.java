package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.entity.CategoryAttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void insertBatch() {
        List<CategoryAttributeTemplate> categoryAttributeTemplateList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
            categoryAttributeTemplate.setCategoryId(i + 0L);
            categoryAttributeTemplate.setAttributeTemplateId(i + 0L);
            categoryAttributeTemplateList.add(categoryAttributeTemplate);
        }

        int rows = mapper.insertBatch(categoryAttributeTemplateList);
        System.out.println("批量插入完成，受影响的行数：{}" + rows);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {1L, 3L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
        categoryAttributeTemplate.setId(1L);
        categoryAttributeTemplate.setCategoryId(8L);
        categoryAttributeTemplate.setAttributeTemplateId(8L);

        int rows = mapper.update(categoryAttributeTemplate);
        System.out.println("更新完成，受影响的行数：" + rows);
    }
}

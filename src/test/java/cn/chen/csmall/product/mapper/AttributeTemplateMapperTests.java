package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AttributeTemplateMapperTests {
    @Autowired
    AttributeTemplateMapper mapper;

    @Test
    void insert(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("ww");
        attributeTemplate.setPinyin("ww");
        attributeTemplate.setKeywords("ww");
        attributeTemplate.setSort(1);

        System.out.println("插入数据之前,参数： "+attributeTemplate);
        int rows = mapper.insert(attributeTemplate);
        System.out.println("插入数据完成，受影响的行数：" + rows);
        System.out.println("插入数据之后,参数： " + attributeTemplate);
    }

    @Test
    void deleteById(){
        mapper.deleteById(11L);
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

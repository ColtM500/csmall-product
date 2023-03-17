package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

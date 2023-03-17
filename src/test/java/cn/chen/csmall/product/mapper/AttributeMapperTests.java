package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AttributeMapperTests {
    @Autowired
    AttributeMapper mapper;

    @Test
    void insert(){
        Attribute attribute = new Attribute();
        attribute.setTemplateId(1L);
        attribute.setName("attribute1");
        attribute.setDescription("description1");
        attribute.setType(1);
        attribute.setInputType(2);
        attribute.setValueList("aad");
        attribute.setUnit("www");
        attribute.setSort(1);
        attribute.setIsAllowCustomize(1);

        System.out.println("插入数据之前,参数： "+attribute);
        int rows = mapper.insert(attribute);
        System.out.println("插入数据完成，受影响的行数：" + rows);
        System.out.println("插入数据之后,参数： " + attribute);
    }

    @Test
    void delete(){
        int rows = mapper.deleteById(15L);
        System.out.println(rows);
    }
}

package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    void countByNameAndNotId(){
        Long id = 1L;
        String name = "ww";
        int count = mapper.countByNameAndNotId(id, name);
        System.out.println("统计不是【{" + id + " }】但名称是【{ " + name + " }】的数据的数量，结果：{" +  count + "}");
    }

    @Test
    void countByName(){
        String name = "华为Mate10的属性模板";
        int count = mapper.countByName(name);
        System.out.println("根据名称[" + name + "]统计完成,数据的数量为: " + count);
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
    void insertBatch(){
        LocalDateTime now = LocalDateTime.now();
        List<AttributeTemplate> attributeTemplateList = new ArrayList<>();
        for (int i=1; i<=5 ;i++){
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("批量插入测试数据" + i);
            attributeTemplateList.add(attributeTemplate);
        }
        int rows =  mapper.insertBatch(attributeTemplateList);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {14L, 15L, 16L, 17L, 18L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setId(1L);
        attributeTemplate.setName("新-测试数据001");

        int rows = mapper.update(attributeTemplate);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }
}

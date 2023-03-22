package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.entity.Attribute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    void insertBatch(){
        LocalDateTime now = LocalDateTime.now();
        List<Attribute> attributeList = new ArrayList<>();
        for (int i=1; i<=5 ;i++){
            Attribute attribute = new Attribute();
            attribute.setTemplateId(1L);
            attribute.setName("ww");
            attribute.setDescription("ww");
            attribute.setType(1);
            attribute.setInputType(1);
            attribute.setValueList("ww");
            attribute.setUnit("ww");
            attribute.setSort(1);
            attribute.setIsAllowCustomize(1);
            attributeList.add(attribute);
        }
        int rows =  mapper.insertBatch(attributeList);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {1L, 2L, 3L, 4L, 5L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        Attribute attribute = new Attribute();
        attribute.setId(10L);
        attribute.setName("新-测试数据001");

        int rows = mapper.update(attribute);
        System.out.println("更新完成，受影响的行数：" + rows);
    }

    @Test
    void countByNameAndTemplate(){
        String name = "sb";
        Long templateId = 1L;
        int count = mapper.countByNameAndTemplate(name, templateId);
        System.out.println("根据名称【{" + name+ "}】在属性模板【{ " + templateId + "}】中统计属性数量完成，统计结果：{" + count + "}");
    }

    @Test
    void countByNameAndTemplateAndNotId(){
        Long id = 1L;
        String name = "小米15的颜色属性";
        Long templateId = 1L;
        int count = mapper.countByNameAndTemplateAndNotId(id, name, templateId);
        System.out.println("根据名称【{"+name+"}】且属性模板ID【{"+templateId+"}】且非ID【{"+id+"}】统计数量完成，统计结果：{"+count+"}");

    }
}

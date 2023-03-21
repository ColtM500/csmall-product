package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumTemplateServiceTests {
    @Autowired
    IAttributeTemplateService service;

    @Test
    void test(){
        AttributeTemplateAddNewDTO attributeTemplateAddNewDTO = new AttributeTemplateAddNewDTO();
        attributeTemplateAddNewDTO.setName("222");
        attributeTemplateAddNewDTO.setPinyin("ww");
        attributeTemplateAddNewDTO.setKeywords("wwww");
        attributeTemplateAddNewDTO.setKeywords("keee");
        attributeTemplateAddNewDTO.setSort(1);

        try {
            service.addNew(attributeTemplateAddNewDTO);
            System.out.println("添加属性模板成功!");
        } catch (ServiceException e) {
            System.out.println("添加属性模板失败!已被占用!");
        } catch (RuntimeException e){
            System.out.println("出现了某种RuntimeException: " + e.getClass().getName());
        }
    }
}

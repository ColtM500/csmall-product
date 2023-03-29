package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumUpdateNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
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

    @Test
    void list(){
        List<?> list = service.list();;
        log.debug("查询列表完成，列表中的数据的数量：{}", list.size());
        for (Object item : list){
            log.debug("{}", item);
        }
    }

    @Test
    void getStandardById(){
        Long id = 1L;
        try {
            Object queryResult = service.getStandardById(id);
            System.out.println("查询属性模板详情成功！结果：" + queryResult);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void delete(){
        Long id = 1L;
        try {
            service.delete(id);
            System.out.println("查询属性模板详情成功！结果：");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void update() {
        Long id = 10L;

        AttributeTemplateUpdateNewDTO attributeTemplateUpdateNewDTO = new AttributeTemplateUpdateNewDTO();
        attributeTemplateUpdateNewDTO.setName("新-测试相册001");
        attributeTemplateUpdateNewDTO.setPinyin("新-测试相册的简介001");
        attributeTemplateUpdateNewDTO.setKeywords("w");
        attributeTemplateUpdateNewDTO.setSort(199);

        try {
            service.updateInfoById(id, attributeTemplateUpdateNewDTO);
            System.out.println("修改相册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }
}

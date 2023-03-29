package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandUpdateNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class BrandServiceTests {
    @Autowired
    IBrandService service;

    @Test
    void test(){
        BrandAddNewDTO brandAddNewDTO = new BrandAddNewDTO();
        brandAddNewDTO.setName("2b2b2b22b");

        try {
            service.addNew(brandAddNewDTO);
            System.out.println("添加属性模板成功!");
        } catch (ServiceException e) {
            System.out.println("添加属性模板失败!已被占用!");
        } catch (RuntimeException e){
            System.out.println("出现了某种RuntimeException: " + e.getClass().getName());
        }
    }

    @Test
    void list() {
        List<?> list = service.list();
        log.debug("查询列表完成，列表中的数据的数量：{}", list.size());
        for (Object item : list) {
            log.debug("{}", item);
        }
    }

    @Test
    void getStandardById() {
        Long id = 2L;
        try {
            Object queryResult = service.getStandardById(id);
            log.debug("根据id【{}】查询完成，查询结果：{}", id, queryResult);
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    void delete() {
        Long id = 1L;

        try {
            service.delete(id);
            log.debug("测试删除数据成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    void updateInfoById() {
        Long id = 1L;
        BrandUpdateNewDTO brandUpdateDTO = new BrandUpdateNewDTO();
        brandUpdateDTO.setName("新-品牌");
        brandUpdateDTO.setKeywords("新-关键词");
        brandUpdateDTO.setSort(188);

        try {
            service.updateInfoById(id, brandUpdateDTO);
            log.debug("测试修改数据成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }
}

package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

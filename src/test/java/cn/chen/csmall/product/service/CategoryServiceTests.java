package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTests {
    @Autowired
    ICategoryService service;

    @Test
    void addNew() {
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setParentId(74L);
        categoryAddNewDTO.setName("热带水果");
        categoryAddNewDTO.setKeywords("关键词x,关键词y,关键词z");
        categoryAddNewDTO.setIcon("暂无图标");
        categoryAddNewDTO.setEnable(1);
        categoryAddNewDTO.setIsDisplay(1);
        categoryAddNewDTO.setSort(99);

        try {
            service.addNew(categoryAddNewDTO);
            System.out.println("添加类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }
}

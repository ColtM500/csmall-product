package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
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

    @Test
    void listByParentId(){
        Long parentId = 0L;
        List<?> list = service.listByParentId(parentId);;
        log.debug("查询列表完成，列表中的数据的数量：{}", list.size());
        for (Object item : list){
            log.debug("{}", item);
        }
    }

    @Test
    void delete() {
        Long id = 75L;

        try {
            service.delete(id);
            System.out.println("删除类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void setEnable() {
        Long id = 1L;

        try {
            service.setEnable(id);
            System.out.println("启用类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void setDisable() {
        Long id = 1L;

        try {
            service.setDisable(id);
            System.out.println("禁用类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void setDisplay() {
        Long id = 1L;

        try {
            service.setDisplay(id);
            System.out.println("显示类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

    @Test
    void setHidden() {
        Long id = 1L;

        try {
            service.setHidden(id);
            System.out.println("隐藏类别成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }
}

package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryMapperTests {
    @Autowired
    CategoryMapper mapper;

    @Test
    void insert(){
        Category category = new Category();
        category.setName("w");
        category.setParentId(1L);
        category.setDepth(1);
        category.setKeywords("w");
        category.setSort(1);
        category.setIcon("w");
        category.setEnable(1);
        category.setIsParent(1);
        category.setIsDisplay(1);

        mapper.insert(category);
        System.out.println(category);
    }

    @Test
    void deleteById(){
        mapper.deleteById(74L);
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
}

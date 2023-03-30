package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Brand;
import cn.chen.csmall.product.pojo.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    void countByName(){
        String name = "某个新类别";
        int count = mapper.countByName(name);
        System.out.println("根据名称【{"+name+"}】统计数量完成，统计结果：{"+ count+"}");
    }

    @Test
    void countByNameAndNotId(){
        Long id = 1L;
        String name = "新-类别";
        int count = mapper.countByNameAndNotId(id, name);
        System.out.println("根据名称【{"+name+"}】且非ID【{"+id+"}】统计数量完成，统计结果：{"+count+"}");
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
        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Category category = new Category();
            category.setName("批量插入测试数据" + i);
            categories.add(category);
        }

        int rows = mapper.insertBatch(categories);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {75L, 76L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        Category category = new Category();
        category.setId(75L);
        category.setName("ww");

        int rows = mapper.update(category);
        System.out.println("更新完成，受影响的行数：" + rows);
    }

    @Test
    void listByParentId() {
        Long parentId = 0L;
        List<?> list = mapper.listByParentId(parentId);
        log.debug("查询列表完成，列表中的数据的数量：{}", list.size());
        for (Object item : list) {
            log.debug("{}", item);
        }
    }
}

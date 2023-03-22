package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import cn.chen.csmall.product.pojo.entity.BrandCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BrandCategoryMapperTests {
    @Autowired
    BrandCategoryMapper mapper;

    @Test
    void insert(){
        BrandCategory brandCategory = new BrandCategory();
        brandCategory.setBrandId(1L);
        brandCategory.setCategoryId(1L);

        mapper.insert(brandCategory);
        System.out.println(brandCategory);
    }

    @Test
    void deleteById(){
        mapper.deleteById(1L);
    }

    @Test
    void count(){
        int count = mapper.count();
        System.out.println("统计完成，数据的数量：" + count);
    }

    @Test
    void countByBrand(){
        Long BrandId = 1L;
        int count = mapper.countByBrand(BrandId);
        System.out.println(BrandId+","+count);
    }

    @Test
    void countByCategory(){
        Long CategoryId = 1L;
        int count = mapper.countByCategory(CategoryId);
        System.out.println(CategoryId+","+count);
    }

    @Test
    void countByBrandAndCategory(){
        Long BrandId = 1L;
        Long CategoryId = 1L;
        int count = mapper.countByBrandAndCategory(BrandId, CategoryId);
        System.out.println(BrandId+","+CategoryId+","+count);
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
        List<BrandCategory> brandCategories = new ArrayList<>();
        for (int i=1; i<=5 ;i++){
            BrandCategory brandCategory = new BrandCategory();
            brandCategory.setBrandId(i + 0L);
            brandCategory.setCategoryId(i + 0L);
            brandCategories.add(brandCategory);
        }
        int rows =  mapper.insertBatch(brandCategories);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {4L, 2L, 3L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        BrandCategory brandCategory = new BrandCategory();
        brandCategory.setId(2L);
        brandCategory.setBrandId(8L);
        brandCategory.setCategoryId(8L);

        int rows = mapper.update(brandCategory);
        System.out.println("更新完成，受影响的行数：" + rows);
    }
}

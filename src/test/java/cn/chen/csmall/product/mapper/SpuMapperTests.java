package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Spu;
import cn.chen.csmall.product.pojo.entity.SpuDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpuMapperTests {
    @Autowired
    SpuMapper mapper;

    @Test
    void insert(){
        Spu spu = new Spu();
        spu.setId(1L);

        spu.setName("w");
        spu.setTypeNumber("w");
        spu.setTitle("w");
        spu.setDescription("w");
        spu.setListPrice(null);

        spu.setStock(1);
        spu.setStockThreshold(1);
        spu.setUnit("1");
        spu.setBrandId(1L);
        spu.setBrandName("w");

        spu.setCategoryId(1L);
        spu.setCategoryName("w");
        spu.setAttributeTemplateId(1L);
        spu.setAlbumId(1L);
        spu.setPictures("w");

        spu.setKeywords("w");
        spu.setTags("w");
        spu.setSales(1);
        spu.setCommentCount(1);
        spu.setPositiveCommentCount(1);

        spu.setSort(1);
        spu.setIsDeleted(1);
        spu.setIsPublished(1);
        spu.setIsNewArrival(1);
        spu.setIsRecommend(1);

        spu.setIsChecked(1);
        spu.setCheckUser("w");

        mapper.insert(spu);
        System.out.println(spu);
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
        List<Spu> spuList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Spu spu = new Spu();
            spu.setId(i + 0L);
            spu.setTitle("批量插入测试数据" + i);
            spuList.add(spu);
        }

        int rows = mapper.insertBatch(spuList);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteByIds(){
        Long[] ids = {1L, 3L, 5L};
        int rows = mapper.deleteByIds(ids);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        Spu spu = new Spu();
        spu.setId(1L);
        spu.setTitle("新-测试数据001");

        int rows = mapper.update(spu);
        System.out.println("更新完成，受影响的行数：" + rows);
    }
}

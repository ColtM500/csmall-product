package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.SkuSpecification;
import cn.chen.csmall.product.pojo.entity.SpuDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpuDetailMapperTests {
    @Autowired
    SpuDetailMapper mapper;

    @Test
    void insert(){
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setSpuId(1L);
        spuDetail.setDetail("w");

        mapper.insert(spuDetail);
        System.out.println(spuDetail);
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
        List<SpuDetail> spuDetailList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            SpuDetail spuDetail = new SpuDetail();
            spuDetail.setDetail("批量插入测试数据" + i);
            spuDetailList.add(spuDetail);
        }

        int rows = mapper.insertBatch(spuDetailList);
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
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setId(1L);
        spuDetail.setDetail("新-测试数据001");

        int rows = mapper.update(spuDetail);
        System.out.println("更新完成，受影响的行数：" + rows);
    }
}

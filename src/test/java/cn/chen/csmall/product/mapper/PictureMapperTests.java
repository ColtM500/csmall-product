package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.entity.Picture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PictureMapperTests {
    @Autowired
    PictureMapper mapper;

    @Test
    void insert(){
        Picture picture = new Picture();
        picture.setAlbumId(1L);
        picture.setUrl("ww");

        picture.setIsCover(1);
        picture.setDescription("ww");
        picture.setWidth(1);
        picture.setHeight(1);
        picture.setSort(1);

        mapper.insert(picture);
        System.out.println(picture);
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
    void countByAlbumId(){
        Long albumId = 21L;
        int count = mapper.countByAlbumId(albumId);
        System.out.println("统计完成，根据相册【{"+albumId+"}】统计图片的数量，结果：{"+count+"}");
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
        List<Picture> pictures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Picture attribute = new Picture();
            attribute.setDescription("批量插入测试数据" + i);
            attribute.setSort(200);
            pictures.add(attribute);
        }

        int rows = mapper.insertBatch(pictures);
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
        Picture picture = new Picture();
        picture.setId(1L);
        picture.setDescription("新-测试数据001");

        int rows = mapper.update(picture);
        System.out.println("更新完成，受影响的行数：" + rows);
    }
}

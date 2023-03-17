package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumMapperTests {
    @Autowired
    AlbumMapper mapper;

    @Test
    void insert() {
        Album album = new Album();
        album.setName("测试相册2211");
        album.setDescription("测试相册2211的简介");
        album.setSort(95);

        System.out.println("插入数据之前,参数： "+album);
        int rows = mapper.insert(album);
        System.out.println("插入数据完成，受影响的行数：" + rows);
        System.out.println("插入数据之后,参数： " + album);
    }

    @Test
    void deleteById(){
        mapper.deleteById(11L);
    }
}

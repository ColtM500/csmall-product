package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Picture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

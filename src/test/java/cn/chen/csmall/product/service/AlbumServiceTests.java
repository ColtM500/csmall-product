package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.impl.AlbumServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    AlbumServiceImpl service;

    @Test
    void addNew() {
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("测试相册001");
        albumAddNewDTO.setDescription("测试相册的简介001");
        albumAddNewDTO.setSort(99);

        try {
            service.addNew(albumAddNewDTO);
            System.out.println("添加相册成功！");
        } catch (RuntimeException e) {
            System.out.println("添加相册失败，相册名称已经被占用！");
        }
    }

}


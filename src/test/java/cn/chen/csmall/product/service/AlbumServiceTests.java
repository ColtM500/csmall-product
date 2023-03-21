package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.service.impl.AlbumServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    IAlbumService service;

    @Test
    void addNew() {
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("测试相册001");
        albumAddNewDTO.setDescription("测试相册的简介001");
        albumAddNewDTO.setSort(99);

        try {
            service.addNew(albumAddNewDTO);
            System.out.println("添加相册成功！");
        } catch (ServiceException e){
            System.out.println("添加相册失败, 相册名称已被占用!");
        }
        catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException: " + e.getClass().getName());
        }
    }

}


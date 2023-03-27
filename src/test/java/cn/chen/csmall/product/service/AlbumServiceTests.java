package cn.chen.csmall.product.service;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.service.impl.AlbumServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
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

    @Test
    void list(){
        List<?> list = service.list();;
        log.debug("查询列表完成，列表中的数据的数量：{}", list.size());
        for (Object item : list){
            log.debug("{}", item);
        }
    }

    @Test
    void getStandardById(){
        Long id = 1L;
        try {
            Object queryResult = service.getStandardById(id);
            System.out.println("查询相册详情成功！结果：" + queryResult);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("出现了某种RuntimeException：" + e.getClass().getName());
        }
    }

}


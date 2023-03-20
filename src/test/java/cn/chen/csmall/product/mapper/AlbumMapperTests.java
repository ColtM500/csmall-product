package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    void insertBatch(){
        LocalDateTime now = LocalDateTime.now();
        List<Album> albumList = new ArrayList<>();
        for (int i=1; i<=5 ;i++){
            Album album = new Album();
            album.setName("测试相册" + i);
            album.setDescription("测试相册00" + i + "的简介");
            album.setSort(90 + i);
            album.setGmtCreate(now);
            album.setGmtModified(now);
            albumList.add(album);
        }
        int rows =  mapper.insertBatch(albumList);
        System.out.println("批量插入数据完成, 受影响的行数为: " + rows);
    }

    @Test
    void deleteById(){
        mapper.deleteById(11L);
    }

    @Test
    void deleteByIds(){
        Long[] idList = {13L, 14L, 15L, 16L, 17L};

        int rows = mapper.deleteByIds(idList);
        System.out.println("受影响行数为: " + rows);
    }

    @Test
    void update(){
        Album album = new Album();
        album.setId(5L);
        album.setName("新-测试数据005");

        int rows = mapper.update(album);
        System.out.println("受影响行数: "+rows);
    }

    @Test
    void count(){
        int count = mapper.count();
        System.out.println("统计完成, 数据的数量为: " + count);
    }

    @Test
    void getStandardById(){
        Long id = 1L;

        AlbumStandardVO standardById = mapper.getStandardById(id);
        System.out.println("根据ID查询数据完成，结果：" + standardById);
    }

    @Test
    void list(){
        List<?> list = mapper.list();
        System.out.println("查询列表完成，查询结果中数据的数量：" + list.size());
        for (Object o : list) {
            System.out.println(o);
        }
    }

}

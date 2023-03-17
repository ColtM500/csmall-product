package cn.chen.csmall.product;

import cn.chen.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;

public class LombokTests {

    @Test
    void test(){
        Album album = new Album();
        album.setId(1L);
        album.setName("测试相册1");
        album.setDescription("测试相册简介");
        album.setSort(95);

        System.out.println("ID: "+album.getId());
        System.out.println("Name: "+album.getName());
        System.out.println("Description: "+album.getDescription());
        System.out.println("对象: "+album);
    }
}

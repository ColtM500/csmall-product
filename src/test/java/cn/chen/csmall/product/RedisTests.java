package cn.chen.csmall.product;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTests {

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void setValue(){
        String key = "email2";
        String value = "nmsl@qq,com";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,value);
        log.debug("写入数据成功!");
    }

    @Test
    void getValue(){
        String key = "email2";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("根据Key={}读取Redis中的数据,读取到的Value={}",key,value);
    }

    @Test
    void getEmptyValue(){
        String key = "email222222222";

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("根据Key={}读取Redis中的数据,读取到的Value={}",key,value);
    }

    @Test
    void setObjectValue(){
        String key = "brand1";
        Brand value = new Brand();
        value.setId(1L);
        value.setName("中国人民银行");

        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,value);
        log.debug("写入数据成功!");
    }

    @Test
    void getObjectValue(){
        String key = "brand1";

        ValueOperations<String ,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("根据Key={}读取Redis中的数据，读取到的Value的数据类型：{}",key,value.getClass().getName());
        log.debug("读取到的Value={}",value);
    }

    List<Album> albumList = new ArrayList<>();
    {
        for (int i = 1; i <= 8 ; i++) {
            Album album = new Album();
            album.setId(0L+i);
            album.setName("汪诗意0");
            albumList.add(album);
        }
    }

    @Test
    void rightPush(){
        String key = "albumList";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        for(Album album: albumList){
            ops.rightPush(key, album);
        }
        log.debug("写入数据成功!");
    }

    @Test
    void Range(){
        String key = "albumList";
        long start = 3;
        long end = 7;

        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key,start,end);
        log.debug("根据key={}读取列表成功,列表中的数据的数量:{}",key,list.size());
        for (Serializable serializable:list){
            log.debug("列表项：{}",serializable);
        }
    }

    @Test
    void keys(){
        String pattern = "*";

        Set<String> keys = redisTemplate.keys(pattern);
        log.debug("根据模式({})查找key的集合,结果:{}",pattern,keys);
    }


}

package cn.chen.csmall.product.repository;

import cn.chen.csmall.product.mapper.BrandMapper;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class BrandCacheRepositoryTests {

    @Autowired
    BrandMapper mapper;
    @Autowired
    IBrandCacheRepository repository;

    @Test
    void save(){
        //从MySQL中查出数据
        List<BrandListItemVO> list = mapper.list();
        //向Redis中写入数据
        repository.save(list);
    }

    @Test
    void list(){
        List<BrandListItemVO> list = repository.list();
        for (BrandListItemVO brand: list) {
            log.debug("列表项:{}",brand);
        }
    }
}

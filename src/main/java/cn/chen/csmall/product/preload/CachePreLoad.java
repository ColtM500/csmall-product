package cn.chen.csmall.product.preload;

import cn.chen.csmall.product.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CachePreLoad implements ApplicationRunner {

    @Autowired
    private IBrandService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("开始处理【品牌】数据的缓存预热……");
        service.rebuildCache();
    }
}

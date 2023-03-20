package cn.chen.csmall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Slf4jTests {
    @Test
    void test(){
        log.trace("trance");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        int x = 1;
        int y = 2;
        System.out.println("x = " + x + ", y = " + y + ", x + y = " + ( x + y));
        log.debug(" x = {}, y = {}, x + y ={}",x,y,x+y);
    }
}

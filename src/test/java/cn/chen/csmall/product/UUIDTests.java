package cn.chen.csmall.product;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UUIDTests {

    @Test
    void test(){
        long start = System.currentTimeMillis();
        for (int i=0; i<3000000; i++){
            UUID.randomUUID();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

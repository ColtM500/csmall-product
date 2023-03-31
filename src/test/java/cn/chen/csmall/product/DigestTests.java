package cn.chen.csmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class DigestTests {

    @Test
    void md5Test(){
        String salt = "wwwwwww";
        String rawPassword = "123456";
        String encodedPassword = DigestUtils.md5DigestAsHex((rawPassword+salt).getBytes());
        System.out.println("原文: " + rawPassword);
        System.out.println("密文: " + encodedPassword);
    }
}

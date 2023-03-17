package cn.chen.csmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class CsmallProductApplicationTests {
    @Autowired  //在此处禁止随意添加required=false
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnection() throws Throwable{
        dataSource.getConnection();//调用此方法 会连接数据库
    }


}

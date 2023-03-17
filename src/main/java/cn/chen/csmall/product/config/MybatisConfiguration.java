package cn.chen.csmall.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.chen.csmall.product.mapper")
public class MybatisConfiguration {

}

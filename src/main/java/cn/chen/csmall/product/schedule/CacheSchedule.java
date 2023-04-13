package cn.chen.csmall.product.schedule;

import cn.chen.csmall.product.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheSchedule {

    @Autowired
    private IBrandService service;

    // 关于@Schedule注解参数
    // fixedRate：计划任务的执行频率，以上一次的起始时间来计算下一次的起始时间，以毫秒为单位
    // fixedDelay：计划任务的执行间隔，以上一次的结束时间来计算下一次的起始时间，以毫秒为单位
    // cron：使用1个字符串作为值，此字符串是一个表达式，由6~7部分组成，各部分使用空格分隔
    // -- 在cron中的配置值，各部分表示的意义，从左至右分别是：秒 分 时 日 月 周 [年]
    // -- 各部分值都可以使用通配符
    // -- 使用星号作为通配符：表示任意值
    // -- 使用问号作为通配符：表示不关心此值，只能用于“日”和“周”
    // -- 例如："56 34 12 13 4 ? 2023" 表示 >> 2023年4月13日 12:34:56执行此计划任务，无视当天星期几
    @Scheduled(fixedRate = 2*60*1000)
    public void rebuildCache(){
        log.debug("计划任务开始执行……");
        service.rebuildCache();
    }
}

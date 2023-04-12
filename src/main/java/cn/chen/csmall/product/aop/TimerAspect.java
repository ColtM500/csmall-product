package cn.chen.csmall.product.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 统计Service方法执行耗时的切面类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Aspect
@Component
public class TimerAspect {

    // 【AOP的核心概念】
    // -- 连接点（JoinPoint）：数据处理过程中的某个节点，可能是抛出了某个方法，也可能是抛出了某个异常
    // -- 切入点（PointCut）：选择1个或若干个连接点的表达式
    // -------------------------------------------------
    // 【通知（Advice）注解】
    // -- @Around：环绕，重要
    // -- @Before：在……之前
    // -- @After：在……之后，无论方法成功返回或抛出异常
    // -- @AfterReturning：在方法成功返回（执行到了return，或自然运行结束）之后
    // -- @AfterThrowing：在方法抛出异常之后
    // 以上各通知（Advice）的执行类似于：
    // @Around--开始
    // try {
    //     @Before
    //     执行连接点方法
    //     @AfterReturning
    // } catch (Throwable e) {
    //     @AfterThrowin
    // } finally {
    //     @After
    // }
    // @Around--结束
    // -------------------------------------------------
    // 【切面方法 -- 基于使用@Around】
    // -- 访问权限：应该是公有的访问权限
    // -- 返回值类型：重要：返回值类型使用Object，并且，在方法内部，需要获取参数对象调用proceed()方法的返回结果，并作为切面方法的返回值，否则，相当于连接点方法没有返回值
    // -- 方法名称：自定义
    // -- 参数列表：固定为ProceedingJoinPoint类型的1个参数
    // -- 异常：重要：应该抛出调用proceed()时的异常，除非，你捕获后自行抛出了另一个异常，不允许仅捕获却不抛出
    // -------------------------------------------------
    // 【切入点表达式】
    // 配置在@Around或相关注解的参数中的execution表达式
    // 切入点表达式在execution内部的基本格式是：[修饰符] 返回值类型 [包名.]类名.方法名(参数列表)
    // 在表达式中，可以使用通配符：
    // -- 星号（*）：匹配任何内容，只匹配1次
    // -- 连接2个小数点（..）：匹配任何内容，可以匹配n次（n的最小值为0），只能用于包名和参数列表
    // 注意：如果需要指定类型（例如返回值类型、参数列表），除非是基本数据类型或java.lang包下的类，否则，必须写全限定名
    //                 ↓ 任意返回值类型
    //                   ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 指定的根包名
    //                                                  ↓ 任意接口名或类名
    //                                                    ↓ 任意方法名
    //                                                      ↓↓ 任意n个参数
    @Around("execution(* cn.chen.csmall..product.service.*.*(..))")
    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("开始执行切面方法，即将处理连接点……");
        String typeName = pjp.getTarget().getClass().getName(); // 类型名称
        String methodName = pjp.getSignature().getName();// 方法名称
        Object[] args = pjp.getArgs(); // 方法的参数列表
        log.debug("类型：{}", typeName);
        log.debug("方法：{}", methodName);
        log.debug("参数列表：{}", args);

        long start = System.currentTimeMillis();
        // 调用参数对象的proceed()方法，相当于执行了连接点方法
        // 注意事项-1：
        // 调用proceed()方法时，必须获取返回值，相当于获取了连接点方法的返回结果
        // 获取到的返回结果必须作为切面方法的返回结果，否则，相当于拦截下来连接点方法的返回结果
        // 注意事项-2：
        // 调用的proceed()方法被声明为抛出Throwable，调用此方法时，必须抛出异常
        // 不可以使用try...catch捕获并处理，如果获取并处理，则异常相当于不存在的，对于原本的调用者（Service原本的调用者是Controller），将不会知道曾经出现过此异常
        // 当然，你可以选择先使用try...catch捕获到异常，然后，在catch内部再抛出异常
        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        log.debug("处理连接点结束，执行耗时：{}ms", end - start);
        return result;
    }

}
package cn.chen.csmall.product.filter;


import cn.chen.csmall.product.security.LoginPrincipal;
import cn.chen.csmall.product.web.JsonResult;
import cn.chen.csmall.product.web.ServiceCode;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * <p>处理JWT的过滤器类</p>
 *
 * <p>此过滤器类的主要职责：</p>
 * <ul>
 *     <li>尝试接收客户端携带的JWT</li>
 *     <li>尝试解析接收到的JWT</li>
 *     <li>将解析成功后得到的结果创建为Authentication并存入到SecurityContext中</li>
 * </ul>
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    /**
     * JWT的secretKey
     */
    @Value("${csmall.jwt.secret-key}")
    private String secretKey;
    /**
     * JWT的最小长度值
     */
    public static final int JWT_MIN_LENGTH = 113;

    public JwtAuthorizationFilter() {
        log.debug("创建过滤器对象：JwtAuthorizationFilter");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // 清空SecurityContext，避免【此前携带JWT成功访问后，在接下来的一段时间内不携带JWT也能访问】
        // SecurityContextHolder.clearContext();

        // 根据业内惯用的做法，客户端应该将JWT保存在请求头（Request Header）中的名为Authorization的属性名
        String jwt = request.getHeader("Authorization");
        log.debug("尝试接收客户端携带的JWT数据，JWT：{}", jwt);

        // 判断客户端是否携带了基本有效的JWT
        if (!StringUtils.hasText(jwt) || jwt.length() < JWT_MIN_LENGTH) {
            // 客户端没有携带有铲的JWT，则“放行”，交由后续的组件继续处理
            filterChain.doFilter(request, response);
            // 【重要】终止当前方法的执行，不执行接下来的代码
            return;
        }

        // 客户端携带了基本有效的JWT，则尝试解析JWT
        Claims claims = null;
        response.setContentType("application/json; charset=utf-8;");
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException e) {
            String message = "您的登录信息已过期，请重新登录！";
            log.warn(message);
            JsonResult jsonResult = JsonResult.fail(ServiceCode.ERR_JWT_EXPIRED, message);
            String jsonResultString = JSON.toJSONString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.println(jsonResultString);
            writer.close();
            return;
        } catch (SignatureException e) {
            String message = "非法访问！";
            log.warn(message);
            JsonResult jsonResult = JsonResult.fail(ServiceCode.ERR_JWT_SIGNATURE, message);
            String jsonResultString = JSON.toJSONString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.println(jsonResultString);
            writer.close();
            return;
        } catch (MalformedJwtException e) {
            String message = "非法访问！";
            log.warn(message);
            JsonResult jsonResult = JsonResult.fail(ServiceCode.ERR_JWT_MALFORMED, message);
            String jsonResultString = JSON.toJSONString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.println(jsonResultString);
            writer.close();
            return;
        } catch (Throwable e) {
            String message = "服务器忙，请稍后再次尝试！（开发过程中，如果看到此提示，请检查控制台的信息，并在JWT过滤器补充处理此异常）";
            log.warn(message);
            JsonResult jsonResult = JsonResult.fail(ServiceCode.ERR_UNKNOWN, message);
            String jsonResultString = JSON.toJSONString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.println(jsonResultString);
            writer.close();
        }

        // 从解析JWT的结果中获取数据
        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        String authoritiesJsonString = claims.get("authoritiesJsonString", String.class);
        log.debug("从JWT中解析得到的管理员ID：{}", id);
        log.debug("从JWT中解析得到的管理员用户名：{}", username);
        log.debug("从JWT中解析得到的管理员权限列表的JSON：{}", authoritiesJsonString);

        // 基于解析JWT的结果创建当事人对象（Authentication中的当事人是Object类型的，所以，任何类型都可以作为当事人）
        LoginPrincipal loginPrincipal = new LoginPrincipal();
        loginPrincipal.setId(id);
        loginPrincipal.setUsername(username);

        // 创建Authentication对象
        Object principal = loginPrincipal; // 当事人：使用自定义的数据类型
        Object credentials = null; // 凭证：应该为null
        List<SimpleGrantedAuthority> authorities
                = JSON.parseArray(authoritiesJsonString, SimpleGrantedAuthority.class);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal, credentials, authorities);

        // 将Authentication存入到SecurityContext中
        log.debug("向SecurityContext中存入Authentication：{}", authentication);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // 过滤器链继续执行，相当于“放行”
        filterChain.doFilter(request, response);
    }

}

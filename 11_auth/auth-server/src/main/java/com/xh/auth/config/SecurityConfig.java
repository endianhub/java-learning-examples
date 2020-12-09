package com.xh.auth.config;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author H.Yang
 * @since 2020-12-05
 */
@Component
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 添加授权账户 - 使用手动配置
     * <p>
     * 使用 Security 默认登录页面，密码是 admin ，password 中必须加码，否则会报异常
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("mayikt")
                .password(passwordEncoder().encode("123456"))
                .authorities("/*");

    }

    /**
     * 配置请求的授权规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //所有请求都需要通过认证
                .and()
                .httpBasic() //Basic登录
                .and()
                .csrf().disable(); //关跨域保护
    }


    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("admini"));
    }
}

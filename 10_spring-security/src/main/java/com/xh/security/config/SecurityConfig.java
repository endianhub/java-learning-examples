package com.xh.security.config;

import cn.hutool.crypto.SecureUtil;
import com.xh.security.model.SysPermissionEntity;
import com.xh.security.service.SysPermissionService;
import com.xh.security.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author H.Yang
 * @since 2020-12-05
 */
@Component
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysPermissionService permissionService;

//    /**
//     * 添加授权账户 - 使用手动配置
//     * <p>
//     * 使用 Security 默认登录页面，密码是 admin ，password 中必须加码，否则会报异常
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 设置用户账号信息和权限
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("b1c21019afd435194216c87f414e6cce")
//                .authorities("addMember", "delMember", "updateMember", "showMember")
//                .and()
//                .passwordEncoder(new PasswordEncoder() {
//                    @Override
//                    public String encode(CharSequence charSequence) {
//                        log.info("charSequence : " + charSequence);
//                        return SecureUtil.md5((String) charSequence);
//                    }
//
//                    /**
//                     * @param charSequence 用户输入的密码
//                     * @param encodedPassword 加密后的密码或数据库密码
//                     * @return
//                     */
//                    @Override
//                    public boolean matches(CharSequence charSequence, String encodedPassword) {
//                        boolean result = SecureUtil.md5((String) charSequence).equals(encodedPassword);
//                        log.info("PasswordEncoder : " + result);
//                        return result;
//                    }
//                });
//    }
//
//    /**
//     * 配置请求的授权规则
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 配置httpBasic Http协议认证 form 表单式登录
//        http.authorizeRequests() //开启登录配置
//                .antMatchers("/**")
//                .fullyAuthenticated()
//                .and()
//                .formLogin();
//
//        // 配置httpBasic Http协议认证 弹窗式登录
////        http.authorizeRequests()
////                .antMatchers("/**")
////                .fullyAuthenticated()
////                .and()
////                .httpBasic();
//    }

    /**
     * 添加授权账户 - 从数据库查询权限
     * <p>
     * 使用 Security 默认登录页面，密码是 admin ，password 中必须加码，否则会报异常
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置用户账号信息和权限
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                log.info("charSequence : " + charSequence);
                return SecureUtil.md5((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String encodedPassword) {
                boolean result = SecureUtil.md5((String) charSequence).equals(encodedPassword);
                log.info("PasswordEncoder : " + result);
                return result;
            }
        });
    }

    /**
     * 配置请求的授权规则
     * <p>
     * authenticated：已认证；任何请求没匹配的都需要进行验证，如果用户不是匿名的，则返回true
     * fullyAuthenticated：全面认证；如果用户不是匿名用户或“记住我”用户，则返回true
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO 查询菜单应该先查缓存，if 缓存中没有，则查询数据库
        List<SysPermissionEntity> allPermission = permissionService.list();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();
        allPermission.forEach(permission -> {
            expressionInterceptUrlRegistry
                    // 配置请求地址
                    .antMatchers(permission.getUrl())
                    // 配置请求地址名称
                    .hasAnyAuthority(permission.getPermTag());

        });

        expressionInterceptUrlRegistry
                .antMatchers("/demo").permitAll()// 指定所有用户进行访问指定的url
//                .antMatchers("/admin/**").hasRole("ADMIN")  //指定具有特定权限的用户才能访问特定目录，hasRole()方法指定用户权限，且不需前缀 “ROLE_“
                // 任何请求没匹配的都需要进行验证，只有登录之后就能访问
//                .antMatchers("/**").fullyAuthenticated()
                // .anyRequest().authenticated()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin() // 指定支持基于表单的身份验证/使用默认的登录页面
                .loginPage("/login").permitAll() // 定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
                .and()
                .logout() //logouts 设置
                .logoutUrl("/logout") // 指定注销路径
                .logoutSuccessUrl("/login") //指定成功注销后跳转到指定的页面
                .and()
                .csrf().disable();// 请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数

    }

    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("admini"));
    }
}

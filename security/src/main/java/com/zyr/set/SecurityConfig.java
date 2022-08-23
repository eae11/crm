package com.zyr.set;


import com.zyr.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *  Security 核心配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    IgnoreUrlConfig ignoreUrlConfig;

    /**
     *  认证token
     */
    @Autowired
    private CloudDiyAuthenticationFilter cloudDiyAuthenticationFilter;
    /**
     * 访问权限
     */
    @Autowired
    private CloudAuthenticationEntryPoint cloudAuthenticationEntryPoint;
    /**
     * 校验过滤器
     */
    @Autowired
    private CloudAuthenticationProcessingFilter cloudAuthenticationProcessingFilter;
    /**
     * url所需角色
     */
    @Autowired
    private CloudUrlFilterInvocationSecurityMetadataSource cloudUrlFilterInvocationSecurityMetadataSource;
    /**
     * 认证权限处，按照角色处理
     */
    @Autowired
    private CloudUrlAccessDecisionManager cloudUrlAccessDecisionManager;
    /**
     * 拦截403响应内容
     */
    @Autowired
    private  CloudUrlAccessDeniedHandler urlAccessDeniedHandler;



    /**
     * 权限配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/druid/*");
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();

        // 禁用CSRF 开启跨域

        http.csrf().disable().cors();
        // 未登录认证异常
        http.exceptionHandling().authenticationEntryPoint(cloudAuthenticationEntryPoint);
        http.exceptionHandling().accessDeniedHandler(urlAccessDeniedHandler);
        // url权限认证处理
        registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(cloudUrlFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(cloudUrlAccessDecisionManager);
                return o;
            }
        });

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        for (String url : ignoreUrlConfig.getNocheck().getIgnoreUrls()) {
            registry.antMatchers(url).permitAll();
        }

//        registry.antMatchers("/druid/*", "/druid").permitAll();
//        http.authorizeRequests().antMatchers("/druid/**").permitAll();
        registry.antMatchers("/", "/index", "/toLogin", "/fail", "/druid/*").permitAll();
        registry.antMatchers(HttpMethod.OPTIONS, "/**").denyAll();

        // 自动登录 - cookie储存方式
//        registry.and().rememberMe();
//        // 要认证
//        registry.anyRequest().authenticated();
//        // 跨域
//        registry.and().headers().frameOptions().disable();
//

        // 自定义过滤器在登录时认证用户名、密码
        http.addFilterAt(cloudAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(cloudDiyAuthenticationFilter, BasicAuthenticationFilter.class);
    }

    /**
     * 例外的url
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET,
                "/favicon.ico",
                "/**/*.png",
                "/**/*.ttf",
                "/*.html",
                "/**/css/bootstrap.min.css",
                "/**/js/jquery.min.js",
                "/*/css/bootstrap.min.css",
                "/*/js/jquery.min.js",
                "/**/*.js",
                "/**/*.css",
                "/druid/**",
                "/**/*.js");
        web.ignoring().antMatchers("/druid/**");


    }



}


package com.zyr.set;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  全局解决跨域
 */
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    private CorsConfiguration config() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 2.4.0 之前写法
     */
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration( "/**", config() );
//        return new CorsFilter(source);
//    }

        /**
         * 跨域配置   2.4.0 之后写法
         */
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            //对那些请求路径进行跨域处理
            registry.addMapping("/**")
                    // 允许的请求头，默认允许所有的请求头
                    .allowedHeaders("*")
                    // 允许的方法，默认允许GET、POST、HEAD
                    .allowedMethods("*")
                    // 探测请求有效时间，单位秒
                    .maxAge(1800)
                    // 支持的域
                    .allowedOrigins("*");
        }

}

